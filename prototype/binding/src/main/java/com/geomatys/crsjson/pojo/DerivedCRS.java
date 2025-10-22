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
 * Single coordinate reference system that is defined through the application of a specified coordinate conversion to
 * the definition of a previously established single coordinate reference system referred to as the base <abbr>CRS</abbr>.
 * A derived coordinate reference system inherits its datum (or datum ensemble) from its base <abbr>CRS</abbr>.
 * The coordinate conversion between the base and derived coordinate reference system is implemented using the
 * parameters and formula(s) specified in the definition of the coordinate conversion.
 *
 * @param  <BCRS>  the base CRS type.
 * @param  <CS>    the coordinate system type.
 * @param  <D>     the datum type.
 */
public class DerivedCRS<BCRS extends CRS, CS extends CoordinateSystem, D extends Datum> extends SingleCRS<CS, D>
        implements org.opengis.referencing.crs.GeneralDerivedCRS
{
    /**
     * Coordinate reference system that is the base <abbr>CRS</abbr> for this derived coordinate reference system.
     */
    @JsonProperty(index = 30, required = true)
    @JsonPropertyDescription("coordinate reference system that is the base CRS for this derived coordinate reference system")
    public BCRS baseCRS;

    /**
     * Conversion that is a component of this derived coordinate reference system.
     */
    @JsonProperty(index = 31, required = true)
    @JsonPropertyDescription("conversion that is a component of this derived coordinate reference system")
    public Conversion derivingConversion;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DerivedCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor and
     * initialize the {@link #baseCRS}, {@link #coordinateSystem} and {@link #datum} fields.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected DerivedCRS(final org.opengis.referencing.crs.GeneralDerivedCRS impl) {
        super(impl);
        entityType = "DerivedCRS";
        org.opengis.referencing.operation.Conversion c = impl.getConversionFromBase();
        if (c != null) {
            derivingConversion = new Conversion(c, false);
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static DerivedCRS<?,?,?> createDerived(final org.opengis.referencing.crs.GeneralDerivedCRS impl) {
        return switch (impl) {
            case null -> null;
            case DerivedCRS<?,?,?> subtype -> subtype;
            case org.opengis.referencing.crs.ProjectedCRS subtype -> new ProjectedCRS(subtype);
            default -> {
                var crs = new DerivedCRS<CRS, CoordinateSystem, Datum>(impl);
                crs.baseCRS = CRS.create(impl.getBaseCRS());
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
    public org.opengis.referencing.crs.CoordinateReferenceSystem getBaseCRS() {
        return baseCRS;
    }

    @Override
    public org.opengis.referencing.operation.Conversion getConversionFromBase() {
        return derivingConversion;
    }
}
