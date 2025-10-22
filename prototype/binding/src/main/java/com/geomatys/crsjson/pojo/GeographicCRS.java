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
 * Coordinate reference system associated with a geodetic reference frame
 * and a two- or three-dimensional ellipsoidal coordinate system.
 * If the geodetic reference frame is dynamic then the geographic <abbr>CRS</abbr> is dynamic, else it is static.
 */
public final class GeographicCRS extends GeodeticCRS<EllipsoidalCS>
        implements org.opengis.referencing.crs.GeographicCRS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeographicCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeographicCRS(final org.opengis.referencing.crs.GeographicCRS impl) {
        super(impl);
        entityType = "GeographicCRS";
        coordinateSystem = EllipsoidalCS.create(impl.getCoordinateSystem());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static GeographicCRS create(final org.opengis.referencing.crs.GeographicCRS impl) {
        return (impl == null || impl instanceof GeographicCRS)
                ? (GeographicCRS) impl : new GeographicCRS(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.cs.EllipsoidalCS getCoordinateSystem() {
        return coordinateSystem;
    }
}
