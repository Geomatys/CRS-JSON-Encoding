
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * parameter value, ordered sequence of values, or reference to a file of parameter values
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parameterValue"
})
@Generated("jsonschema2pojo")
public class OperationParameterValue
    extends GeneralParameterValue
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
    public OperationParameterValue() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public OperationParameterValue(final org.opengis.parameter.ParameterValue<?> impl) {
        entityType = "OperationParameterValue";
        parameterValue = new ParameterValue(impl);
    }
}
