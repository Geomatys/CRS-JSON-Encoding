
package com.geomatys.crsjson.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * description of the coordinate tuples in a coordinate set
 * Note: A single coordinate tuple is treated as a special case of coordinate set containing only one member.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class CoordinateSet {
    /**
     *
     * (Required)
     *
     */
    @JsonProperty(value="entityType", index=0)
    public String entityType;

    /**
     * position described by a coordinate tuple
     * (Required)
     *
     */
    @JsonProperty(value="coordinateTuple", index=10)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("position described by a coordinate tuple")
    public Set<Object> coordinateTuple;

    /**
     * coordinate metadata to which this coordinate set is referenced
     * (Required)
     *
     */
    @JsonProperty(value="coordinateMetadata", index=20)
    @JsonPropertyDescription("coordinate metadata to which this coordinate set is referenced")
    public Object coordinateMetadata;

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CoordinateSet() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public CoordinateSet(final Object impl) {
        entityType = "CoordinateSet";
    }
}
