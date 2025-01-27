
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Two- or three-dimensional coordinate system in which position is specified by geodetic latitude,
 * geodetic longitude, and (in the three-dimensional case) ellipsoidal height.
 * An {@code EllipsoidalCS} shall have two or three associations.
 * The number of associations shall equal the dimension of the coordinate system.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EllipsoidalCS
    extends CoordinateSystem
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public EllipsoidalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public EllipsoidalCS(final org.opengis.referencing.cs.EllipsoidalCS impl) {
        super(impl);
        entityType = "EllipsoidalCS";
    }
}
