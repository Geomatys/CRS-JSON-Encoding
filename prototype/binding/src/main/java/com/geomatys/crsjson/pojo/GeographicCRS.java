
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Coordinate reference system associated with a geodetic reference frame
 * and a two- or three-dimensional ellipsoidal coordinate system.
 * If the geodetic reference frame is dynamic then the geographic <abbr>CRS</abbr> is dynamic, else it is static.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicCRS
    extends GeodeticCRS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeographicCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public GeographicCRS(final org.opengis.referencing.crs.GeographicCRS impl) {
        super(impl);
        entityType = "GeographicCRS";
    }
}
