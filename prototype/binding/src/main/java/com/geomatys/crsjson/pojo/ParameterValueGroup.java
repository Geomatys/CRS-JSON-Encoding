
package com.geomatys.crsjson.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Group of related parameter values.
 * The same group can be repeated more than once in a coordinate operation or higher level {@link ParameterValueGroup},
 * if those instances contain different values of one or more {@link ParameterValue}s which suitably distinguish among
 * those groups.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class ParameterValueGroup
    extends GeneralParameterValue
{
    /**
     * Value in this value group.
     */
    @JsonProperty(value="parameterValue", index=100, required=true)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("value in this value group")
    public Set<Object> parameterValue;

    /**
     * Parameter group associated with this value group.
     */
    @JsonProperty(value="group", index=110, required=true)
    @JsonPropertyDescription("parameter group associated with this value group")
    public Object group;

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ParameterValueGroup() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ParameterValueGroup(final org.opengis.parameter.ParameterValueGroup impl) {
        entityType = "ParameterValueGroup";
        parameterValue = IdentifiedObject.many(impl.values(), GeneralParameterValue::create);
        group = parameter;  // TODO: redundancy in the UML.
    }
}
