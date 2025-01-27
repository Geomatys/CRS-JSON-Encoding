
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Textual description and/or a set of parameters identifying a particular reference level surface
 * used as a zero-height or zero-depth surface, including its position with respect to the Earth.
 *
 * <p><b>Note:</b> In 19111:2007 this class was called {@code VerticalDatum}.</p>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class VerticalReferenceFrame
    extends Datum
{
    /**
     * Specification of the method by which the vertical reference frame is realized.
     */
    @JsonProperty(value="realizationMethod", index=200)
    @JsonPropertyDescription("specification of the method by which the vertical reference frame is realized")
    public String realizationMethod;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public VerticalReferenceFrame() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public VerticalReferenceFrame(final org.opengis.referencing.datum.VerticalDatum impl) {
        super(impl);
        entityType = "VerticalReferenceFrame";
        // TODO: missing realizationMethod.
    }
}
