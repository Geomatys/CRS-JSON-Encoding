
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
 * coordinate reference system having a vertical reference frame and a one-dimensional vertical coordinate system used for recording gravity-related heights or depths; vertical CRSs make use of the direction of gravity to define the concept of height or depth, but the relationship with gravity may not be straightforward.
 * Note 1: If the vertical reference frame is dynamic then the vertical CRS is dynamic, else it is static.
 * Note 2: Ellipsoidal heights cannot be captured in a vertical coordinate reference system. They exist only as an inseparable part of a 3D coordinate tuple defined in a geographic 3D coordinate reference system.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "geoidModel",
    "datum",
    "coordinateSystem",
    "velocityModel"
})
@Generated("jsonschema2pojo")
public class VerticalCRS
    extends SingleCRS
{

    /**
     * geoid model or height correction model that is associated with this vertical coordinate reference system
     *
     */
    @JsonProperty("geoidModel")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("geoid model or height correction model that is associated with this vertical coordinate reference system")
    public Set<Object> geoidModel;
    /**
     * vertical reference frame that is a component of this vertical coordinate reference system
     *
     */
    @JsonProperty("datum")
    @JsonPropertyDescription("vertical reference frame that is a component of this vertical coordinate reference system")
    public Object datum;
    /**
     * vertical coordinate system that is a component of this vertical coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("coordinateSystem")
    @JsonPropertyDescription("vertical coordinate system that is a component of this vertical coordinate reference system")
    public Object coordinateSystem;
    /**
     * velocity model or deformation grid that is applied to this vertical coordinate reference system
     *
     */
    @JsonProperty("velocityModel")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("velocity model or deformation grid that is applied to this vertical coordinate reference system")
    public Set<Object> velocityModel;

}
