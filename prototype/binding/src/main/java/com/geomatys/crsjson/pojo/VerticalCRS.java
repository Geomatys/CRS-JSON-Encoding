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
 * Coordinate reference system having a vertical reference frame and a one-dimensional vertical coordinate system
 * used for recording gravity-related heights or depths.
 * Vertical <abbr>CRS</abbr>s make use of the direction of gravity to define the concept of height or depth,
 * but the relationship with gravity may not be straightforward.
 *
 * <p><b>Note 1:</b> If the vertical reference frame is dynamic then the vertical CRS is dynamic, else it is static.</p>
 *
 * <p><b>Note 2:</b> Ellipsoidal heights cannot be captured in a vertical coordinate reference system.
 * They exist only as an inseparable part of a 3D coordinate tuple defined in a geographic 3D coordinate reference system.</p>
 */
public final class VerticalCRS extends SingleCRS<VerticalCS, VerticalReferenceFrame>
        implements org.opengis.referencing.crs.VerticalCRS
{
    /**
     * Geoid model or height correction model that is associated with this vertical coordinate reference system.
     */
    @JsonProperty(index = 30)
    @JsonPropertyDescription("geoid model or height correction model that is associated with this vertical coordinate reference system")
    public Transformation[] geoidModel;

    /**
     * Velocity model or deformation grid that is applied to this vertical coordinate reference system.
     */
    @JsonProperty(index = 31)
    @JsonPropertyDescription("velocity model or deformation grid that is applied to this vertical coordinate reference system")
    public PointMotionOperation[] velocityModel;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public VerticalCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected VerticalCRS(final org.opengis.referencing.crs.VerticalCRS impl) {
        super(impl);
        entityType = "VerticalCRS";
        datum = VerticalReferenceFrame.create(impl.getDatum());
        coordinateSystem = VerticalCS.create(impl.getCoordinateSystem());
        // TODO: missing geoidModel, velocityModel.
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static VerticalCRS create(org.opengis.referencing.crs.VerticalCRS impl) {
        return (impl == null || impl instanceof VerticalCRS)
                ? (VerticalCRS) impl : new VerticalCRS(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.cs.VerticalCS getCoordinateSystem() {
        return coordinateSystem;
    }

    @Override
    public org.opengis.referencing.datum.VerticalDatum getDatum() {
        return datum;
    }
}
