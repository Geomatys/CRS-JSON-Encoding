
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Derived coordinate reference system defined by a map projection.
 * {@code ProjectedCRS} has a geodetic (usually geographic) coordinate reference system as its base CRS,
 * thereby inheriting a geodetic reference frame, is converted using a map projection,
 * and has a Cartesian coordinate system, usually two-dimensional but may be three-dimensional.
 * In the 3D case the base geographic <abbr>CRS</abbr>s ellipsoidal height is passed through unchanged
 * and forms the vertical axis of the projected <abbr>CRS</abbr>'s Cartesian coordinate system.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectedCRS
    extends DerivedCRS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public ProjectedCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ProjectedCRS(final org.opengis.referencing.crs.ProjectedCRS impl) {
        super(impl);
        entityType = "ProjectedCRS";
    }
}
