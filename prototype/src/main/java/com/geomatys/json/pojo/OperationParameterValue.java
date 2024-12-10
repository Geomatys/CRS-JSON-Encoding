
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * parameter value, ordered sequence of values, or reference to a file of parameter values
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parameterValue"
})
@Generated("jsonschema2pojo")
public class OperationParameterValue
    extends GeneralParameterValue
{

    /**
     * value of the coordinate operation parameter
     * (Required)
     *
     */
    @JsonProperty("parameterValue")
    @JsonPropertyDescription("value of the coordinate operation parameter")
    public ParameterValue parameterValue;

}
