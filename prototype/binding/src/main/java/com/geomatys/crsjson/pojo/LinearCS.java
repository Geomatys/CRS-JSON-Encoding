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


/**
 * One-dimensional coordinate system that consists of the points that lie on the single axis described.
 * The associated coordinate is the distance – with or without offset – from the origin point,
 * specified through the datum definition, to the point along the axis.
 *
 * <p><b>Example:</b> usage of the line feature representing a pipeline to describe points on or along that pipeline.</p>
 *
 * A {@code LinearCS} shall have one axis association.
 */
public final class LinearCS extends CoordinateSystem
        implements org.opengis.referencing.cs.LinearCS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public LinearCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected LinearCS(final org.opengis.referencing.cs.LinearCS impl) {
        super(impl);
        entityType = "LinearCS";
    }
}
