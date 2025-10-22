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
 * Specification of a subset of coordinate tuples that is subject to a coordinate operation.
 */
public final class PassThroughOperation extends CoordinateOperation
        implements org.opengis.referencing.operation.PassThroughOperation
{
    /**
     * Ordered sequence of positive integers defining the positions in a source coordinate tuple
     * of the coordinates affected by this pass-through operation.
     */
    @JsonProperty(index = 40)
    @JsonPropertyDescription("ordered sequence of positive integers defining the positions in a source coordinate tuple of the coordinates affected by this pass-through operation")
    public int[] modifiedCoordinate;

    /**
     * Subset of a coordinate tuple that the coordinate operation will operate upon.
     */
    @JsonProperty(index = 41, required = true)
    @JsonPropertyDescription("subset of a coordinate tuple that the coordinate operation will operate upon")
    public SingleOperation coordOperation;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public PassThroughOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected PassThroughOperation(final org.opengis.referencing.operation.PassThroughOperation impl) {
        super(impl, true);
        entityType = "PassThroughOperation";
        modifiedCoordinate = impl.getModifiedCoordinates();
        coordOperation = SingleOperation.create(impl.getOperation());
    }

    @Override
    public org.opengis.referencing.operation.SingleOperation getOperation() {
        return coordOperation;
    }

    @Override
    public int[] getModifiedCoordinates() {
        return (modifiedCoordinate != null) ? modifiedCoordinate.clone() : null;
    }

    @Override
    @Deprecated
    public org.opengis.referencing.operation.OperationMethod getMethod() {
        return (coordOperation != null) ? coordOperation.getMethod() : null;
    }

    @Override
    @Deprecated
    public org.opengis.parameter.ParameterValueGroup getParameterValues() {
        return (coordOperation != null) ? coordOperation.getParameterValues() : null;
    }
}
