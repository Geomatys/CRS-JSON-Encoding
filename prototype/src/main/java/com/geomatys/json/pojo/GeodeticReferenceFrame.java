
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * definition of the position, scale and orientation of a geocentric Cartesian 3D coordinate system relative to the Earth
 * Note 1: It may also identify a defined ellipsoid (or sphere) that approximates the shape of the Earth and which is centred on and aligned to this geocentric coordinate system. Older geodetic datums define the location and orientation of a defined ellipsoid (or sphere) that approximates the shape of the earth.
 * Note 2: In 19111:2007 this class was called GeodeticDatum.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "primeMeridian",
    "ellipsoid"
})
@Generated("jsonschema2pojo")
public class GeodeticReferenceFrame
    extends Datum
{

    /**
     * prime meridian which is a component of this geodetic reference frame
     * (Required)
     *
     */
    @JsonProperty("primeMeridian")
    @JsonPropertyDescription("prime meridian which is a component of this geodetic reference frame")
    public Object primeMeridian;
    /**
     * ellipsoid which is a component of this geodetic reference frame
     *
     */
    @JsonProperty("ellipsoid")
    @JsonPropertyDescription("ellipsoid which is a component of this geodetic reference frame")
    public Object ellipsoid;

}