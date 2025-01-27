
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * parameter value, an ordered sequence of values, or a reference to a file of parameter values that define a paramtric datum
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parameterValue"
})
@Generated("jsonschema2pojo")
public class DefiningParameter
    extends IdentifiedObject
{

    /**
     * value of the coordinate operation parameter
     * (Required)
     *
     */
    @JsonProperty("parameterValue")
    @JsonPropertyDescription("value of the coordinate operation parameter")
    public ParameterValue parameterValue;

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DefiningParameter() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public DefiningParameter(final org.opengis.parameter.ParameterDescriptor<?> impl) {
        super(impl);
        entityType = "DefiningParameter";
    }
}
