
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Standardized resource reference.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Citation {
    /**
     * The object type.
     */
    @JsonProperty(value="entityType", index=0, required=true)
    public String entityType;

    /**
     * Name by which the cited resource is known.
     */
    @JsonProperty(value="title", index=100, required=true)
    @JsonPropertyDescription("name by which the cited resource is known")
    public String title;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Citation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public Citation(final org.opengis.metadata.citation.Citation impl) {
        entityType = "Citation";
        title = IdentifiedObject.text(impl.getTitle());
    }
}
