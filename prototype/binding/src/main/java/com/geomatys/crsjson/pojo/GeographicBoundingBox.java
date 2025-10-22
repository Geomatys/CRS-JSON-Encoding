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
 * Geographic position of the resource.
 */
public final class GeographicBoundingBox extends GeographicExtent
        implements org.opengis.metadata.extent.GeographicBoundingBox
{
    /**
     * The western-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("the western-most coordinate of the limit of the resource extent")
    public double westBoundLongitude;

    /**
     * The eastern-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(index = 21, required = true)
    @JsonPropertyDescription("the eastern-most coordinate of the limit of the resource extent")
    public double eastBoundLongitude;

    /**
     * The southern-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(index = 22, required = true)
    @JsonPropertyDescription("the southern-most coordinate of the limit of the resource extent")
    public double southBoundLatitude;

    /**
     * The northern-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(index = 23, required = true)
    @JsonPropertyDescription("the northern-most coordinate of the limit of the resource extent")
    public double northBoundLatitude;

    /**
     * Creates a new instance with all values initialized to NaN.
     */
    public GeographicBoundingBox() {
        westBoundLongitude = Double.NaN;
        eastBoundLongitude = Double.NaN;
        southBoundLatitude = Double.NaN;
        northBoundLatitude = Double.NaN;
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeographicBoundingBox(org.opengis.metadata.extent.GeographicBoundingBox impl) {
        super(impl);
        entityType = "GeographicBoundingBox";
        westBoundLongitude = impl.getWestBoundLongitude();
        eastBoundLongitude = impl.getEastBoundLongitude();
        southBoundLatitude = impl.getSouthBoundLatitude();
        northBoundLatitude = impl.getNorthBoundLatitude();
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeographicBoundingBox create(org.opengis.metadata.extent.GeographicBoundingBox impl) {
        return (impl == null || impl instanceof GeographicBoundingBox)
                ? (GeographicBoundingBox) impl
                : new GeographicBoundingBox(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public double getWestBoundLongitude() {
        return westBoundLongitude;
    }

    @Override
    public double getEastBoundLongitude() {
        return eastBoundLongitude;
    }

    @Override
    public double getSouthBoundLatitude() {
        return southBoundLatitude;
    }

    @Override
    public double getNorthBoundLatitude() {
        return northBoundLatitude;
    }
}
