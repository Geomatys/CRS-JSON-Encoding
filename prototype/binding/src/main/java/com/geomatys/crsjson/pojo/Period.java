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

import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * A one-dimensional temporal primitive that represent extent in time.
 */
public class Period extends Entity
        implements org.opengis.temporal.TemporalPrimitive
{
    /**
     * The beginning instant at which this period starts.
     * Note: really upper-case "B": ISO defines this property that way.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("the beginning instant at which this period starts")
    public Instant Beginning;

    /**
     * The ending instant at which this period ends.
     * Note: really upper-case "E": ISO defines this property that way.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("the ending instant at which this period ends")
    public Instant Ending;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Period() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected Period(org.opengis.temporal.TemporalPrimitive impl) {
        entityType = "Period";
        // Actually no property that we can get from GeoAPI 3.0.2.
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static Period create(org.opengis.temporal.TemporalPrimitive impl) {
        return (impl == null || impl instanceof Period)
                ? (Period) impl : null;     // TODO
    }
}
