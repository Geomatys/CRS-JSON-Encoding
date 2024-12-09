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
package com.geomatys.crsjson;

import java.util.Optional;
import java.util.ServiceLoader;
import org.opengis.util.FactoryException;
import org.opengis.util.InternationalString;
import org.opengis.metadata.citation.Citation;
import org.opengis.referencing.cs.CSAuthorityFactory;
import org.opengis.referencing.crs.CRSAuthorityFactory;
import org.opengis.referencing.datum.DatumAuthorityFactory;
import org.opengis.referencing.operation.CoordinateOperationAuthorityFactory;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * Utility methods for writing a <abbr>CRS</abbr> in JSON from an authority code.
 * The actual registry is provided by an {@link CRSAuthorityFactory}.
 */
public class Registry {
    /**
     * The default instance using the {@code CRSAuthorityFactory} found at runtime.
     */
    public static final Registry INSTANCE = new Registry();

    /**
     * Authority factories to use as registries for coordinate system definitions.
     * Those registries will be tried in iteration order.
     */
    private final ServiceLoader<CSAuthorityFactory> csFactories;

    /**
     * Authority factories to use as registries for <abbr>CRS</abbr> definitions.
     * Those registries will be tried in iteration order.
     */
    private final ServiceLoader<CRSAuthorityFactory> crsFactories;

    /**
     * Authority factories to use as registries for datum definitions.
     * Those registries will be tried in iteration order.
     */
    private final ServiceLoader<DatumAuthorityFactory> datumFactories;

    /**
     * Authority factories to use as registries for coordinate operations.
     * Those registries will be tried in iteration order.
     */
    private final ServiceLoader<CoordinateOperationAuthorityFactory> operationFactories;

    /**
     * The writer to use for formatting <abbr>JSON</abbr> documents.
     */
    private final Writer writer;

    /**
     * Creates a new writer.
     */
    public Registry() {
        csFactories        = ServiceLoader.load(CSAuthorityFactory.class);
        crsFactories       = ServiceLoader.load(CRSAuthorityFactory.class);
        datumFactories     = ServiceLoader.load(DatumAuthorityFactory.class);
        operationFactories = ServiceLoader.load(CoordinateOperationAuthorityFactory.class);
        writer = new Writer();
    }

    /**
     * Returns the name of the first implementation found.
     *
     * @return name of the first implementation found at runtime.
     */
    public Optional<String> vendor() {
        for (CRSAuthorityFactory registry : crsFactories) {
            Citation vendor = registry.getVendor();
            if (vendor != null) {
                InternationalString title = vendor.getTitle();
                if (title != null) {
                    return Optional.of(title.toString());
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Formats the object of the specified type from the given authority code as a <abbr>JSON</abbr> document.
     * This method tries all authority factories available at runtime until one recognizes the given code.
     *
     * @param  type  type of object to create.
     * @param  code  the authority code of the object to format.
     * @return the <abbr>JSON</abbr> document for the given object.
     * @throws FactoryException if no authority factory recognize the given code.
     * @throws JsonProcessingException if an error occurred during the serialization.
     */
    public String format(final Type type, final String code) throws FactoryException, JsonProcessingException {
        FactoryException error = null;
        switch (type) {
            case CS: {
                for (CSAuthorityFactory factory : csFactories) try {
                    return writer.write(factory.createCoordinateSystem(code));
                } catch (FactoryException e) {
                    error = addSuppressed(error, e);
                }
                break;
            }
            case CRS: {
                for (CRSAuthorityFactory factory : crsFactories) try {
                    return writer.write(factory.createCoordinateReferenceSystem(code));
                } catch (FactoryException e) {
                    error = addSuppressed(error, e);
                }
                break;
            }
            case DATUM: {
                for (DatumAuthorityFactory factory : datumFactories) try {
                    return writer.write(factory.createDatum(code));
                } catch (FactoryException e) {
                    error = addSuppressed(error, e);
                }
                break;
            }
            case OPERATION: {
                for (CoordinateOperationAuthorityFactory factory : operationFactories) try {
                    return writer.write(factory.createCoordinateOperation(code));
                } catch (FactoryException e) {
                    error = addSuppressed(error, e);
                }
                break;
            }
        }
        if (error != null) throw error;
        throw new FactoryException("No authority factory found for type \"" + type.path + "\".");
    }

    /**
     * Adds the given exception as a suppressed exception of the previous exception.
     *
     * @param  previous  the previous exception, or {@code null} if none.
     * @param  error     the new exception.
     * @return the exception to throw.
     */
    private static FactoryException addSuppressed(FactoryException previous, FactoryException error) {
        if (previous == null) return error;
        previous.addSuppressed(error);
        return previous;
    }

    /**
     * Convenience method printing the <abbr>CRS</abbr> identified by the given code.
     * The result is sent to the standard output stream.
     *
     * @param  code  the authority code of the <abbr>CRS</abbr> to format.
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static void printCRS(final String code) {
        try {
            System.out.println(INSTANCE.format(Type.CRS, code));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
