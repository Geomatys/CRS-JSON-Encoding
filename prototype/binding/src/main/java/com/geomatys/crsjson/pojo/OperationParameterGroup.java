
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Definition of a group of related parameters used by a coordinate operation method.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationParameterGroup
    extends GeneralOperationParameter
{
    /**
     * Parameter that is a member of this parameter group.
     */
    @JsonProperty(value="parameter", index=200, required=true)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("parameter that is a member of this parameter group")
    public Set<Object> parameter;

    /**
     * Minimum number of times that values for this parameter group or parameter is required.
     * If this attribute is omitted, the minimum number is one.
     */
    @JsonProperty(value="minimumOccurs", index=210)
    @JsonPropertyDescription("minimum number of times that values for this parameter group or parameter is required")
    public Integer minimumOccurs;

    /**
     * Maximum number of times that values for this parameter group or parameter can be included.
     * If this attribute is omitted, the maximum number is one.
     */
    @JsonProperty(value="maximumOccurs", index=220)
    @JsonPropertyDescription("maximum number of times that values for this parameter group or parameter can be included")
    public Integer maximumOccurs;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public OperationParameterGroup() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public OperationParameterGroup(final org.opengis.parameter.ParameterDescriptorGroup impl) {
        super(impl);
        entityType = "OperationParameterGroup";
        minimumOccurs = impl.getMinimumOccurs();
        maximumOccurs = impl.getMaximumOccurs();
        parameter = many(impl.descriptors(), GeneralOperationParameter::create);
    }
}
