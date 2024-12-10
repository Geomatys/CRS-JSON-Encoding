
package com.geomatys.json.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * group of related parameter values
 * Note: The same group can be repeated more than once in a coordinate operation or higher level ParameterValueGroup, if those instances contain different values of one or more ParameterValues which suitably distinguish among those groups.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parameterValue",
    "group"
})
@Generated("jsonschema2pojo")
public class ParameterValueGroup
    extends GeneralParameterValue
{

    /**
     * value in this value group
     * (Required)
     *
     */
    @JsonProperty("parameterValue")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("value in this value group")
    public Set<Object> parameterValue;
    /**
     * parameter group associated with this value group
     * (Required)
     *
     */
    @JsonProperty("group")
    @JsonPropertyDescription("parameter group associated with this value group")
    public Object group;

}
