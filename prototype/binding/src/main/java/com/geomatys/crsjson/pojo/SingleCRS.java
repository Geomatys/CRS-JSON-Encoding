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
 * Coordinate reference system consisting of one coordinate system and either one datum or one datum ensemble.
 *
 * @param  <CS>  the coordinate system type.
 * @param  <D>   the datum type.
 */
public class SingleCRS<CS extends CoordinateSystem, D extends Datum> extends CRS
        implements org.opengis.referencing.crs.SingleCRS
{
    /**
     * Coordinate system that is a component of this single coordinate reference system.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("coordinate system that is a component of this single coordinate reference system")
    public CS coordinateSystem;

    /**
     * Datum that is a component of this single coordinate reference system.
     */
    @JsonProperty(index = 21)
    @JsonPropertyDescription("datum that is a component of this single coordinate reference system")
    public D datum;

    /**
     * Datum ensemble that is a component of this single coordinate reference system.
     */
    @JsonProperty(index = 22)
    @JsonPropertyDescription("datum ensemble that is a component of this single coordinate reference system")
    public DatumEnsemble datumEnsemble;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public SingleCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor
     * and shall initialize the {@link #datum} and {@link #coordinateSystem} fields.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected SingleCRS(final org.opengis.referencing.crs.SingleCRS impl) {
        super(impl);
        entityType = "SingleCRS";
        datumEnsemble = DatumEnsemble.create(getByReflection(org.opengis.referencing.IdentifiedObject.class, impl, "getDatumEnsemble"));
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static SingleCRS<?,?> create(org.opengis.referencing.crs.SingleCRS impl) {
        return switch (impl) {
            case null -> null;
            case SingleCRS<?,?> subtype -> subtype;
            case org.opengis.referencing.crs.GeneralDerivedCRS subtype -> DerivedCRS.createDerived(subtype);
            case org.opengis.referencing.crs.GeodeticCRS       subtype -> GeodeticCRS.create(subtype);
            case org.opengis.referencing.crs.VerticalCRS       subtype -> new VerticalCRS(subtype);
            case org.opengis.referencing.crs.TemporalCRS       subtype -> new TemporalCRS(subtype);
            case org.opengis.referencing.crs.EngineeringCRS    subtype -> new EngineeringCRS(subtype);
            default -> {
                if (isInstanceByReflection("ParametricCRS", impl)) {
                    yield new ParametricCRS(impl);
                }
                final var crs = new SingleCRS<CoordinateSystem, Datum>(impl);
                crs.datum = Datum.create(impl.getDatum());
                crs.coordinateSystem = CoordinateSystem.create(impl.getCoordinateSystem());
                yield crs;
            }
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.cs.CoordinateSystem getCoordinateSystem() {
        return coordinateSystem;
    }

    @Override
    public org.opengis.referencing.datum.Datum getDatum() {
        return datum;
    }
}
