/*
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership. You may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.geomatys.json.generator;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JAnnotationUse;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;


/**
 * Generates the classes from the JSON schema.
 */
public final class ClassGenerator extends DefaultGenerationConfig implements AutoCloseable {
    /**
     * The entry point for invocation on the command-line.
     * This current directory must be the root of the Maven project
     * (the directory containing the {@code pom.xml} file).
     *
     * @param  args  command-line arguments (ignored).
     * @throws IOException if an exception occurred while reading or writing files.
     */
    public static void main(String[] args) throws IOException {
        final var target = Path.of("src/main/java");
        if (!Files.isDirectory(target)) {
            System.err.println("Files not found from the current directory.");
            System.exit(1);
        }
        final var targetPkg = "com.geomatys.json.referencing.pojo";
        final var codeModel = new JCodeModel();
        try (var config = new ClassGenerator()) {
            config.copySchemaAsSeparatedFiles(Path.of("../uml2json/schemas/iso19111.json"));
            var annotator = new Jackson2Annotator(config) {
                @Override
                protected void addJsonTypeInfoAnnotation(JDefinedClass jclass, String propertyName) {
                    JAnnotationUse jsonTypeInfo = jclass.annotate(JsonTypeInfo.class);
                    jsonTypeInfo.param("use", JsonTypeInfo.Id.CLASS);
                    jsonTypeInfo.param("include", JsonTypeInfo.As.EXISTING_PROPERTY);
                    jsonTypeInfo.param("property", "entityType");
                }
            };
            var rules  = new RuleFactory(config, annotator, new SchemaStore());
            var mapper = new SchemaMapper(rules, new SchemaGenerator());
            for (Path source : config.sources) {
                mapper.generate(codeModel, "CRS_JSON", targetPkg, source.toUri().toURL());
            }
            codeModel.build(target.toFile());
        }
        rewrite(target.resolve(targetPkg.replace(".", File.separator)));
    }

    /**
     * The temporary directory where to rewrite the schema as separated files (one per class).
     */
    private final Path directory;

    /**
     * The source files after separation of the JSON file.
     */
    private final List<Path> sources;

    /**
     * Creates a new set of configuration options for {@code jsonschema2pojo}.
     * The option values are provided by the methods at the end of this class.
     */
    private ClassGenerator() throws IOException {
        sources = new ArrayList<>();
        directory = Files.createTempDirectory("CRSJSON");
    }

    /**
     * Copies the JSON schema as separated files, on per class.
     * This is required by the {@code jsonschema2pojo} tool.
     *
     * <h4>WARNING</h4>
     * The code implemented in this method is very fragile as it search for exact matches, including indentation.
     * This code relies on the indentation as an easy way to determine to level of the node being parsed.
     * This is okay for the ShapeChange output, but not in the general case.
     *
     * @param  source  the JSON file to copy.
     * @throws IOException if an error occurred during the copy.
     */
    private void copySchemaAsSeparatedFiles(final Path source) throws IOException {
        BufferedWriter out = null;
        /*
         * We rely on indentation for finding the beginning of a class definition.
         * This is obviously very fragile, but okay for the ShapeChange generated schema.
         */
        final String classPrefix = "    \"";
        final String classSuffix = "\": {";
        final List<String> lines = Files.readAllLines(source);
        for (int i=0; i<lines.size(); i++) {
            String line = lines.get(i);
            if (line == null) {
                continue;       // Because this loop may decide in advance to ignore some lines.
            }
            /*
             * If we find the beginning of a new class definition (recognized by its indentation),
             * close the previous file and create a new one with the name of the class.
             */
            if (line.startsWith(classPrefix) && line.endsWith(classSuffix)) {
                if (out != null) {
                    out.close();
                }
                String classname = line.substring(classPrefix.length(), line.length() - classSuffix.length()).trim();
                Path classfile = directory.resolve(classname + ".json");
                sources.add(classfile);
                out = Files.newBufferedWriter(classfile);
                out.write('{');
                out.newLine();
                continue;
            }
            /*
             * If there is no opened file, the lines are the header: $comment, $schema, $id and $def.
             * Ignore those lines, as they are not part of any class.
             */
            if (out == null) {
                continue;
            }
            /*
             * If we find a "allOf" before "properties" (the later condition is checked by the indentation),
             * this is actually saying that this class is extending another class. Replace by an "extends".
             * Note that "allOf" may also occur inside "properties" and we don't want to replace them.
             */
            if (line.equals("      \"allOf\": [")) {
                assertEquals(lines, ++i, "{");
                out.write("      \"extends\" : {");
                out.newLine();
                out.write(replaceReference(lines.get(++i)));
                out.newLine();
                out.write("      },");
                out.newLine();
                assertEquals(lines, ++i, "},");
                assertEquals(lines, ++i, "{");
                int j=i;
                do ++j;
                while (!lines.get(j).equals("      ]"));
                lines.set(j, null);
                assertEquals(lines, --j, "}");
                lines.set(j, null);
                continue;
            }
            /*
             * All other lines. Copy verbatism, except for reference
             * which are replace by reference to the file.
             */
            out.write(replaceReference(line));
            out.newLine();
        }
        if (out != null) {
            out.close();
        }
    }

    /**
     * Verifies that the line at the given index is equal to the expected value,
     * ignoring leading and trailing spaces.
     */
    private static void assertEquals(final List<String> lines, final int index, final String expected) throws IOException {
        String line = lines.get(index).trim();
        if (!line.equals(expected)) {
            throw new IOException("Expected \"" + expected + "\" but got \"" + line + "\" at line " + index + '.');
        }
    }

    /**
     * Replaces (for example) {@code "$ref": "#/$defs/CoordinateSystem"} by {@code "$ref": "CoordinateSystem.json"}.
     */
    private String replaceReference(String line) {
        final String prefix = "\"$ref\": \"";
        int r = line.indexOf(prefix + "#/$defs/");
        if (r >= 0) {
            int s = line.lastIndexOf('/');
            if (s > r) {
                Path ref = directory.resolve(line.substring(s+1, line.length() - 1) + ".json");
                line = line.substring(0, r + prefix.length()) + ref.toUri() + '"';
            }
        }
        return line;
    }

    /**
     * Returns the index of the line containing the given text.
     *
     * @param  lines   lines where to search.
     * @param  i       index of the first line to check.
     * @param  search  the element to search.
     * @return index equal or greater than <var>i</var> where the element is equal to {@code search}.
     * @throws IndexOutOfBoundsException if the element to search is not found in the given list.
     */
    private static int indexOf(List<String> lines, int i, final String search) {
        do i++;
        while (!lines.get(i).equals(search));
        return i;
    }

    /**
     * Rewrites the result using the platform-specific end-of-line character.
     * Needed because {@code jsonschema2pojo} uses Windows end-of-line even on Linux.
     */
    private static void rewrite(final Path directory) throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                List<String> lines = Files.readAllLines(file);
                Files.write(file, lines);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Deletes all temporary files.
     *
     * @throws IOException if an error occurred while deleting a file.
     */
    @Override
    public void close() throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
        });
        Files.delete(directory);
    }

    /**
     * Whether to include JSON type information.
     * Used to support polymorphic type deserialization.
     */
    @Override
    public boolean isIncludeTypeInfo() {
        return true;
    }

    /**
     * Do not generate additional properties.
     */
    @Override
    public boolean isIncludeAdditionalProperties() {
        return false;
    }

    /**
     * Whether to use include hashCode and equals methods in generated Java types.
     * Omitted because the JSON types generated in this project are only temporary.
     */
    @Override
    public boolean isIncludeHashcodeAndEquals() {
        return false;
    }

    /**
     * Whether to use include a toString method in generated Java types.
     * Omitted because the JSON types generated in this project are only temporary.
     */
    @Override
    public boolean isIncludeToString() {
        return false;
    }

    /**
     * Whether the resulting object should include a constructor with all listed properties as parameters.
     * Not needed because properties will be initialized from GeoAPI interfaces instead.
     */
    @Override
    public boolean isIncludeAllPropertiesConstructor() {
        return false;
    }

    /**
     * Do not initializes constructors, leave them to {@code null}.
     * It avoids writing empty collections at marshaling time.
     */
    @Override
    public boolean isInitializeCollections() {
        return false;
    }

    /**
     * Whether to include getters.
     * Not needed because the <abbr>POJO</abbr> are converted quickly to GeoAPI objects.
     */
    @Override
    public boolean isIncludeGetters() {
        return false;
    }

    /**
     * Whether to include setters.
     * Not needed because the <abbr>POJO</abbr> are created from GeoAPI objects.
     */
    @Override
    public boolean isIncludeSetters() {
        return false;
    }
}
