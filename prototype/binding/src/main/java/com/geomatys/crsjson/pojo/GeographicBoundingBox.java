
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Geographic position of the resource.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicBoundingBox extends GeographicExtent {
    /**
     * The western-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(value="westBoundLongitude", index=210, required=true)
    @JsonPropertyDescription("the western-most coordinate of the limit of the resource extent.")
    public double westBoundLongitude;

    /**
     * The eastern-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(value="eastBoundLongitude", index=220, required=true)
    @JsonPropertyDescription("the eastern-most coordinate of the limit of the resource extent.")
    public double eastBoundLongitude;

    /**
     * The southern-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(value="southBoundLatitude", index=230, required=true)
    @JsonPropertyDescription("the southern-most coordinate of the limit of the resource extent.")
    public double southBoundLatitude;

    /**
     * The northern-most coordinate of the limit of the resource extent.
     */
    @JsonProperty(value="northBoundLatitude", index=240, required=true)
    @JsonPropertyDescription("the northern-most coordinate of the limit of the resource extent.")
    public double northBoundLatitude;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeographicBoundingBox() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public GeographicBoundingBox(org.opengis.metadata.extent.GeographicBoundingBox impl) {
        super(impl);
        entityType = "GeographicBoundingBox";
        westBoundLongitude = impl.getWestBoundLongitude();
        eastBoundLongitude = impl.getEastBoundLongitude();
        southBoundLatitude = impl.getSouthBoundLatitude();
        northBoundLatitude = impl.getNorthBoundLatitude();
    }
}
