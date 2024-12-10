
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * coordinate reference system having a parametric datum and a one-dimensional parametric coordinate system which uses parameter values or functions
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datum",
    "coordinateSystem"
})
@Generated("jsonschema2pojo")
public class ParametricCRS
    extends SingleCRS
{

    /**
     * parametric datum that is a component of this parametric coordinate reference system
     *
     */
    @JsonProperty("datum")
    @JsonPropertyDescription("parametric datum that is a component of this parametric coordinate reference system")
    public Object datum;
    /**
     * parametric coordinate system that is a component of this parametric coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("coordinateSystem")
    @JsonPropertyDescription("parametric coordinate system that is a component of this parametric coordinate reference system")
    public Object coordinateSystem;

}
