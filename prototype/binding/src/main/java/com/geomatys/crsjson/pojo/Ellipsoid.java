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
import javax.measure.quantity.Length;
import java.util.OptionalDouble;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Geometric reference surface embedded in 3D Euclidean space formed by an ellipse that is rotated about a main axis.
 * For the Earth the ellipsoid is bi-axial with rotation about the polar axis.
 * This results in an oblate ellipsoid with the midpoint of the foci located at the nominal centre of the Earth.
 */
public final class Ellipsoid extends IdentifiedObject
        implements org.opengis.referencing.datum.Ellipsoid
{
    /**
     * Length of the semi-major axis of the ellipsoid.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("length of the semi-major axis of the ellipsoid")
    public Measure semiMajorAxis;

    /**
     * Definition of the second parameter that defines the shape of a biaxial ellipsoid,
     * or the third parameter that defines a triaxial ellipsoid.
     * A biaxial ellipsoid requires two defining parameters:
     * a semi-major axis and inverse flattening or a semi-major axis and a semi-minor axis.
     * When the reference body is a sphere rather than an ellipsoid, only a single defining parameter is required,
     * namely the radius of the sphere.
     * In that case, the semi-major axis “degenerates” into the radius of the sphere.
     */
    @JsonProperty(index = 21, required = true)
    @JsonPropertyDescription("definition of the second parameter that defines the shape of a biaxial ellipsoid, or the third parameter that defines a triaxial ellipsoid")
    public SecondDefiningParameter secondDefiningParameter;

    /**
     * Length of the semi-median axis of a triaxial ellipsoid.
     * This parameter is not required for a biaxial ellipsoid.
     */
    @JsonProperty(index = 22)
    @JsonPropertyDescription("length of the semi-median axis of a triaxial ellipsoid")
    public Measure semiMedianAxis;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Ellipsoid() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected Ellipsoid(org.opengis.referencing.datum.Ellipsoid impl) {
        super(impl);
        entityType = "Ellipsoid";
        semiMajorAxis = new Measure(impl.getSemiMajorAxis(), impl.getAxisUnit());
        secondDefiningParameter = new SecondDefiningParameter(impl);
        OptionalDouble c = getByReflection(OptionalDouble.class, impl, "getSemiMedianAxis");
        if (c != null && c.isPresent()) {
            semiMedianAxis = new Measure(c.getAsDouble());
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static Ellipsoid create(org.opengis.referencing.datum.Ellipsoid impl) {
        return (impl == null || impl instanceof Ellipsoid)
                ? (Ellipsoid) impl : new Ellipsoid(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public Unit<Length> getAxisUnit() {
        return Measure.unitOf(semiMajorAxis, Length.class);
    }

    @Override
    public double getSemiMajorAxis() {
        return Measure.valueOf(semiMajorAxis);
    }

    @Override
    public double getSemiMinorAxis() {
        // TODO: ensure consistency of units.
        return (secondDefiningParameter != null) ? Measure.valueOf(secondDefiningParameter.semiMinorAxis) : null;
    }

    @Override
    public double getInverseFlattening() {
        return (secondDefiningParameter != null) ? Measure.valueOf(secondDefiningParameter.inverseFlattening) : null;
    }

    @Override
    public boolean isIvfDefinitive() {
        return (secondDefiningParameter != null) && (secondDefiningParameter.inverseFlattening != null);
    }

    @Override
    public boolean isSphere() {
        return (secondDefiningParameter != null) && Boolean.TRUE.equals(secondDefiningParameter.isSphere);
    }
}
