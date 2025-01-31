
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * One-dimensional coordinate system that consists of the points that lie on the single axis described.
 * The associated coordinate is the distance – with or without offset – from the origin point,
 * specified through the datum definition, to the point along the axis.
 *
 * <p><b>Example:</b> usage of the line feature representing a pipeline to describe points on or along that pipeline.</p>
 *
 * A {@code LinearCS} shall have one axis association.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinearCS
    extends CoordinateSystem
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public LinearCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public LinearCS(final org.opengis.referencing.cs.CoordinateSystem impl) {
        super(impl);
        entityType = "LinearCS";
    }
}
