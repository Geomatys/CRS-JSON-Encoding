
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * parameter value or group of parameter values
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entityType",
    "parameter"
})
@Generated("jsonschema2pojo")
public class GeneralParameterValue {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("entityType")
    public String entityType;
    /**
     * parameter or parameter group which has this value or value group
     * (Required)
     *
     */
    @JsonProperty("parameter")
    @JsonPropertyDescription("parameter or parameter group which has this value or value group")
    public Object parameter;

}
