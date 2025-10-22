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

import java.util.Set;
import javax.measure.Unit;


/**
 * Definition of a parameter used by a coordinate operation method.
 * Most parameter values are numeric, but other types of parameter values are possible.
 */
public final class OperationParameter extends GeneralOperationParameter
        implements org.opengis.parameter.ParameterDescriptor<Object>
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
    protected OperationParameter(final org.opengis.parameter.ParameterDescriptor<?> impl) {
        super(impl);
        entityType = "OperationParameter";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static OperationParameter create(org.opengis.parameter.ParameterDescriptor<?> impl) {
        return (impl == null || impl instanceof OperationParameter)
                ? (OperationParameter) impl : new OperationParameter(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    /**
     * Returns the minimum number of times that values for this parameter are required.
     * The default value is 1. A value of 0 means an optional parameter.
     */
    @Override
    public int getMinimumOccurs() {
        return 1;
    }

    /**
     * Returns the maximum number of times that values for this parameter are required.
     * Cannot be more than one for {@code OperationParameter}.
     */
    @Override
    public int getMaximumOccurs() {
        return 1;
    }

    /**
     * Returns the class that describes the type of parameter values.
     * This is usually (but not restricted to) {@link Boolean}, {@link Integer}, {@link Double}, {@link String}
     * or {@link java.net.URI} when the parameter contains a single value.
     * If the parameter can contain multiple values, then the class may be {@code int[]}, {@code double[]},
     * {@link java.util.List}, {@link Set} or {@link java.util.Map}.
     *
     * @return the type of parameter values.
     */
    @Override
    public Class<Object> getValueClass() {
        return Object.class;
    }

    /**
     * Returns the set of allowed values when these are restricted to some finite set or returns
     * {@code null} otherwise. The returned set usually contains {@linkplain CodeList code list}
     * or enumeration elements.
     */
    @Override
    public Set<Object> getValidValues() {
        return null;
    }

    /**
     * Returns the minimum parameter value, or {@code null} if none.
     */
    @Override
    public Comparable<Object> getMinimumValue() {
        return null;
    }

    /**
     * Returns the maximum parameter value, or {@code null} if none.
     */
    @Override
    public Comparable<Object> getMaximumValue() {
        return null;
    }

    /**
     * Returns the default value for the parameter, {@code null} if none.
     */
    @Override
    public Object getDefaultValue() {
        return null;
    }

    /**
     * Returns the unit of measurement for the minimum, maximum and default values.
     * If units of measurement are not applicable or unknown, returns {@code null}.
     */
    @Override
    public Unit<?> getUnit() {
        return null;
    }

    /**
     * Creates a new instance of parameter value initialized with the default value.
     */
    @Override
    public org.opengis.parameter.ParameterValue<Object> createValue() {
        return new OperationParameterValue(this);
    }
}
