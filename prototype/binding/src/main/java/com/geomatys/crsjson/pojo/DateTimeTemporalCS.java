
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * one-dimensional coordinate system used to record time in dateTime representation as defined in ISO 8601.
 * Note: A DateTimeTemporalCS shall have one axis association. It does not use axisUnitID; the temporal quantities are defined through the ISO 8601 representation.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class DateTimeTemporalCS
    extends TemporalCS
{

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DateTimeTemporalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public DateTimeTemporalCS(final org.opengis.referencing.cs.TimeCS impl) {
        super(impl);
        entityType = "DateTimeTemporalCS";
        // TODO: missing coordinateType.
    }
}
