
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Definition of a parameter or group of parameters used by a coordinate operation method.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralOperationParameter
    extends IdentifiedObject
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    protected GeneralOperationParameter() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeneralOperationParameter(final org.opengis.parameter.GeneralParameterDescriptor impl) {
        super(impl);
        entityType = "GeneralOperationParameter";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeneralOperationParameter create(org.opengis.parameter.GeneralParameterDescriptor impl) {
        if (impl == null) {
            return null;
        }
        return switch (impl) {
            case org.opengis.parameter.ParameterDescriptor<?>   subtype -> new OperationParameter     (subtype);
            case org.opengis.parameter.ParameterDescriptorGroup subtype -> new OperationParameterGroup(subtype);
            default -> new GeneralOperationParameter(impl);
        };
    }
}
