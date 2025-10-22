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

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Coordinate reference system describing the position of points
 * through two or more independent single coordinate reference systems.
 * Two coordinate reference systems are independent of each other if coordinate values
 * in one cannot be converted or transformed into coordinate values in the other.
 */
public final class CompoundCRS extends CRS
        implements org.opengis.referencing.crs.CompoundCRS
{
    /**
     * Coordinate reference system that is a component of this compound coordinate reference system.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("coordinate reference system that is a component of this compound coordinate reference system")
    public SingleCRS<?,?>[] componentReferenceSystem;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CompoundCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected CompoundCRS(final org.opengis.referencing.crs.CompoundCRS impl) {
        super(impl);
        entityType = "CompoundCRS";
        var singles = new ArrayList<org.opengis.referencing.crs.SingleCRS>();
        flatten(impl, singles);
        componentReferenceSystem = array(singles, SingleCRS[]::new, SingleCRS::create);
    }

    /**
     * Appends recursively all single components in the given list.
     *
     * @param  addTo  the list where to add single components.
     */
    private static void flatten(
            final org.opengis.referencing.crs.CompoundCRS crs,
            final List<org.opengis.referencing.crs.SingleCRS> addTo)
    {
        for (org.opengis.referencing.crs.CoordinateReferenceSystem component : crs.getComponents()) {
            if (component instanceof org.opengis.referencing.crs.SingleCRS single) {
                addTo.add(single);
            } else if (component instanceof org.opengis.referencing.crs.CompoundCRS compound) {
                flatten(compound, addTo);
            } else {
                throw new IllegalArgumentException("CRS must be single or compound.");
            }
        }
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public List<org.opengis.referencing.crs.CoordinateReferenceSystem> getComponents() {
        return list(componentReferenceSystem);
    }

    @Override
    public org.opengis.referencing.cs.CoordinateSystem getCoordinateSystem() {
        if (componentReferenceSystem == null) {
            return null;
        }
        final var cs = new CoordinateSystem();
        for (final SingleCRS crs : componentReferenceSystem) {
            if (crs.coordinateSystem != null) {
                cs.axis = concatenate(cs.axis, crs.coordinateSystem.axis);
            }
        }
        return cs;
    }

    /**
     * Returns the concatenation of the given axis.
     * Any of the given array can be null.
     */
    private static CoordinateSystemAxis[] concatenate(CoordinateSystemAxis[] first, CoordinateSystemAxis[] second) {
        if (first == null) return second;
        if (second == null) return first;
        CoordinateSystemAxis[] axis = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, axis, first.length, second.length);
        return axis;
    }
}
