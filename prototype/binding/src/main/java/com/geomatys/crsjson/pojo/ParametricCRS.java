
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Coordinate reference system having a parametric datum and a one-dimensional parametric coordinate system
 * which uses parameter values or functions.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParametricCRS
    extends SingleCRS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public ParametricCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ParametricCRS(org.opengis.referencing.crs.SingleCRS impl) {
        super(impl);
        entityType = "ParametricCRS";
    }
}
