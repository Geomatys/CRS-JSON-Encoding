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
import org.opengis.referencing.cs.AxisDirection;
import org.opengis.referencing.cs.RangeMeaning;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Definition of a coordinate system axis
 */
public final class CoordinateSystemAxis extends IdentifiedObject
        implements org.opengis.referencing.cs.CoordinateSystemAxis
{
    /**
     * Abbreviation used for this coordinate system axis.
     * This abbreviation is also used to identify the coordinates in the coordinate tuple.
     * Examples: X and Y.
     *
     * <p><b>Note:</b> when the standard symbol is a Greek character the abbreviation may differ from the symbol
     * (for example to constrain symbols to other character sets).</p>
     *
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("abbreviation used for this coordinate system axis")
    public String axisAbbrev;

    /**
     * Direction of positive increase in the coordinate value for a coordinate system axis.
     */
    @JsonProperty(index = 21, required = true)
    @JsonPropertyDescription("direction of positive increase in the coordinate value for a coordinate system axis")
    public String axisDirection;

    /**
     * Spatial unit or temporal quantity used for this coordinate system axis.
     * The value of a coordinate in a coordinate tuple is recorded using this unit.
     * This element is omitted if this axis is part of a DateTimeTemporalCS or an OrdinalCS, and is provided in all other cases.
     */
    @JsonProperty(index = 22)
    @JsonPropertyDescription("spatial unit or temporal quantity used for this coordinate system axis")
    public String axisUnitID;

    /**
     * Minimum value normally allowed for this axis, in the unit for the axis.
     */
    @JsonProperty(index = 23)
    @JsonPropertyDescription("minimum value normally allowed for this axis, in the unit for the axis")
    public Double minimumValue;

    /**
     * Maximum value normally allowed for this axis, in the unit for the axis.
     */
    @JsonProperty(index = 24)
    @JsonPropertyDescription("maximum value normally allowed for this axis, in the unit for the axis")
    public Double maximumValue;

    /**
     * Meaning of the axis value range specified through minimum value and maximum value.
     */
    @JsonProperty(index = 25)
    @JsonPropertyDescription("meaning of the axis value range specified through minimum value and maximum value")
    public String rangeMeaning;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CoordinateSystemAxis() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected CoordinateSystemAxis(final org.opengis.referencing.cs.CoordinateSystemAxis impl) {
        super(impl);
        entityType    = "CoordinateSystemAxis";
        axisAbbrev    = impl.getAbbreviation();
        axisDirection = code(impl.getDirection());
        axisUnitID    = Measure.symbolOf(impl.getUnit());
        minimumValue  = finiteOrNull(impl.getMinimumValue());
        maximumValue  = finiteOrNull(impl.getMaximumValue());
        rangeMeaning  = code(impl.getRangeMeaning());
    }

    /**
     * Returns the given value if it is finite, or {@code null} otherwise.
     *
     * @param  value  the value to marshal.
     * @return the given value if finite, or {@code null} otherwise.
     */
    private static Double finiteOrNull(double value) {
        return Double.isFinite(value) ? value : null;
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static CoordinateSystemAxis create(org.opengis.referencing.cs.CoordinateSystemAxis impl) {
        return (impl == null || impl instanceof CoordinateSystemAxis)
                ? (CoordinateSystemAxis) impl : new CoordinateSystemAxis(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public String getAbbreviation() {
        return axisAbbrev;
    }

    @Override
    public AxisDirection getDirection() {
        return codeForName(axisDirection, AxisDirection::valueOf);
    }

    @Override
    public Unit<?> getUnit() {
        return Measure.unitForSymbol(axisUnitID);
    }

    @Override
    public double getMinimumValue() {
        return (minimumValue != null) ? minimumValue : Double.NEGATIVE_INFINITY;
    }

    @Override
    public double getMaximumValue() {
        return (maximumValue != null) ? maximumValue : Double.POSITIVE_INFINITY;
    }

    @Override
    public RangeMeaning getRangeMeaning() {
        return codeForName(rangeMeaning, RangeMeaning::valueOf);
    }
}
