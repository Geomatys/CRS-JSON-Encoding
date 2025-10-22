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
 * Base class for geographic area of the resource.
 */
public class GeographicExtent extends Entity
        implements org.opengis.metadata.extent.GeographicExtent
{
    /**
     * Indication of whether the geographic element encompasses an area covered by the data
     * or an area where data are present.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("indication of whether the geographic element encompasses an area where data are present")
    public Integer extentTypeCode;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeographicExtent() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeographicExtent(org.opengis.metadata.extent.GeographicExtent impl) {
        entityType = "GeographicExtent";
        Boolean inclusion = impl.getInclusion();
        if (inclusion != null) {
            extentTypeCode = inclusion ? 1 : 0;
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeographicExtent create(org.opengis.metadata.extent.GeographicExtent impl) {
        return switch (impl) {
            case null -> null;
            case GeographicExtent subtype -> subtype;
            case org.opengis.metadata.extent.GeographicBoundingBox subtype -> new GeographicBoundingBox(subtype);
            case org.opengis.metadata.extent.GeographicDescription subtype -> new GeographicDescription(subtype);
            default -> new GeographicExtent(impl);
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public Boolean getInclusion() {
        return (extentTypeCode == null) ? null : (extentTypeCode != 0);
    }
}
