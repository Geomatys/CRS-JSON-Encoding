
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * contextually local coordinate reference system associated with an engineering datum and which is applied either to activities on or near the surface of the Earth without geodetic corrections, or on moving platforms such as road vehicles, vessels, aircraft or spacecraft, or as the internal CRS of an image
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class EngineeringCRS
    extends SingleCRS
{


    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

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
