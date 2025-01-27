
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Parameter value, ordered sequence of values, or reference to a file of parameter values.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationParameterValue
    extends GeneralParameterValue
{
    /**
     * Value of the coordinate operation parameter.
     */
    @JsonProperty(value="parameterValue", index=100, required=true)
    @JsonPropertyDescription("value of the coordinate operation parameter")
    public ParameterValue parameterValue;

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
