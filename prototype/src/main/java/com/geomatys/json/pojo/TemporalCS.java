
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * one-dimensional coordinate system used to record time
 * Note: A TemporalCS shall have one axis association.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coordinateType"
})
@Generated("jsonschema2pojo")
public class TemporalCS
    extends CoordinateSystem
{

    /**
     * datatype of coordinate values
     * (Required)
     *
     */
    @JsonProperty("coordinateType")
    @JsonPropertyDescription("datatype of coordinate values")
    public String coordinateType;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected TemporalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected TemporalCS(final org.opengis.referencing.cs.TimeCS impl) {
        super(impl);
        entityType = "TemporalCS";
        // TODO: missing coordinateType.
    }
}
