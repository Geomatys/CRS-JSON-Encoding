
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Origin meridian from which longitude values are determined.
 * The default value for prime meridian name is “Greenwich”.
 * When the default applies, the value for the {@link #greenwichLongitude} shall be 0 (degrees).
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrimeMeridian
    extends IdentifiedObject
{
    /**
     * Longitude of the prime meridian measured from the internationally-recognised reference meridian.
     * Positive eastward.
     *
     * <p><b>Note 1:</b> Default value: 0 degrees.</p>
     *
     * <p><b>Note 2:</b> If the value of the prime meridian name is “Greenwich”
     * then the value of {@code greenwichLongitude} is required to be 0 degrees.</p>
     */
    @JsonProperty(value="greenwichLongitude", index=100, required=true)
    @JsonPropertyDescription("longitude of the prime meridian measured from the internationally-recognised reference meridian")
    public Measure greenwichLongitude;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public PrimeMeridian() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public PrimeMeridian(org.opengis.referencing.datum.PrimeMeridian impl) {
        super(impl);
        entityType = "PrimeMeridian";
        greenwichLongitude = new Measure(impl.getGreenwichLongitude(), impl.getAngularUnit());
    }
}
