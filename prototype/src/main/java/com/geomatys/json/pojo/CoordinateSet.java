
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
 * description of the coordinate tuples in a coordinate set
 * Note: A single coordinate tuple is treated as a special case of coordinate set containing only one member.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entityType",
    "coordinateTuple",
    "coordinateMetadata"
})
@Generated("jsonschema2pojo")
public class CoordinateSet {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("entityType")
    public String entityType;
    /**
     * position described by a coordinate tuple
     * (Required)
     *
     */
    @JsonProperty("coordinateTuple")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("position described by a coordinate tuple")
    public Set<Object> coordinateTuple;
    /**
     * coordinate metadata to which this coordinate set is referenced
     * (Required)
     *
     */
    @JsonProperty("coordinateMetadata")
    @JsonPropertyDescription("coordinate metadata to which this coordinate set is referenced")
    public Object coordinateMetadata;

}
