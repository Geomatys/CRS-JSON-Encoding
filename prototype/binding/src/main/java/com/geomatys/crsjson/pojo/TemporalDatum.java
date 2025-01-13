
package com.geomatys.crsjson.pojo;

import java.util.Date;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * definition of the relationship of a temporal coordinate system to an object
 * Note: The object is normally time on the Earth.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "origin",
    "calendar"
})
@Generated("jsonschema2pojo")
public class TemporalDatum
    extends Datum
{

    /**
     * date and time to which temporal coordinates are referenced, expressed in conformance with ISO 8601
     * (Required)
     *
     */
    @JsonProperty("origin")
    @JsonPropertyDescription("date and time to which temporal coordinates are referenced, expressed in conformance with ISO 8601")
    public Date origin;
    /**
     * specification of the calendar to which a temporal origin is referenced
     * (Required)
     *
     */
    @JsonProperty("calendar")
    @JsonPropertyDescription("specification of the calendar to which a temporal origin is referenced")
    public String calendar;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public TemporalDatum() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public TemporalDatum(final org.opengis.referencing.datum.TemporalDatum impl) {
        super(impl);
        entityType = "TemporalDatum";
        origin = impl.getOrigin();
        // TODO: missing calendar
    }
}
