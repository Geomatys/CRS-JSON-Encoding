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
 * Metadata required to reference coordinates.
 */
public final class CoordinateMetadata extends Entity {
    /**
     * Identifier of the coordinate reference system to which a coordinate set is referenced.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("identifier of the coordinate reference system to which a coordinate set is referenced")
    public Identifier crsID;

    /**
     * Full definition of the coordinate reference system to which a coordinate set is referenced.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("full definition of the coordinate reference system to which a coordinate set is referenced")
    public CRS crs;

    /**
     * Epoch at which a coordinate set referenced to a dynamic CRS is valid.
     * Required if the <abbr>CRS</abbr> is dynamic, otherwise should no be given.
     */
    @JsonProperty(index = 12)
    @JsonPropertyDescription("epoch at which a coordinate set referenced to a dynamic CRS is valid")
    public DataEpoch coordinateEpoch;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CoordinateMetadata() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected CoordinateMetadata(final org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        entityType = "CoordinateMetadata";
        crs = CRS.create(impl);
    }
}
