
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Definition of a parameter used by a coordinate operation method.
 * Most parameter values are numeric, but other types of parameter values are possible.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationParameter
    extends GeneralOperationParameter
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public OperationParameter() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public OperationParameter(final org.opengis.parameter.ParameterDescriptor<?> impl) {
        super(impl);
        entityType = "OperationParameter";
    }
}
