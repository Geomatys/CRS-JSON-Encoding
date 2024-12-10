
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * derived coordinate reference system which has a projected coordinate reference system as its base CRS, thereby inheriting a geodetic reference frame, but also inheriting the distortion characteristics of the base projected CRS
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseCRS"
})
@Generated("jsonschema2pojo")
public class DerivedProjectedCRS
    extends DerivedCRS
{

    /**
     * projected coordinate reference system that is the baseCRS for this derived projected coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("baseCRS")
    @JsonPropertyDescription("projected coordinate reference system that is the baseCRS for this derived projected coordinate reference system")
    public Object baseCRS;

}
