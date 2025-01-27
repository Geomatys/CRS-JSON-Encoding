
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Definition of a coordinate system axis
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoordinateSystemAxis
    extends IdentifiedObject
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
    @JsonProperty(value="axisAbbrev", index=100, required=true)
    @JsonPropertyDescription("abbreviation used for this coordinate system axis")
    public String axisAbbrev;

    /**
     * Direction of positive increase in the coordinate value for a coordinate system axis.
     */
    @JsonProperty(value="axisDirection", index=110, required=true)
    @JsonPropertyDescription("direction of positive increase in the coordinate value for a coordinate system axis")
    public String axisDirection;

    /**
     * Spatial unit or temporal quantity used for this coordinate system axis.
     * The value of a coordinate in a coordinate tuple is recorded using this unit.
     * This element is omitted if this axis is part of a DateTimeTemporalCS or an OrdinalCS, and is provided in all other cases.
     */
    @JsonProperty(value="axisUnitID", index=120)
    @JsonPropertyDescription("spatial unit or temporal quantity used for this coordinate system axis")
    public String axisUnitID;

    /**
     * Minimum value normally allowed for this axis, in the unit for the axis.
     */
    @JsonProperty(value="minimumValue", index=130)
    @JsonPropertyDescription("minimum value normally allowed for this axis, in the unit for the axis")
    public Double minimumValue;

    /**
     * Maximum value normally allowed for this axis, in the unit for the axis.
     */
    @JsonProperty(value="maximumValue", index=140)
    @JsonPropertyDescription("maximum value normally allowed for this axis, in the unit for the axis")
    public Double maximumValue;

    /**
     * Meaning of the axis value range specified through minimum value and maximum value.
     */
    @JsonProperty(value="rangeMeaning", index=150)
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
    public CoordinateSystemAxis(final org.opengis.referencing.cs.CoordinateSystemAxis impl) {
        super(impl);
        entityType    = "CoordinateSystemAxis";
        axisAbbrev    = impl.getAbbreviation();
        axisDirection = code(impl.getDirection());
        axisUnitID    = Measure.uom(impl.getUnit());
        minimumValue  = real(impl.getMinimumValue());
        maximumValue  = real(impl.getMaximumValue());
        rangeMeaning  = code(impl.getRangeMeaning());
    }

    /**
     * Returns the given value if it is finite, or {@code null} otherwise.
     *
     * @param  value  the value to marshal.
     * @return the given value if finite, or {@code null} otherwise.
     */
    private static Double real(double value) {
        return Double.isFinite(value) ? value : null;
    }
}
