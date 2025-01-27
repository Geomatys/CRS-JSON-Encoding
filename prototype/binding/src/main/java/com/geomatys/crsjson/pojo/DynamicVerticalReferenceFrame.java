
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Vertical reference frame in which some of the defining parameters have time dependency.
 * Example: Defining station heights have velocity to account for post-glacial isostatic rebound motion.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class DynamicVerticalReferenceFrame
    extends VerticalReferenceFrame
{
    /**
     * Epoch to which the coordinates of stations defining the dynamic vertical reference frame are referenced,
     * expressed as a decimal year in the Gregorian calendar.
     * Example: 2016,47.
     */
    @JsonProperty(value="frameReferenceEpoch", index=300, required=true)
    @JsonPropertyDescription("epoch to which the coordinates of stations defining the dynamic vertical reference frame are referenced, expressed as a decimal year in the Gregorian calendar")
    public Measure frameReferenceEpoch;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DynamicVerticalReferenceFrame() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public DynamicVerticalReferenceFrame(final org.opengis.referencing.datum.VerticalDatum impl) {
        super(impl);
        entityType = "DynamicVerticalReferenceFrame";
        // TODO: missing realizationMethod.
    }
}
