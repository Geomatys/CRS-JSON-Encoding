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
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Identifications of a <abbr>CRS</abbr>-related object
 */
public final class Identifier extends Entity
        implements org.opengis.referencing.ReferenceIdentifier
{
    /**
     * Person or party responsible for maintenance of the namespace.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("person or party responsible for maintenance of the namespace")
    public Citation authority;

    /**
     * Alphanumeric value identifying an instance in the namespace.
     */
    @JsonProperty(index = 11, required = true)
    @JsonPropertyDescription("alphanumeric value identifying an instance in the namespace")
    public String code;

    /**
     * Identifier or namespace in which the code is valid.
     */
    @JsonProperty(index = 12)
    @JsonPropertyDescription("identifier or namespace in which the code is valid")
    public String codeSpace;

    /**
     * Version identifier for the namespace, as specified by the code authority.
     */
    @JsonProperty(index = 13)
    @JsonPropertyDescription("version identifier for the namespace, as specified by the code authority")
    public String version;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Identifier() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected Identifier(final org.opengis.metadata.Identifier impl) {
        entityType = "Identifier";
        authority = Citation.create(impl.getAuthority());
        code = impl.getCode();
        if (impl instanceof org.opengis.referencing.ReferenceIdentifier r) {
            codeSpace = r.getCodeSpace();
            version   = r.getVersion();
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static Identifier create(org.opengis.metadata.Identifier impl) {
        return (impl == null || impl instanceof Identifier)
                ? (Identifier) impl : new Identifier(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.metadata.citation.Citation getAuthority() {
        return authority;
    }

    @Override
    public String getCodeSpace() {
        return codeSpace;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getVersion() {
        return version;
    }
}
