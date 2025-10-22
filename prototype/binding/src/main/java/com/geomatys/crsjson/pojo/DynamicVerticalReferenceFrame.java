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
 * Vertical reference frame in which some of the defining parameters have time dependency.
 * Example: Defining station heights have velocity to account for post-glacial isostatic rebound motion.
 */
public final class DynamicVerticalReferenceFrame extends VerticalReferenceFrame
        // TODO: pending the definition of an interface in GeoAPI.
{
    /**
     * Epoch to which the coordinates of stations defining the dynamic vertical reference frame are referenced,
     * expressed as a decimal year in the Gregorian calendar.
     * Example: 2016,47.
     */
    @JsonProperty(index = 40, required = true)
    @JsonPropertyDescription("epoch to which the coordinates of stations defining the dynamic vertical reference frame are referenced, expressed as a decimal year in the Gregorian calendar")
    public Measure frameReferenceEpoch;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DynamicVerticalReferenceFrame() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected DynamicVerticalReferenceFrame(final org.opengis.referencing.datum.VerticalDatum impl) {
        super(impl);
        entityType = "DynamicVerticalReferenceFrame";
    }
}
