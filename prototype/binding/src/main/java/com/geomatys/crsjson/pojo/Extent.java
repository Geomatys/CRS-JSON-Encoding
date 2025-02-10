
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;


/**
 * Information about spatial, vertical, and temporal extent of the resource.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Extent extends Entity {
    /**
     * The spatial and temporal extent for the referring object.
     */
    @JsonProperty(value="description", index=100)
    @JsonPropertyDescription("the spatial and temporal extent for the referring object")
    public String description;

    /**
     * Provides geographic component of the extent of the referring object.
     */
    @JsonProperty(value="geographicElement", index=110)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("provides geographic component of the extent of the referring object")
    public Set<GeographicExtent> geographicElement;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected Extent() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected Extent(org.opengis.metadata.extent.Extent impl) {
        entityType = "Extent";
        description = text(impl.getDescription());
        geographicElement = many(impl.getGeographicElements(), GeographicExtent::create);
    }
}
