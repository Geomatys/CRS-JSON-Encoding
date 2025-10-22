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

import javax.measure.Unit;
import javax.measure.quantity.Angle;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Origin meridian from which longitude values are determined.
 * The default value for prime meridian name is “Greenwich”.
 * When the default applies, the value for the {@link #greenwichLongitude} shall be 0 (degrees).
 */
public final class PrimeMeridian extends IdentifiedObject
        implements org.opengis.referencing.datum.PrimeMeridian
{
    /**
     * Longitude of the prime meridian measured from the internationally-recognised reference meridian.
     * Positive eastward.
     *
     * <p><b>Note 1:</b> Default value: 0 degrees.</p>
     *
     * <p><b>Note 2:</b> If the value of the prime meridian name is “Greenwich”
     * then the value of {@code greenwichLongitude} is required to be 0 degrees.</p>
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("longitude of the prime meridian measured from the internationally-recognised reference meridian")
    public Measure greenwichLongitude;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public PrimeMeridian() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected PrimeMeridian(org.opengis.referencing.datum.PrimeMeridian impl) {
        super(impl);
        entityType = "PrimeMeridian";
        greenwichLongitude = new Measure(impl.getGreenwichLongitude(), impl.getAngularUnit());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static PrimeMeridian create(org.opengis.referencing.datum.PrimeMeridian impl) {
        return (impl == null || impl instanceof PrimeMeridian)
                ? (PrimeMeridian) impl : new PrimeMeridian(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public double getGreenwichLongitude() {
        return Measure.valueOf(greenwichLongitude);
    }

    @Override
    public Unit<Angle> getAngularUnit() {
        return Measure.unitOf(greenwichLongitude, Angle.class);
    }
}
