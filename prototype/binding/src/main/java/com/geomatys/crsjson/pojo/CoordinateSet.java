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

import java.util.Arrays;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Description of the coordinate tuples in a coordinate set.
 * A single coordinate tuple is treated as a special case of coordinate set containing only one member.
 */
public final class CoordinateSet extends Entity {
    /**
     * Position described by a coordinate tuple.
     */
    @JsonProperty(index = 10, required = true)
    @JsonPropertyDescription("position described by a coordinate tuple")
    public double[][] coordinateTuple;

    /**
     * Coordinate metadata to which this coordinate set is referenced.
     */
    @JsonProperty(index = 12, required = true)
    @JsonPropertyDescription("coordinate metadata to which this coordinate set is referenced")
    public CoordinateMetadata coordinateMetadata;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CoordinateSet() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected CoordinateSet(final Collection<? extends org.opengis.geometry.DirectPosition> impl) {
        entityType = "CoordinateSet";
        final var tuples = new double[impl.size()][];
        int count = 0;
        org.opengis.referencing.crs.CoordinateReferenceSystem crs = null;
        for (org.opengis.geometry.DirectPosition p : impl) {
            if (p != null) {
                tuples[count++] = p.getCoordinate();
                if (crs == null) {
                    crs = p.getCoordinateReferenceSystem();
                }
            }
        }
        coordinateMetadata = new CoordinateMetadata(crs);
        coordinateTuple = (count == tuples.length) ? tuples : Arrays.copyOf(tuples, count);
    }
}
