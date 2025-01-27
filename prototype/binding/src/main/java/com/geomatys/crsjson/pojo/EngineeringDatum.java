
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Definition of the origin and orientation of an engineering coordinate reference system.
 * The origin can be fixed with respect to the Earth (such as a defined point at a construction site),
 * or be a defined point on a moving vehicle (such as on a ship or satellite), or a defined point of an image.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EngineeringDatum
    extends Datum
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public EngineeringDatum() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public EngineeringDatum(final org.opengis.referencing.datum.EngineeringDatum impl) {
        super(impl);
        entityType = "EngineeringDatum";
    }
}
