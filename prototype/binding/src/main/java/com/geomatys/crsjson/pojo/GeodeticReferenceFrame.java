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
 * Definition of the position, scale and orientation of a geocentric Cartesian 3D coordinate system relative to the Earth.
 *
 * <p><b>Note 1:</b> It may also identify a defined ellipsoid (or sphere) that approximates
 * the shape of the Earth and which is centred on and aligned to this geocentric coordinate system.
 * Older geodetic datums define the location and orientation of a defined ellipsoid (or sphere)
 * that approximates the shape of the earth.</p>
 *
 * <p><b>Note 2:</b> In 19111:2007 this class was called GeodeticDatum.</p>
 */
public class GeodeticReferenceFrame extends Datum
        implements org.opengis.referencing.datum.GeodeticDatum
{
    /**
     * Prime meridian which is a component of this geodetic reference frame.
     */
    @JsonProperty(index = 30, required = true)
    @JsonPropertyDescription("prime meridian which is a component of this geodetic reference frame")
    public PrimeMeridian primeMeridian;

    /**
     * Ellipsoid which is a component of this geodetic reference frame.
     */
    @JsonProperty(index = 31)
    @JsonPropertyDescription("ellipsoid which is a component of this geodetic reference frame")
    public Ellipsoid ellipsoid;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeodeticReferenceFrame() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeodeticReferenceFrame(org.opengis.referencing.datum.GeodeticDatum impl) {
        super(impl);
        entityType    = "GeodeticReferenceFrame";
        primeMeridian = PrimeMeridian.create(impl.getPrimeMeridian());
        ellipsoid     = Ellipsoid.create(impl.getEllipsoid());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeodeticReferenceFrame create(org.opengis.referencing.datum.GeodeticDatum impl) {
        return (impl == null || impl instanceof GeodeticReferenceFrame)
                ? (GeodeticReferenceFrame) impl : new GeodeticReferenceFrame(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.datum.PrimeMeridian getPrimeMeridian() {
        return primeMeridian;
    }

    @Override
    public org.opengis.referencing.datum.Ellipsoid getEllipsoid() {
        return ellipsoid;
    }
}
