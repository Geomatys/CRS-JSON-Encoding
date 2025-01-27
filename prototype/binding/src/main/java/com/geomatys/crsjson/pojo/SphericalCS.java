
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Two or three-dimensional coordinate system in Euclidean space with two angular coordinates
 * and (in the 3D case) one distance measured from the origin.
 * Not to be confused with an ellipsoidal coordinate system based on an ellipsoid "degenerated" into a sphere.
 * A {@code SphericalCS} shall have two or three axis associations.
 * The number of associations shall equal the dimension of the coordinate system.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SphericalCS
    extends CoordinateSystem
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public SphericalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public SphericalCS(final org.opengis.referencing.cs.SphericalCS impl) {
        super(impl);
        entityType = "SphericalCS";
    }
}
