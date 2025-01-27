
package com.geomatys.crsjson.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * definition of a group of related parameters used by a coordinate operation method
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class OperationParameterGroup
    extends GeneralOperationParameter
{
    /**
     * minimum number of times that values for this parameter group or parameter is required
     * Note: If this attribute is omitted, the minimum number is one.
     *
     */
    @JsonProperty(value="minimumOccurs", index=200)
    @JsonPropertyDescription("minimum number of times that values for this parameter group or parameter is required\r\nNote: If this attribute is omitted, the minimum number is one.")
    public Integer minimumOccurs;

    /**
     * maximum number of times that values for this parameter group or parameter can be included
     * Note: If this attribute is omitted, the maximum number is one.
     *
     */
    @JsonProperty(value="maximumOccurs", index=210)
    @JsonPropertyDescription("maximum number of times that values for this parameter group or parameter can be included\r\nNote: If this attribute is omitted, the maximum number is one.")
    public Integer maximumOccurs;

    /**
     * parameter that is a member of this parameter group
     * (Required)
     *
     */
    @JsonProperty(value="parameter", index=220)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("parameter that is a member of this parameter group")
    public Set<Object> parameter;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

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
