
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * coordinate reference system associated with a geodetic reference frame and a two- or three-dimensional ellipsoidal coordinate system
 * Note: If the geodetic reference frame is dynamic then the geographic CRS is dynamic, else it is static.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coordinateSystem"
})
@Generated("jsonschema2pojo")
public class GeographicCRS
    extends GeodeticCRS
{

    /**
     * ellipsoidal coordinate system that is a component of this geographic coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("coordinateSystem")
    @JsonPropertyDescription("ellipsoidal coordinate system that is a component of this geographic coordinate reference system")
    public Object coordinateSystem;

}
