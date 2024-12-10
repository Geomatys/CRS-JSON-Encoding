
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * single coordinate reference system that is defined through the application of a specified coordinate conversion to the definition of a previously established single coordinate reference system referred to as the base CRS
 * Note:  A derived coordinate reference system inherits its datum (or datum ensemble) from its base CRS. The coordinate conversion between the base and derived coordinate reference system is implemented using the parameters and formula(s) specified in the definition of the coordinate conversion.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseCRS",
    "derivingConversion"
})
@Generated("jsonschema2pojo")
public class DerivedCRS
    extends SingleCRS
{

    /**
     * coordinate reference system that is the baseCRS for this derived coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("baseCRS")
    @JsonPropertyDescription("coordinate reference system that is the baseCRS for this derived coordinate reference system")
    public Object baseCRS;
    /**
     * conversion that is a component of this derived coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("derivingConversion")
    @JsonPropertyDescription("conversion that is a component of this derived coordinate reference system")
    public Object derivingConversion;

}
