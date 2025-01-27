
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Mathematical operation on coordinates in which the parameter values are defined rather than empirically derived.
 * Application of the coordinate conversion introduces no error into output coordinates.
 * The best-known example of a coordinate conversion is a map projection.
 * For coordinate conversions the output coordinates are referenced to the same datum as are the input coordinates.
 * Coordinate conversions forming a component of a derived CRS have a source CRS and a target CRS that are
 * <em>not</em> specified through the source and target associations,
 * but through associations from {@link DerivedCRS} to {@link SingleCRS}.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Conversion
    extends SingleOperation
{

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Conversion() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl     implementation of a GeoAPI object to serialize.
     * @param withCRS  whether to initialize also {@link #sourceCRS} and {@link #targetCRS}.
     */
    public Conversion(final org.opengis.referencing.operation.Conversion impl, boolean withCRS) {
        super(impl, withCRS);
        entityType = "Conversion";
    }
}
