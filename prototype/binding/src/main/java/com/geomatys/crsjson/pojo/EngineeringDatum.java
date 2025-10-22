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
 * Definition of the origin and orientation of an engineering coordinate reference system.
 * The origin can be fixed with respect to the Earth (such as a defined point at a construction site),
 * or be a defined point on a moving vehicle (such as on a ship or satellite), or a defined point of an image.
 */
public final class EngineeringDatum extends Datum
        implements org.opengis.referencing.datum.EngineeringDatum
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public EngineeringDatum() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected EngineeringDatum(final org.opengis.referencing.datum.EngineeringDatum impl) {
        super(impl);
        entityType = "EngineeringDatum";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static EngineeringDatum create(org.opengis.referencing.datum.EngineeringDatum impl) {
        return (impl == null || impl instanceof EngineeringDatum)
                ? (EngineeringDatum) impl : new EngineeringDatum(impl);
    }
}
