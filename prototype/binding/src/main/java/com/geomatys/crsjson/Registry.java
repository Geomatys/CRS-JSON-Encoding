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
import org.opengis.referencing.AuthorityFactory;
import org.opengis.referencing.crs.CRSAuthorityFactory;
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
     * Authority factories to use as registries for <abbr>CRS</abbr> definitions.
     * Those registries will be tried in iteration order.
     */
    private final ServiceLoader<CRSAuthorityFactory> registries;

    /**
     * The writer to use for formatting <abbr>JSON</abbr> documents.
     */
    private final Writer writer;

    /**
     * Creates a new writer.
     */
    public Registry() {
        registries = ServiceLoader.load(CRSAuthorityFactory.class);
        writer = new Writer();
    }

    /**
     * Returns the name of the first implementation found.
     *
     * @return name of the first implementation found at runtime.
     */
    public Optional<String> vendor() {
        for (CRSAuthorityFactory registry : registries) {
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
     * Formats the <abbr>CRS</abbr> from the given authority code as a JSON document.
     * This method tries all {@link AuthorityFactory} available at runtime until one
     * recognizes the given code.
     *
     * @param  code  the authority code of the <abbr>CRS</abbr> to format.
     * @return the JSON document for the given object.
     * @throws FactoryException if no <abbr>CRS</abbr> authority factory recognize the given code.
     * @throws JsonProcessingException if an error occurred during the serialization.
     */
    public String write(final String code) throws FactoryException, JsonProcessingException {
        FactoryException error = null;
        for (CRSAuthorityFactory registry : registries) {
            try {
                return writer.write(registry.createCoordinateReferenceSystem(code));
            } catch (FactoryException e) {
                if (error == null) error = e;
                else error.addSuppressed(e);
            }
        }
        if (error != null) throw error;
        throw new FactoryException("No CRS authority factory found.");
    }

    /**
     * Convenience method printing the <abbr>CRS</abbr> identified by the given code.
     *
     * @param  code  the authority code of the <abbr>CRS</abbr> to format.
     */
    public static void printCRS(final String code) {
        try {
            System.out.println(INSTANCE.write(code));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
