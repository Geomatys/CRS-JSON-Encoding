
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * definition of a coordinate system axis
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "axisAbbrev",
    "axisDirection",
    "axisUnitID",
    "minimumValue",
    "maximumValue",
    "rangeMeaning"
})
@Generated("jsonschema2pojo")
public class CoordinateSystemAxis
    extends IdentifiedObject
{

    /**
     * abbreviation used for this coordinate system axis; this abbreviation is also used to identify the coordinates in the coordinate tuple
     * Examples: X and Y.
     * Note: when the standard symbol is a Greek character the abbreviation may differ from the symbol (for example to constrain symbols to other character sets).
     * (Required)
     *
     */
    @JsonProperty("axisAbbrev")
    @JsonPropertyDescription("abbreviation used for this coordinate system axis; this abbreviation is also used to identify the coordinates in the coordinate tuple\r\nExamples: X and Y. \r\nNote: when the standard symbol is a Greek character the abbreviation may differ from the symbol (for example to constrain symbols to other character sets).")
    public String axisAbbrev;
    /**
     * direction of positive increase in the coordinate value for a coordinate system axis
     * (Required)
     *
     */
    @JsonProperty("axisDirection")
    @JsonPropertyDescription("direction of positive increase in the coordinate value for a coordinate system axis")
    public String axisDirection;
    /**
     * spatial unit or temporal quantity used for this coordinate system axis
     * Note: The value of a coordinate in a coordinate tuple is recorded using this unit.
     * This element is omitted if this axis is part of a DateTimeTemporalCS or an OrdinalCS, and is provided in all other cases.
     *
     */
    @JsonProperty("axisUnitID")
    @JsonPropertyDescription("spatial unit or temporal quantity used for this coordinate system axis\r\nNote: The value of a coordinate in a coordinate tuple is recorded using this unit. \r\nThis element is omitted if this axis is part of a DateTimeTemporalCS or an OrdinalCS, and is provided in all other cases.")
    public String axisUnitID;
    /**
     * minimum value normally allowed for this axis, in the unit for the axis
     *
     */
    @JsonProperty("minimumValue")
    @JsonPropertyDescription("minimum value normally allowed for this axis, in the unit for the axis")
    public Double minimumValue;
    /**
     * maximum value normally allowed for this axis, in the unit for the axis
     *
     */
    @JsonProperty("maximumValue")
    @JsonPropertyDescription("maximum value normally allowed for this axis, in the unit for the axis")
    public Double maximumValue;
    /**
     * meaning of the axis value range specified through minimumValue and maximumValue
     *
     */
    @JsonProperty("rangeMeaning")
    @JsonPropertyDescription("meaning of the axis value range specified through minimumValue and maximumValue")
    public String rangeMeaning;

}