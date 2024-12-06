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

import java.io.File;
import com.sun.codemodel.JCodeModel;
import java.io.IOException;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;


/**
 * Generates the classes from the JSON schema.
 */
public final class ClassGenerator extends DefaultGenerationConfig {
    /**
     * The entry point for invocation on the command-line.
     * This current directory must be the root of the Maven project
     * (the directory containing the {@code pom.xml} file).
     *
     * @param  args  command-line arguments (ignored).
     * @throws IOException if an exception occurred while reading or writing files.
     */
    public static void main(String[] args) throws IOException {
        final var source = new File("../uml2json/schemas/iso19111.json");
        final var target = new File("src/main/java/com/geomatys/json/referencing");
        if (!(source.isFile() && target.isDirectory())) {
            System.err.println("Files not found from the current directory.");
            System.exit(1);
        }
        final var codeModel = new JCodeModel();
        final var config = new ClassGenerator();
        final var rules  = new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore());
        final var mapper = new SchemaMapper(rules, new SchemaGenerator());
        mapper.generate(codeModel, "CRS_JSON", "com.geomatys.json.referencing", source.toURI().toURL());
        codeModel.build(target);
    }

    private ClassGenerator() {
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

    /**
     * Whether to mark generated classes with the annotation {@code javax.annotation.Generated}.
     */
    @Override
    public boolean isIncludeGeneratedAnnotation() {
        return false;
    }
}
