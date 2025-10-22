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
 * Non-repeating sequence of coordinate system axes that spans a given coordinate space.
 * A coordinate system is derived from a set of mathematical rules for specifying how coordinates
 * in a given space are to be assigned to points.
 * The coordinate values in a coordinate tuple shall be recorded in the order
 * in which the coordinate system axes associations are recorded.
 */
public class CoordinateSystem extends IdentifiedObject
        implements org.opengis.referencing.cs.CoordinateSystem
{
    /**
     * Coordinate system axis that is a component of this coordinate system.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("coordinate system axis that is a component of this coordinate system")
    public CoordinateSystemAxis[] axis;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CoordinateSystem() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected CoordinateSystem(final org.opengis.referencing.cs.CoordinateSystem impl) {
        super(impl);
        entityType = "CoordinateSystem";
        int dimension = impl.getDimension();
        axis = new CoordinateSystemAxis[dimension];
        for (int i=0; i<dimension; i++) {
            axis[i] = CoordinateSystemAxis.create(impl.getAxis(i));
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static CoordinateSystem create(org.opengis.referencing.cs.CoordinateSystem impl) {
        return switch (impl) {
            case null -> null;
            case CoordinateSystem subtype -> subtype;
            case org.opengis.referencing.cs.CartesianCS   subtype -> new CartesianCS  (subtype);
            case org.opengis.referencing.cs.SphericalCS   subtype -> new SphericalCS  (subtype);
            case org.opengis.referencing.cs.EllipsoidalCS subtype -> new EllipsoidalCS(subtype);
            case org.opengis.referencing.cs.CylindricalCS subtype -> new CylindricalCS(subtype);
            case org.opengis.referencing.cs.PolarCS       subtype -> new PolarCS      (subtype);
            case org.opengis.referencing.cs.AffineCS      subtype -> new AffineCS     (subtype);
            case org.opengis.referencing.cs.VerticalCS    subtype -> new VerticalCS   (subtype);
            case org.opengis.referencing.cs.TimeCS        subtype -> new TemporalCS   (subtype);
            case org.opengis.referencing.cs.LinearCS      subtype -> new LinearCS     (subtype);
            default -> {
                if (isInstanceByReflection("ParametricCS", impl)) {
                    yield new ParametricCS(impl);
                }
                yield new CoordinateSystem(impl);
            }
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public int getDimension() {
        return (axis != null) ? axis.length : 0;
    }

    @Override
    public org.opengis.referencing.cs.CoordinateSystemAxis getAxis(int i) {
        return axis[i];
    }
}
