
package com.geomatys.json.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * method (algorithm or procedure) used to perform the coordinate operation
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "formulaReference",
    "parameter"
})
@Generated("jsonschema2pojo")
public class OperationMethod
    extends IdentifiedObject
{

    /**
     * specification of the coordinate operation method formula
     * (Required)
     *
     */
    @JsonProperty("formulaReference")
    @JsonPropertyDescription("specification of the coordinate operation method formula")
    public Formula formulaReference;
    /**
     * parameter or parameter group used by this coordinate operation method
     *
     */
    @JsonProperty("parameter")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("parameter or parameter group used by this coordinate operation method")
    public Set<Object> parameter;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public OperationMethod() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public OperationMethod(final org.opengis.referencing.operation.OperationMethod impl) {
        super(impl);
        entityType = "OperationMethod";
        formulaReference = new Formula(impl.getFormula());
        if (formulaReference.isEmpty()) {
            formulaReference = null;
        }
        parameter = many(impl.getParameters().descriptors(), GeneralOperationParameter::create);
    }
}
