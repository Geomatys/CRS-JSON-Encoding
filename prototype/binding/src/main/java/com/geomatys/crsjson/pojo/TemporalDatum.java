
package com.geomatys.crsjson.pojo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Definition of the relationship of a temporal coordinate system to an object.
 * The object is normally time on the Earth.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemporalDatum
    extends Datum
{
    /**
     * Date and time to which temporal coordinates are referenced, expressed in conformance with ISO 8601.
     */
    @JsonProperty(value="origin", index=200, required=true)
    @JsonPropertyDescription("date and time to which temporal coordinates are referenced, expressed in conformance with ISO 8601")
    public Date origin;

    /**
     * Specification of the calendar to which a temporal origin is referenced.
     */
    @JsonProperty(value="calendar", index=210, required=true)
    @JsonPropertyDescription("specification of the calendar to which a temporal origin is referenced")
    public String calendar;

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
