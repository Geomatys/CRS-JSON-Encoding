
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
 * identification of an object used as a parameter in a coordinate transformation, point motion operation or coordinate conversion
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entityType",
    "identifier"
})
@Generated("jsonschema2pojo")
public class GeographicObject {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("entityType")
    public String entityType;
    /**
     * identifier of the geographic object
     *
     */
    @JsonProperty("identifier")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("identifier of the geographic object")
    public Set<Object> identifier;

}
