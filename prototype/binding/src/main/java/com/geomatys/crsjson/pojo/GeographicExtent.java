
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Base interface for geographic area of the resource.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicExtent {
    /**
     * The object type.
     */
    @JsonProperty(value="entityType", index=0, required=true)
    public String entityType;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected GeographicExtent() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeographicExtent(org.opengis.metadata.extent.GeographicExtent impl) {
        entityType = "GeographicExtent";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeographicExtent create(org.opengis.metadata.extent.GeographicExtent impl) {
        return switch (impl) {
            case null -> null;
            case org.opengis.metadata.extent.GeographicBoundingBox subtype -> new GeographicBoundingBox(subtype);
            case org.opengis.metadata.extent.GeographicDescription subtype -> new GeographicDescription(subtype);
            default -> new GeographicExtent(impl);
        };
    }
}
