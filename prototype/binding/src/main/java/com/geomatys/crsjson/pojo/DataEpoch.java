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

import java.time.temporal.Temporal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Time attribute of a coordinate set that is referenced to a dynamic <abbr>CRS</abbr>.
 */
public final class DataEpoch extends Entity {
    /**
     * Date at which coordinates are referenced to a dynamic coordinate reference system,
     * expressed as a decimal year in the Gregorian calendar.
     * Example: 2017-03-25 in the Gregorian calendar is epoch 2017.23.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("date at which coordinates are referenced to a dynamic coordinate reference system, expressed as a decimal year in the Gregorian calendar")
    public Measure coordinateEpoch;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DataEpoch() {
    }

    /**
     * Creates a new instance with values initialized from the given object.
     *
     * @param impl value to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static DataEpoch create(final Temporal impl) {
        final var coordinateEpoch = Measure.create(impl);
        if (coordinateEpoch == null) {
            return null;
        }
        final var epoch = new DataEpoch();
        epoch.coordinateEpoch = coordinateEpoch;
        return epoch;
    }
}
