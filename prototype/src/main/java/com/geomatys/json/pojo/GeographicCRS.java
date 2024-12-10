
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * coordinate reference system associated with a geodetic reference frame and a two- or three-dimensional ellipsoidal coordinate system
 * Note: If the geodetic reference frame is dynamic then the geographic CRS is dynamic, else it is static.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class GeographicCRS
    extends GeodeticCRS
{


}
