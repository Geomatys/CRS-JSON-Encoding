
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Mathematical operation that decribes the change of coordinate values within one coordinate reference system
 * due to the motion of the point between one coordinate epoch and another coordinate epoch.
 * The motion can be due to tectonic plate movement or deformation.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointMotionOperation
    extends SingleOperation
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public PointMotionOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl     implementation of a GeoAPI object to serialize.
     * @param withCRS  whether to initialize also {@link #sourceCRS} and {@link #targetCRS}.
     */
    public PointMotionOperation(final org.opengis.referencing.operation.SingleOperation impl, boolean withCRS) {
        super(impl, withCRS);
        entityType = "PointMotionOperation";
    }
}
