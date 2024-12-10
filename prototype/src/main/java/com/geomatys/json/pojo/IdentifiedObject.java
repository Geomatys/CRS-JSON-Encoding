
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
 * identifications of a CRS-related object
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entityType",
    "name",
    "identifier",
    "alias",
    "remarks"
})
@Generated("jsonschema2pojo")
public class IdentifiedObject {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("entityType")
    public String entityType;
    /**
     * primary name by which this object is identified
     * (Required)
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("primary name by which this object is identified")
    public Object name;
    /**
     * identifier which references elsewhere the object's defining information; alternatively an identifier by which this object can be referenced
     *
     */
    @JsonProperty("identifier")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("identifier which references elsewhere the object's defining information; alternatively an identifier by which this object can be referenced")
    public Set<Object> identifier;
    /**
     * alternative name by which this object is identified
     *
     */
    @JsonProperty("alias")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("alternative name by which this object is identified")
    public Set<String> alias;
    /**
     * comments on or information about this object, including data source information
     *
     */
    @JsonProperty("remarks")
    @JsonPropertyDescription("comments on or information about this object, including data source information")
    public String remarks;

}
