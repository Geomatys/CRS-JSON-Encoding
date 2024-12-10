
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * derived coordinate reference system which has a geodetic (usually geographic) coordinate reference system as its base CRS, thereby inheriting a geodetic reference frame, is converted using a map projection, and has a Cartesian coordinate system, usually two-dimensional but may be three-dimensional
 * Note: In the 3D case the base geographic CRSs ellipsoidal height is passed through unchanged and forms the vertical axis of the projected CRS's Cartesian coordinate system.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class ProjectedCRS
    extends DerivedCRS
{


}
