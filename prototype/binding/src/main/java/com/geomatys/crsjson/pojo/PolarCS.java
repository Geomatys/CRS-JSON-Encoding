
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Two-dimensional coordinate system in Euclidean space in which position is specified by the distance
 * from the origin and the angle between the line from the origin to a point and a reference direction.
 * A {@code PolarCS} shall have two axis associations.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolarCS
    extends CoordinateSystem
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public PolarCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public PolarCS(final org.opengis.referencing.cs.PolarCS impl) {
        super(impl);
        entityType = "PolarCS";
    }
}
