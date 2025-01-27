
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Geodetic reference frame in which some of the parameters describe time evolution of defining station coordinates.
 * Example: defining station coordinates having linear velocities to account for crustal motion.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicGeodeticReferenceFrame
    extends GeodeticReferenceFrame
{
    /**
     * Epoch to which the coordinates of stations defining the dynamic geodetic reference frame are referenced,
     * expressed as a decimal year in the Gregorian calendar.
     * Example: 2016,47.
     */
    @JsonProperty(value="frameReferenceEpoch", index=300, required=true)
    @JsonPropertyDescription("epoch to which the coordinates of stations defining the dynamic geodetic reference frame are referenced, expressed as a decimal year in the Gregorian calendar")
    public Measure frameReferenceEpoch;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DynamicGeodeticReferenceFrame() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public DynamicGeodeticReferenceFrame(org.opengis.referencing.datum.GeodeticDatum impl) {
        super(impl);
        entityType = "DynamicGeodeticReferenceFrame";
    }
}
