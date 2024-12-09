
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * time attribute of a coordinate set that is referenced to a dynamic CRS
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entityType",
    "coordinateEpoch"
})
@Generated("jsonschema2pojo")
public class DataEpoch {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("entityType")
    public String entityType;
    /**
     * measure object
     * <p>
     * definition of a measure object
     * (Required)
     *
     */
    @JsonProperty("coordinateEpoch")
    @JsonPropertyDescription("definition of a measure object")
    public Measure coordinateEpoch;

}
