
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * One-dimensional coordinate system used to record time as an integer count.
 * A {@code TemporalCountCS} shall have one axis association.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemporalCountCS
    extends TemporalCS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public TemporalCountCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public TemporalCountCS(final org.opengis.referencing.cs.TimeCS impl) {
        super(impl);
        entityType = "TemporalCountCS";
        // TODO: missing coordinateType.
    }
}
