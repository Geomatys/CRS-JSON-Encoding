
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * origin meridian from which longitude values are determined
 * Note: The default value for prime meridian name is “Greenwich”. When the default applies, the value for the greenwichLongitude shall be 0 (degrees).
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "greenwichLongitude"
})
@Generated("jsonschema2pojo")
public class PrimeMeridian
    extends IdentifiedObject
{

    /**
     * measure object
     * <p>
     * definition of a measure object
     * (Required)
     *
     */
    @JsonProperty("greenwichLongitude")
    @JsonPropertyDescription("definition of a measure object")
    public Measure greenwichLongitude;


    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

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
