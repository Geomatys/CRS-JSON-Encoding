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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.opengis.parameter.InvalidParameterCardinalityException;
import org.opengis.parameter.ParameterNotFoundException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Group of related parameter values.
 * The same group can be repeated more than once in a coordinate operation or higher level {@link ParameterValueGroup},
 * if those instances contain different values of one or more {@link ParameterValue}s which suitably distinguish among
 * those groups.
 */
public final class ParameterValueGroup extends GeneralParameterValue
        implements org.opengis.parameter.ParameterValueGroup
{
    /**
     * Value in this value group.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("value in this value group")
    public GeneralParameterValue[] parameterValue;

    /**
     * Parameter group associated with this value group.
     */
    @JsonProperty(index = 21, required = true)
    @JsonPropertyDescription("parameter group associated with this value group")
    public OperationParameterGroup group;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ParameterValueGroup() {
    }

    /**
     * Creates a new instance associated to the given parameter descriptor.
     *
     * @param  group  description of the parameter.
     */
    protected ParameterValueGroup(final OperationParameterGroup group) {
        this.group = group;
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ParameterValueGroup(final org.opengis.parameter.ParameterValueGroup impl) {
        super(impl);
        entityType = "ParameterValueGroup";
        parameterValue = array(impl.values(), GeneralParameterValue[]::new, GeneralParameterValue::create);
        group = OperationParameterGroup.create(impl.getDescriptor());
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.parameter.ParameterDescriptorGroup getDescriptor() {
        return group;
    }

    @Override
    public List<org.opengis.parameter.GeneralParameterValue> values() {
        return list(parameterValue);
    }

    /**
     * Returns the value in this group for the specified name.
     * If this group contains a parameter value of the given name, then that parameter is returned.
     * Otherwise if a descriptor of the given name exists, then a new {@link ParameterValue} instance created.
     * Otherwise a {@link ParameterNotFoundException} is thrown.
     * This method does not search recursively in subgroups.
     *
     * @param  name  the case insensitive name of the parameter to search for.
     * @return the parameter value for the given name.
     * @throws ParameterNotFoundException if there is no parameter value for the given name.
     */
    @Override
    public org.opengis.parameter.ParameterValue<?> parameter(final String name) {
        if (parameterValue != null) {
            for (GeneralParameterValue gp : parameterValue) {
                if (gp instanceof OperationParameterValue p) {
                    final OperationParameter descriptor = p.parameter;
                    if (descriptor != null && descriptor.isIdentifiedBy(name)) {
                        return p;
                    }
                }
            }
        }
        if (group != null && group.descriptor(name) instanceof OperationParameter descriptor) {
            var p = new OperationParameterValue(descriptor);
            append(p);
            return p;
        } else {
            throw OperationParameter.parameterNotFound(name);
        }
    }

    /**
     * Returns all subgroups with the specified name.
     * This method does not create new groups.
     *
     * @param  name  the case insensitive name of the parameter group to search for.
     * @return the list of all parameter group for the given name, in insertion order.
     * @throws ParameterNotFoundException if no descriptor was found for the given name.
     */
    @Override
    public List<org.opengis.parameter.ParameterValueGroup> groups(final String name) {
        final var groups = new ArrayList<org.opengis.parameter.ParameterValueGroup>();
        if (parameterValue != null) {
            for (GeneralParameterValue gp : parameterValue) {
                if (gp instanceof ParameterValueGroup p) {
                    final OperationParameterGroup descriptor = p.group;
                    if (descriptor != null && descriptor.isIdentifiedBy(name)) {
                        groups.add(p);
                    }
                }
            }
        }
        if (groups.isEmpty()) {
            if (group == null || !(group.descriptor(name) instanceof OperationParameterGroup)) {
                throw OperationParameterGroup.parameterNotFound(name);
            }
        }
        return groups;
    }

    /**
     * Creates a new subgroup of the specified name, and adds it to the list of subgroups.
     *
     * @param  name  the case insensitive name of the parameter group to search for.
     * @return a newly created parameter group for the given identifier code.
     * @throws ParameterNotFoundException if no descriptor was found for the given name.
     * @throws InvalidParameterCardinalityException if the maximum number of occurrences is already reached.
     */
    @Override
    public org.opengis.parameter.ParameterValueGroup addGroup(String name) {
        if (group != null && group.descriptor(name) instanceof OperationParameterGroup descriptor) {
            if (parameterValue != null) {
                int count = 0;
                for (GeneralParameterValue gp : parameterValue) {
                    if (gp instanceof ParameterValueGroup p && p.group == descriptor) {
                        if (++count >= descriptor.maximumOccurs) {
                            throw new InvalidParameterCardinalityException("Too many occurrences of \"" + name + "\".", name);
                        }
                    }
                }
            }
            var p = new ParameterValueGroup(descriptor);
            append(p);
            return p;
        } else {
            throw OperationParameterGroup.parameterNotFound(name);
        }
    }

    /**
     * Appends the given parameter to the list of parameter values of this group.
     *
     * @param  gp  the parameter to add.
     */
    private void append(final GeneralParameterValue gp) {
        if (parameterValue == null) {
            parameterValue = new GeneralParameterValue[] {gp};
        } else {
            final int n = parameterValue.length;
            parameterValue = Arrays.copyOf(parameterValue, n + 1);
            parameterValue[n] = gp;
        }
    }

    /**
     * Returns a copy of this group of parameter values.
     * Included parameter values and subgroups are cloned recursively.
     *
     * @return a copy of this group of parameter values.
     */
    @Override
    public org.opengis.parameter.ParameterValueGroup clone() {
        final var clone = (ParameterValueGroup) super.clone();
        GeneralParameterValue[] gp = clone.parameterValue;
        if (gp != null) {
            clone.parameterValue = gp = gp.clone();
            for (int i=0; i < gp.length; i++) {
                gp[i] = (GeneralParameterValue) gp[i].clone();
            }
        }
        return clone;
   }
}
