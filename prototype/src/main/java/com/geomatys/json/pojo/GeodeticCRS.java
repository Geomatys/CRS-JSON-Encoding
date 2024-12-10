
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
 * coordinate reference system associated with a geodetic reference frame and a three-dimensional Cartesian or spherical coordinate system
 * Note: If the geodetic reference frame is dynamic then the geodetic CRS is dynamic, else it is static.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "velocityModel",
    "definingTransformation",
    "datum"
})
@Generated("jsonschema2pojo")
public class GeodeticCRS
    extends SingleCRS
{

    /**
     * velocity model or deformation grid that may be applied to this geodetic coordinate reference system
     *
     */
    @JsonProperty("velocityModel")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("velocity model or deformation grid that may be applied to this geodetic coordinate reference system")
    public Set<Object> velocityModel;
    @JsonProperty("definingTransformation")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    public Set<Object> definingTransformation;
    /**
     * geodetic reference frame that is a component of this geodetic coordinate reference system
     *
     */
    @JsonProperty("datum")
    @JsonPropertyDescription("geodetic reference frame that is a component of this geodetic coordinate reference system")
    public Object datum;

}
