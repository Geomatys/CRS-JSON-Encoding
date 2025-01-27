
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * One-dimensional coordinate system used to record the heights or depths of points,
 * usually dependent on the Earth's gravity field.
 * A {@code VerticalCS} shall have one axis association.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerticalCS
    extends CoordinateSystem
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public VerticalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public VerticalCS(final org.opengis.referencing.cs.VerticalCS impl) {
        super(impl);
        entityType = "VerticalCS";
    }
}
