
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Mathematical operation on coordinates in which parameters are empirically derived from data
 * containing the coordinates of a series of points in both coordinate reference systems.
 * This computational process is usually “over-determined”,
 * allowing derivation of error (or accuracy) estimates for the coordinate transformation.
 * Also, the stochastic nature of the parameters may result in multiple (different) versions
 * of the same coordinate transformations between the same source and target <abbr>CRS</abbr>s.
 * Any single coordinate operation in which the input and output coordinates are referenced to
 * different datums (reference frames) will be a coordinate transformation.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Transformation
    extends SingleOperation
{

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Transformation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public Transformation(final org.opengis.referencing.operation.Transformation impl) {
        super(impl, true);
        entityType = "Transformation";
    }
}
