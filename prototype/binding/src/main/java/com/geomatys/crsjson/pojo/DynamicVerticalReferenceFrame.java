
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * vertical reference frame in which some of the defining parameters have time dependency
 * Example: Defining station heights have velocity to account for post-glacial isostatic rebound motion.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "frameReferenceEpoch"
})
@Generated("jsonschema2pojo")
public class DynamicVerticalReferenceFrame
    extends VerticalReferenceFrame
{

    /**
     * measure object
     * <p>
     * definition of a measure object
     * (Required)
     *
     */
    @JsonProperty("frameReferenceEpoch")
    @JsonPropertyDescription("definition of a measure object")
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
