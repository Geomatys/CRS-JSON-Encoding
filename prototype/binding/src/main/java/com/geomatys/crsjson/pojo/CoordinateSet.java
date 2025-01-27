
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Description of the coordinate tuples in a coordinate set.
 * A single coordinate tuple is treated as a special case of coordinate set containing only one member.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoordinateSet {
    /**
     * The object type.
     */
    @JsonProperty(value="entityType", index=0, required=true)
    public String entityType;

    /**
     * Position described by a coordinate tuple.
     */
    @JsonProperty(value="coordinateTuple", index=10, required=true)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("position described by a coordinate tuple")
    public Set<Object> coordinateTuple;

    /**
     * Coordinate metadata to which this coordinate set is referenced.
     */
    @JsonProperty(value="coordinateMetadata", index=20, required=true)
    @JsonPropertyDescription("coordinate metadata to which this coordinate set is referenced")
    public Object coordinateMetadata;

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
