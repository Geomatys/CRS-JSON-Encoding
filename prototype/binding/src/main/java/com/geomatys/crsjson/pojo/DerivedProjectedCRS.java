
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * derived coordinate reference system which has a projected coordinate reference system as its base CRS, thereby inheriting a geodetic reference frame, but also inheriting the distortion characteristics of the base projected CRS
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class DerivedProjectedCRS
    extends DerivedCRS
{


    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

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
