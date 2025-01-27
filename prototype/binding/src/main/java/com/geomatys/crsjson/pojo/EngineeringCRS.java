
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Contextually local coordinate reference system associated with an engineering datum.
 * This is applied either to activities on or near the surface of the Earth without geodetic corrections,
 * or on moving platforms such as road vehicles, vessels, aircraft or spacecraft,
 * or as the internal <abbr>CRS</abbr> of an image.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EngineeringCRS
    extends SingleCRS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public EngineeringCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public EngineeringCRS(final org.opengis.referencing.crs.EngineeringCRS impl) {
        super(impl);
        entityType = "EngineeringCRS";
    }
}
