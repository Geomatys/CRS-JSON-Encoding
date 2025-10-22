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
 * Coordinate reference system associated with a geodetic reference frame
 * and a three-dimensional Cartesian or spherical coordinate system.
 * If the geodetic reference frame is dynamic then the geodetic CRS is dynamic, else it is static.
 *
 * @param  <CS>  the coordinate system type.
 */
public class GeodeticCRS<CS extends CoordinateSystem> extends SingleCRS<CS, GeodeticReferenceFrame>
        implements org.opengis.referencing.crs.GeodeticCRS
{
    /**
     * Velocity model or deformation grid that may be applied to this geodetic coordinate reference system.
     */
    @JsonProperty(index = 30)
    @JsonPropertyDescription("velocity model or deformation grid that may be applied to this geodetic coordinate reference system")
    public PointMotionOperation[] velocityModel;

    @JsonProperty(index = 31)
    public Transformation[] definingTransformation;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeodeticCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor
     * and shall initialize the {@link #coordinateSystem} field.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeodeticCRS(final org.opengis.referencing.crs.GeodeticCRS impl) {
        super(impl);
        entityType = "GeodeticCRS";
        datum = GeodeticReferenceFrame.create(impl.getDatum());
        // TODO: missing velocityModel, definingTransformation.
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeodeticCRS<?> create(org.opengis.referencing.crs.GeodeticCRS impl) {
        return switch (impl) {
            case null -> null;
            case GeodeticCRS<?> subtype -> subtype;
            case org.opengis.referencing.crs.GeographicCRS subtype -> new GeographicCRS(subtype);
            default -> {
                final var crs = new GeodeticCRS<CoordinateSystem>(impl);
                crs.coordinateSystem = CoordinateSystem.create(impl.getCoordinateSystem());
                yield crs;
            }
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.datum.GeodeticDatum getDatum() {
        return datum;
    }
}
