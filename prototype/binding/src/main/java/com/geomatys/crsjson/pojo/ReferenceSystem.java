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

import java.util.Set;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Information about the reference system.
 */
public class ReferenceSystem extends Entity
        implements org.opengis.referencing.ReferenceSystem
{
    /**
     * Identifier and codespace for reference system.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("identifier and codespace for reference system")
    public Identifier referenceSystemIdentifier;

    /**
     * Type of reference system used.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("type of reference system used")
    public String referenceSystemType;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ReferenceSystem() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ReferenceSystem(org.opengis.referencing.ReferenceSystem impl) {
        entityType = "ReferenceSystem";
        // TODO: get reference system type.
        for (var id : impl.getIdentifiers()) {
            if ((referenceSystemIdentifier = Identifier.create(id)) != null) {
                return;
            }
        }
        referenceSystemIdentifier = Identifier.create(impl.getName());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static ReferenceSystem create(org.opengis.referencing.ReferenceSystem impl) {
        return (impl == null || impl instanceof ReferenceSystem)
                ? (ReferenceSystem) impl : new ReferenceSystem(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.ReferenceIdentifier getName() {
        return referenceSystemIdentifier;
    }

    @Override
    public Collection<org.opengis.util.GenericName> getAlias() {
        return Set.of();
    }

    @Override
    public Set<org.opengis.referencing.ReferenceIdentifier> getIdentifiers() {
        return Set.of();
    }

    @Override
    public org.opengis.metadata.extent.Extent getDomainOfValidity() {
        return null;
    }

    @Override
    public org.opengis.util.InternationalString getScope() {
        return null;
    }

    @Override
    public org.opengis.util.InternationalString getRemarks() {
        return null;
    }

    @Override
    public String toWKT() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
