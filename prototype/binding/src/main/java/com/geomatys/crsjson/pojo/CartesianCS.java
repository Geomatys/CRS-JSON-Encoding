
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Two- or three-dimensional coordinate system in Euclidean space with straight axes that are not necessarily orthogonal.
 * The number of associations shall equal the dimension of the coordinate system.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartesianCS
    extends AffineCS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public CartesianCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public CartesianCS(final org.opengis.referencing.cs.AffineCS impl) {
        super(impl);
        entityType = "CartesianCS";
    }
}
