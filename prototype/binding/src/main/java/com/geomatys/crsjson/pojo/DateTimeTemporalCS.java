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


/**
 * One-dimensional coordinate system used to record time in dateTime representation as defined in ISO 8601.
 * A {@code DateTimeTemporalCS} shall have one axis association.
 * It does not use {@code axisUnitID}; the temporal quantities are defined through the ISO 8601 representation.
 */
public final class DateTimeTemporalCS extends TemporalCS
        // TODO: pending the definition of an interface in GeoAPI.
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public DateTimeTemporalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected DateTimeTemporalCS(final org.opengis.referencing.cs.TimeCS impl) {
        super(impl);
        entityType = "DateTimeTemporalCS";
        coordinateType = "dateTime";
    }
}
