
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
 * definition of a group of related parameters used by a coordinate operation method
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minimumOccurs",
    "maximumOccurs",
    "parameter"
})
@Generated("jsonschema2pojo")
public class OperationParameterGroup
    extends GeneralOperationParameter
{

    /**
     * minimum number of times that values for this parameter group or parameter is required
     * Note: If this attribute is omitted, the minimum number is one.
     *
     */
    @JsonProperty("minimumOccurs")
    @JsonPropertyDescription("minimum number of times that values for this parameter group or parameter is required\r\nNote: If this attribute is omitted, the minimum number is one.")
    public Integer minimumOccurs;
    /**
     * maximum number of times that values for this parameter group or parameter can be included
     * Note: If this attribute is omitted, the maximum number is one.
     *
     */
    @JsonProperty("maximumOccurs")
    @JsonPropertyDescription("maximum number of times that values for this parameter group or parameter can be included\r\nNote: If this attribute is omitted, the maximum number is one.")
    public Integer maximumOccurs;
    /**
     * parameter that is a member of this parameter group
     * (Required)
     *
     */
    @JsonProperty("parameter")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("parameter that is a member of this parameter group")
    public Set<Object> parameter;

}
