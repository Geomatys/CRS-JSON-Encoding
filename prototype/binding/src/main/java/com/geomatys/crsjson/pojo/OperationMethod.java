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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Method (algorithm or procedure) used to perform the coordinate operation.
 */
public final class OperationMethod extends IdentifiedObject
        implements org.opengis.referencing.operation.OperationMethod
{
    /**
     * Specification of the coordinate operation method formula.
     */
    @JsonProperty(index = 20, required=true)
    @JsonPropertyDescription("specification of the coordinate operation method formula")
    public Formula formulaReference;

    /**
     * Parameter or parameter group used by this coordinate operation method.
     */
    @JsonProperty(index = 21)
    @JsonPropertyDescription("parameter or parameter group used by this coordinate operation method")
    public GeneralOperationParameter[] parameter;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public OperationMethod() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected OperationMethod(final org.opengis.referencing.operation.OperationMethod impl) {
        super(impl);
        entityType = "OperationMethod";
        formulaReference = Formula.create(impl.getFormula());
        org.opengis.parameter.ParameterDescriptorGroup pg = impl.getParameters();
        if (pg != null) {
            parameter = array(pg.descriptors(), GeneralOperationParameter[]::new, GeneralOperationParameter::create);
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static OperationMethod create(org.opengis.referencing.operation.OperationMethod impl) {
        return (impl == null || impl instanceof OperationMethod)
                ? (OperationMethod) impl : new OperationMethod(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.operation.Formula getFormula() {
        return formulaReference;
    }

    @Override
    public OperationParameterGroup getParameters() {    // Intentionally specialized to the implementation class.
        var p = new OperationParameterGroup();
        p.name = name;
        p.parameter = parameter;
        return p;
    }

    @Override
    @Deprecated
    public Integer getSourceDimensions() {
        return null;
    }

    @Override
    @Deprecated
    public Integer getTargetDimensions() {
        return null;
    }
}
