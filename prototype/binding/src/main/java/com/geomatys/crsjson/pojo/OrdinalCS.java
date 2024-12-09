
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * n-dimensional coordinate system in which every axis uses integers
 * Note: The number of associations shall be equal the dimension of the coordinate system.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coordinateType"
})
@Generated("jsonschema2pojo")
public class OrdinalCS
    extends CoordinateSystem
{

    /**
     * datatype of coordinate values
     * (Required)
     *
     */
    @JsonProperty("coordinateType")
    @JsonPropertyDescription("datatype of coordinate values")
    public String coordinateType;

}
