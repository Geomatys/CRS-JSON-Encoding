
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Parameter value or group of parameter values.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralParameterValue extends Entity {
    /**
     * Parameter or parameter group which has this value or value group.
     */
    @JsonProperty(value="parameter", index=10, required=true)
    @JsonPropertyDescription("parameter or parameter group which has this value or value group")
    public Object parameter;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected GeneralParameterValue() {
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
    protected GeneralParameterValue(final org.opengis.parameter.GeneralParameterValue impl) {
        entityType = "GeneralParameterValue";
        parameter = GeneralOperationParameter.create(impl.getDescriptor());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeneralParameterValue create(org.opengis.parameter.GeneralParameterValue impl) {
        return switch (impl) {
            case null -> null;
            case org.opengis.parameter.ParameterValue<?>   subtype -> new OperationParameterValue(subtype);
            case org.opengis.parameter.ParameterValueGroup subtype -> new ParameterValueGroup    (subtype);
            default -> new GeneralParameterValue(impl);
        };
    }
}
