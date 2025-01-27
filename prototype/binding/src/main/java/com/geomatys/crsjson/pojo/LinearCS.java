
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * one-dimensional coordinate system that consists of the points that lie on the single axis described
 * Note: The associated coordinate is the distance – with or without offset – from the origin point, specified through the datum definition, to the point along the axis. Example: usage of the line feature representing a pipeline to describe points on or along that pipeline. A LinearCS shall have one axis association.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class LinearCS
    extends CoordinateSystem
{

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

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
