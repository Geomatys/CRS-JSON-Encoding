
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Three-dimensional coordinate system in Euclidean space consisting of a polar coordinate system
 * extended by a straight coordinate axis perpendicular to the plane spanned by the polar coordinate system.
 * A {@code CylindricalCS} shall have three axis associations.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CylindricalCS
    extends CoordinateSystem
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public CylindricalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public CylindricalCS(final org.opengis.referencing.cs.CylindricalCS impl) {
        super(impl);
        entityType = "CylindricalCS";
    }
}
