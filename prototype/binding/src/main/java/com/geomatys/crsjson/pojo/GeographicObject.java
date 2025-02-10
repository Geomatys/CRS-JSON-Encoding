
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Identification of an object used as a parameter in a coordinate transformation,
 * point motion operation or coordinate conversion.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicObject extends Entity {
    /**
     * Identifier of the geographic object.
     */
    @JsonProperty(value="identifier", index=10)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("identifier of the geographic object")
    public Set<Identifier> identifier;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeographicObject() {
    }
}
