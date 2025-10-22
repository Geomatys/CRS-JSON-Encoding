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
 * One-dimensional coordinate system used to record time.
 * A {@code TemporalCS} shall have one axis association.
 */
public class TemporalCS extends CoordinateSystem
        implements org.opengis.referencing.cs.TimeCS
{
    /**
     * Datatype of coordinate values.
     * Value can be "integer", "real" or "dateTime".
     */
    @JsonProperty(index = 30, required = true)
    @JsonPropertyDescription("datatype of coordinate values")
    public String coordinateType;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public TemporalCS() {
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
    protected TemporalCS(final org.opengis.referencing.cs.TimeCS impl) {
        super(impl);
        entityType = "TemporalCS";
        // TODO: missing coordinateType.
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static TemporalCS create(org.opengis.referencing.cs.TimeCS impl) {
        return (impl == null || impl instanceof TemporalCS)
                ? (TemporalCS) impl : new TemporalCS(impl);
    }

}
