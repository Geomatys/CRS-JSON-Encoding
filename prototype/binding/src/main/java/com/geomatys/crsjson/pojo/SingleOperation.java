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
 * Single (not concatenated) coordinate operation.
 */
public class SingleOperation extends CoordinateOperation
        implements org.opengis.referencing.operation.SingleOperation
{
    /**
     * Parameter value or parameter value group used by this single operation.
     */
    @JsonProperty(index = 30)
    @JsonPropertyDescription("parameter value or parameter value group used by this single operation")
    public GeneralParameterValue[] parameterValue;

    /**
     * Algorithm or procedure used by this single operation.
     */
    @JsonProperty(index = 31, required = true)
    @JsonPropertyDescription("algorithm or procedure used by this single operation")
    public OperationMethod method;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public SingleOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl     implementation of a GeoAPI object to serialize.
     * @param withCRS  whether to initialize also {@link #sourceCRS} and {@link #targetCRS}.
     */
    protected SingleOperation(final org.opengis.referencing.operation.SingleOperation impl, boolean withCRS) {
        super(impl, withCRS);
        entityType = "SingleOperation";
        org.opengis.parameter.ParameterValueGroup pg = impl.getParameterValues();
        if (pg != null) {
            parameterValue = array(pg.values(), GeneralParameterValue[]::new, GeneralParameterValue::create);
        }
        method = OperationMethod.create(impl.getMethod());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl  implementation of a GeoAPI object to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static SingleOperation create(final org.opengis.referencing.operation.SingleOperation impl) {
        return switch (impl) {
            case null -> null;
            case SingleOperation subtype -> subtype;
            case org.opengis.referencing.operation.Transformation subtype -> new Transformation(subtype);
            case org.opengis.referencing.operation.Conversion     subtype -> new Conversion(subtype, true);
            default -> new SingleOperation(impl, true);
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.operation.OperationMethod getMethod() {
        return method;
    }

    @Override
    public org.opengis.parameter.ParameterValueGroup getParameterValues() {
        var p = new ParameterValueGroup();
        if (method != null) {
            p.group = method.getParameters();
        }
        p.parameterValue = parameterValue;
        return p;
    }
}
