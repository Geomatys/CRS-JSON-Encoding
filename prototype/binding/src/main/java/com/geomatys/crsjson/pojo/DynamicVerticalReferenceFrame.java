
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * vertical reference frame in which some of the defining parameters have time dependency
 * Example: Defining station heights have velocity to account for post-glacial isostatic rebound motion.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "frameReferenceEpoch"
})
@Generated("jsonschema2pojo")
public class DynamicVerticalReferenceFrame
    extends VerticalReferenceFrame
{

    /**
     * measure object
     * <p>
     * definition of a measure object
     * (Required)
     *
     */
    @JsonProperty("frameReferenceEpoch")
    @JsonPropertyDescription("definition of a measure object")
    public Measure frameReferenceEpoch;

}
