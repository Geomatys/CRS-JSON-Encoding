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
 * Vertical domain of resource.
 */
public final class VerticalExtent extends Entity
        implements org.opengis.metadata.extent.VerticalExtent
{
    /**
     * The lowest vertical extent contained in the resource.
     */
    @JsonProperty(index = 10, required = true)
    @JsonPropertyDescription("the lowest vertical extent contained in the resource")
    public Double minimumValue;

    /**
     * The highest vertical extent contained in the resource.
     */
    @JsonProperty(index = 11, required = true)
    @JsonPropertyDescription("the highest vertical extent contained in the resource")
    public Double maximumValue;

    /**
     * The vertical coordinate reference system to which
     * the maximum and minimum elevation values are measured.
     */
    @JsonProperty(index = 12)
    @JsonPropertyDescription("the vertical coordinate reference system to which the maximum and minimum elevation values are measured")
    public VerticalCRS verticalCRS;

    /**
     * identifies the vertical coordinate reference system used for the minimum and maximum values.
     */
    @JsonProperty(index = 13)
    @JsonPropertyDescription("identifies the vertical coordinate reference system used for the minimum and maximum values")
    public ReferenceSystem verticalCRSId;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public VerticalExtent() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected VerticalExtent(org.opengis.metadata.extent.VerticalExtent impl) {
        entityType = "VerticalExtent";
        minimumValue = impl.getMinimumValue();
        maximumValue = impl.getMaximumValue();
        verticalCRS = VerticalCRS.create(impl.getVerticalCRS());
        if (false) {
            // Ignored for now because redundant with above vertical CRS.
            verticalCRSId = ReferenceSystem.create(impl.getVerticalCRS());
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static VerticalExtent create(org.opengis.metadata.extent.VerticalExtent impl) {
        return (impl == null || impl instanceof VerticalExtent)
                ? (VerticalExtent) impl : new VerticalExtent(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public Double getMinimumValue() {
        return minimumValue;
    }

    @Override
    public Double getMaximumValue() {
        return maximumValue;
    }

    @Override
    public org.opengis.referencing.crs.VerticalCRS getVerticalCRS() {
        return verticalCRS;
    }
}
