/*
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership. You may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.geomatys.crsjson.pojo;

import java.util.List;
import org.opengis.parameter.ParameterNotFoundException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Definition of a group of related parameters used by a coordinate operation method.
 */
public final class OperationParameterGroup extends GeneralOperationParameter
        implements org.opengis.parameter.ParameterDescriptorGroup
{
    /**
     * Parameter that is a member of this parameter group.
     */
    @JsonProperty(index = 30, required = true)
    @JsonPropertyDescription("parameter that is a member of this parameter group")
    public GeneralOperationParameter[] parameter;

    /**
     * Minimum number of times that values for this parameter group or parameter is required.
     * If this attribute is omitted, the minimum number is one.
     */
    @JsonProperty(index = 31)
    @JsonPropertyDescription("minimum number of times that values for this parameter group or parameter is required")
    public int minimumOccurs;

    /**
     * Maximum number of times that values for this parameter group or parameter can be included.
     * If this attribute is omitted, the maximum number is one.
     */
    @JsonProperty(index = 32)
    @JsonPropertyDescription("maximum number of times that values for this parameter group or parameter can be included")
    public int maximumOccurs;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public OperationParameterGroup() {
        maximumOccurs = 1;
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected OperationParameterGroup(final org.opengis.parameter.ParameterDescriptorGroup impl) {
        super(impl);
        entityType = "OperationParameterGroup";
        minimumOccurs = impl.getMinimumOccurs();
        maximumOccurs = impl.getMaximumOccurs();
        parameter = array(impl.descriptors(), GeneralOperationParameter[]::new, GeneralOperationParameter::create);
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static OperationParameterGroup create(org.opengis.parameter.ParameterDescriptorGroup impl) {
        return (impl == null || impl instanceof OperationParameterGroup)
                ? (OperationParameterGroup) impl : new OperationParameterGroup(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public List<org.opengis.parameter.GeneralParameterDescriptor> descriptors() {
        return list(parameter);
    }

    @Override
    public int getMinimumOccurs() {
        return minimumOccurs;
    }

    @Override
    public int getMaximumOccurs() {
        return maximumOccurs;
    }

    /**
     * Returns the parameter descriptor in this group for the specified identifier code.
     *
     * @param  name  the case insensitive identifier code of the parameter to search for.
     * @return the parameter for the given identifier code.
     * @throws ParameterNotFoundException if there is no parameter for the given identifier code.
     */
    @Override
    public org.opengis.parameter.GeneralParameterDescriptor descriptor(String name) {
        if (parameter != null) {
            for (GeneralOperationParameter p : parameter) {
                if (p != null && p.isIdentifiedBy(name)) {
                    return p;
                }
            }
        }
        throw parameterNotFound(name);
    }

    /**
     * Creates a new instance of parameter value group initialized with the default values.
     */
    @Override
    public org.opengis.parameter.ParameterValueGroup createValue() {
        return new ParameterValueGroup(this);
    }
}
