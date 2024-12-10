
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * derived coordinate reference system which has a geodetic (usually geographic) coordinate reference system as its base CRS, thereby inheriting a geodetic reference frame, is converted using a map projection, and has a Cartesian coordinate system, usually two-dimensional but may be three-dimensional
 * Note: In the 3D case the base geographic CRSs ellipsoidal height is passed through unchanged and forms the vertical axis of the projected CRS's Cartesian coordinate system.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coordinateSystem",
    "baseCRS"
})
@Generated("jsonschema2pojo")
public class ProjectedCRS
    extends DerivedCRS
{

    /**
     * Cartesian coordinate system that is a component of this projected coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("coordinateSystem")
    @JsonPropertyDescription("Cartesian coordinate system that is a component of this projected coordinate reference system")
    public Object coordinateSystem;
    /**
     * geodetic or geographic coordinate reference system that is the baseCRS for this projected coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("baseCRS")
    @JsonPropertyDescription("geodetic or geographic coordinate reference system that is the baseCRS for this projected coordinate reference system")
    public Object baseCRS;

}
