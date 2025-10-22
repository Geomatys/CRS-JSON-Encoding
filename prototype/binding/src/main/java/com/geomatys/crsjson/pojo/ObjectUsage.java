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
 * Usage of a CRS-related object.
 */
public class ObjectUsage extends IdentifiedObject
        // TODO: pending the definition of an interface in GeoAPI.
{
    /**
     * Scope and validity of a CRS-related object.
     */
    @JsonProperty(index = 19)   // Anticipate that this property will be merged with parent class.
    @JsonPropertyDescription("scope and validity of a CRS-related object")
    public ObjectDomain[] domain;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ObjectUsage() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object and given domain.
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl    implementation of a GeoAPI object to serialize.
     * @param domain  scope and validity.
     */
    ObjectUsage(org.opengis.referencing.IdentifiedObject impl, final ObjectDomain domain) {
        super(impl);
        initialize(domain);
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
    protected ObjectUsage(org.opengis.referencing.datum.Datum impl) {
        super(impl);
        initialize(new ObjectDomain(impl));
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
    protected ObjectUsage(org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        super(impl);
        initialize(new ObjectDomain(impl));
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
    protected ObjectUsage(org.opengis.referencing.operation.CoordinateOperation impl) {
        super(impl);
        initialize(new ObjectDomain(impl));
    }

    /**
     * Completes the construction of this instance.
     *
     * @param  node  the node containing the domain of validity.
     */
    private void initialize(ObjectDomain node) {
        entityType = "ObjectUsage";
        if (node.scope != null || node.domainOfValidity != null) {
            domain = new ObjectDomain[] {node};
        }
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    public org.opengis.metadata.extent.Extent getDomainOfValidity() {
        if (domain != null) {
            for (ObjectDomain d : domain) {
                if (d != null) {
                    return d.domainOfValidity;  // Return even if null for consistency with scope.
                }
            }
        }
        return null;
    }

    public org.opengis.util.InternationalString getScope() {
        if (domain != null) {
            for (ObjectDomain d : domain) {
                if (d != null) {
                    return i18n(d.scope);       // Return even if null for consistency with domain of validity.
                }
            }
        }
        return null;
    }
}
