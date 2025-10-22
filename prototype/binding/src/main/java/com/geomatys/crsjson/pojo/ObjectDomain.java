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
 * Scope and validity of a CRS-related object.
 */
public final class ObjectDomain extends Entity {
    /**
     * Description of usage, or limitations of usage, for which this object is valid.
     * If unknown, enter "not known".
     */
    @JsonProperty(index = 10, required = true)
    @JsonPropertyDescription("description of usage, or limitations of usage, for which this object is valid")
    public String scope;

    /**
     * Spatial and temporal extent in which this object is valid.
     */
    @JsonProperty(index = 11, required = true)
    @JsonPropertyDescription("spatial and temporal extent in which this object is valid")
    public Extent domainOfValidity;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ObjectDomain() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ObjectDomain(org.opengis.referencing.datum.Datum impl) {
        entityType = "ObjectDomain";
        scope = text(impl.getScope());
        domainOfValidity = Extent.create(impl.getDomainOfValidity());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ObjectDomain(org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        scope = text(impl.getScope());
        domainOfValidity = Extent.create(impl.getDomainOfValidity());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ObjectDomain(org.opengis.referencing.operation.CoordinateOperation impl) {
        scope = text(impl.getScope());
        domainOfValidity = Extent.create(impl.getDomainOfValidity());
    }

    /**
     * Initializes the value of this object using reflection.
     * This is used for methods not yet available in GeoAPI 3.0.2.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return {@code this} for method call chaining.
     */
    ObjectDomain setByReflection(final org.opengis.referencing.IdentifiedObject impl) {
        scope = text(getByReflection(org.opengis.util.InternationalString.class, impl, "getScope"));
        domainOfValidity = Extent.create(getByReflection(org.opengis.metadata.extent.Extent.class, impl, "getDomainOfValidity"));
        return this;
    }
}
