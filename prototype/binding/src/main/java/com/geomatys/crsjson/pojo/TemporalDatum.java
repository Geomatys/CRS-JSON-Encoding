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

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Definition of the relationship of a temporal coordinate system to an object.
 * The object is normally time on the Earth.
 */
public final class TemporalDatum extends Datum
        implements org.opengis.referencing.datum.TemporalDatum
{
    /**
     * Date and time to which temporal coordinates are referenced, expressed in conformance with ISO 8601.
     */
    @JsonProperty(index = 30, required = true)
    @JsonPropertyDescription("date and time to which temporal coordinates are referenced, expressed in conformance with ISO 8601")
    public Date origin;

    /**
     * Specification of the calendar to which a temporal origin is referenced.
     */
    @JsonProperty(index = 31, required = true)
    @JsonPropertyDescription("specification of the calendar to which a temporal origin is referenced")
    public String calendar;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public TemporalDatum() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected TemporalDatum(final org.opengis.referencing.datum.TemporalDatum impl) {
        super(impl);
        entityType = "TemporalDatum";
        origin = impl.getOrigin();
        // TODO: missing calendar
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static TemporalDatum create(org.opengis.referencing.datum.TemporalDatum impl) {
        return (impl == null || impl instanceof TemporalDatum)
                ? (TemporalDatum) impl : new TemporalDatum(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public Date getOrigin() {
        return (origin != null) ? (Date) origin.clone() : null;
    }
}
