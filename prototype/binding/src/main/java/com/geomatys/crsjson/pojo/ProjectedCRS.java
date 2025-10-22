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
 * Derived coordinate reference system defined by a map projection.
 * {@code ProjectedCRS} has a geodetic (usually geographic) coordinate reference system as its base CRS,
 * thereby inheriting a geodetic reference frame, is converted using a map projection,
 * and has a Cartesian coordinate system, usually two-dimensional but may be three-dimensional.
 * In the 3D case the base geographic <abbr>CRS</abbr>s ellipsoidal height is passed through unchanged
 * and forms the vertical axis of the projected <abbr>CRS</abbr>'s Cartesian coordinate system.
 */
public final class ProjectedCRS extends DerivedCRS<GeographicCRS, CartesianCS, GeodeticReferenceFrame>
        implements org.opengis.referencing.crs.ProjectedCRS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public ProjectedCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ProjectedCRS(final org.opengis.referencing.crs.ProjectedCRS impl) {
        super(impl);
        entityType = "ProjectedCRS";
        baseCRS = GeographicCRS.create(impl.getBaseCRS());
        datum = GeodeticReferenceFrame.create(impl.getDatum());
        coordinateSystem = CartesianCS.create(impl.getCoordinateSystem());
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.crs.GeographicCRS getBaseCRS() {
        return baseCRS;
    }

    @Override
    public org.opengis.referencing.operation.Projection getConversionFromBase() {
        return (derivingConversion != null) ? derivingConversion.new Projection() : null;
    }

    @Override
    public org.opengis.referencing.cs.CartesianCS getCoordinateSystem() {
        return coordinateSystem;
    }

    @Override
    public org.opengis.referencing.datum.GeodeticDatum getDatum() {
        return datum;
    }
}
