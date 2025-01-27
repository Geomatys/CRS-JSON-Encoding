
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * specification of the coordinate operation method formula
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Formula {
    /**
     * formula(s) or procedure used by the coordinate operation method
     *
     */
    @JsonProperty(value="formula", index=100)
    @JsonPropertyDescription("formula(s) or procedure used by the coordinate operation method")
    public String formula;

    /**
     * reference to a publication giving the formula(s) or procedure used by the coordinate operation method
     *
     */
    @JsonProperty(value="formulaCitation", index=110)
    @JsonPropertyDescription("reference to a publication giving the formula(s) or procedure used by the coordinate operation method")
    public Object formulaCitation;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Formula() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public Formula(final org.opengis.referencing.operation.Formula impl) {
        if (impl != null) {
            formula = IdentifiedObject.text(impl.getFormula());
            // TODO: missing formulaCitation.
        }
    }

    /**
     * Returns whether this node is empty.
     *
     * @return {@code true} if all properties in this node are null.
     */
    public boolean isEmpty() {
        return formula == null && formulaCitation == null;
    }
}
