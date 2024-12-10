
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * one-dimensional coordinate system used to record time
 * Note: A TemporalCS shall have one axis association.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coordinateType"
})
@Generated("jsonschema2pojo")
public class TemporalCS
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
