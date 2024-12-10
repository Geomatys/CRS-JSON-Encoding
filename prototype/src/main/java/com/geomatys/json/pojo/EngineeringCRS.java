
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * contextually local coordinate reference system associated with an engineering datum and which is applied either to activities on or near the surface of the Earth without geodetic corrections, or on moving platforms such as road vehicles, vessels, aircraft or spacecraft, or as the internal CRS of an image
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datum"
})
@Generated("jsonschema2pojo")
public class EngineeringCRS
    extends SingleCRS
{

    /**
     * engineering datum that is a component of this coordinate reference system
     *
     */
    @JsonProperty("datum")
    @JsonPropertyDescription("engineering datum that is a component of this coordinate reference system")
    public Object datum;

}
