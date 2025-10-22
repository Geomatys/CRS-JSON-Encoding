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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Ordered sequence of two or more single coordinate operations.
 * The sequence of coordinate operations is constrained by the requirement that the source coordinate reference system
 * of step (<var>n</var> + 1) shall be the same as the target coordinate reference system of step (<var>n</var>).
 * The source coordinate reference system of the first step and the target coordinate reference system of the last step
 * are the source and target coordinate reference system associated with the concatenated coordinate operation.
 * For a concatenated coordinate operation sequence of <var>n</var> coordinate operations:
 *
 * <ol>
 *   <li>source <abbr>CRS</abbr> (concatenated coordinate operation) =
 *       source <abbr>CRS</abbr> (coordinate operation step 1)</li>
 *   <li>target <abbr>CRS</abbr> (coordinate operation step <var>i</var>) =
 *       source <abbr>CRS</abbr> (coordinate operation step <var>i</var> + 1); <var>i</var> = 1 ...(<var>n</var> - 1)</li>
 *   <li>target <abbr>CRS</abbr> (concatenated coordinate operation) =
 *       target <abbr>CRS</abbr> (coordinate operation step <var>n</var>)</li>
 * </ol>
 *
 * Instead of a forward coordinate operation, an inverse coordinate operation
 * may be used for one or more of the coordinate operation steps mentioned above,
 * if the inverse coordinate operation is uniquely defined by the forward coordinate operation method.
 */
public final class ConcatenatedOperation extends CoordinateOperation
        implements org.opengis.referencing.operation.ConcatenatedOperation
{
    /**
     * Coordinate operation that is a step in the sequence forming this concatenated coordinate operation.
     */
    @JsonProperty(index = 30, required = true)
    @JsonPropertyDescription("coordinate operation that is a step in the sequence forming this concatenated coordinate operation")
    public SingleOperation[] coordOperation;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ConcatenatedOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ConcatenatedOperation(final org.opengis.referencing.operation.ConcatenatedOperation impl) {
        super(impl, true);
        entityType = "ConcatenatedOperation";
        coordOperation = array(impl.getOperations(), SingleOperation[]::new, SingleOperation::create);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public List<org.opengis.referencing.operation.SingleOperation> getOperations() {
        return list(coordOperation);
    }
}
