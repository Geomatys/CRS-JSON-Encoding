
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * A projected <abbr>CRS</abbr> derived from another <abbr>CRS</abbr>.
 * A {@code DerivedProjectedCRS} has a projected coordinate reference system as its base <abbr>CRS</abbr>,
 * thereby inheriting a geodetic reference frame,
 * but also inheriting the distortion characteristics of the base projected <abbr>CRS</abbr>.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DerivedProjectedCRS
    extends DerivedCRS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public DerivedProjectedCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public DerivedProjectedCRS(final org.opengis.referencing.crs.GeneralDerivedCRS impl) {
        super(impl);
        entityType = "DerivedProjectedCRS";
    }
}
