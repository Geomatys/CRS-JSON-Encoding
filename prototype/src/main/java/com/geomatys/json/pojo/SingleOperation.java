
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
 * single (not concatenated) coordinate operation
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parameterValue",
    "method"
})
@Generated("jsonschema2pojo")
public class SingleOperation
    extends CoordinateOperation
{

    /**
     * parameter value or parameter value group used by this single operation
     *
     */
    @JsonProperty("parameterValue")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("parameter value or parameter value group used by this single operation")
    public Set<Object> parameterValue;
    /**
     * algorithm or procedure used by this single operation
     * (Required)
     *
     */
    @JsonProperty("method")
    @JsonPropertyDescription("algorithm or procedure used by this single operation")
    public Object method;

}
