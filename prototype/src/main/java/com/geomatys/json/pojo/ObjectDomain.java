
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * scope and validity of a CRS-related object
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scope",
    "domainOfValidity"
})
@Generated("jsonschema2pojo")
public class ObjectDomain {

    /**
     * description of usage, or limitations of usage, for which this object is valid
     * Note: If unknown, enter "not known".
     * (Required)
     *
     */
    @JsonProperty("scope")
    @JsonPropertyDescription("description of usage, or limitations of usage, for which this object is valid \r\nNote: If unknown, enter \"not known\".")
    public String scope;
    /**
     * spatial and temporal extent in which this object is valid
     * (Required)
     *
     */
    @JsonProperty("domainOfValidity")
    @JsonPropertyDescription("spatial and temporal extent in which this object is valid")
    public Object domainOfValidity;

}
