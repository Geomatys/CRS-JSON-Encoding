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
 * Mathematical operation on coordinates in which parameters are empirically derived from data
 * containing the coordinates of a series of points in both coordinate reference systems.
 * This computational process is usually “over-determined”,
 * allowing derivation of error (or accuracy) estimates for the coordinate transformation.
 * Also, the stochastic nature of the parameters may result in multiple (different) versions
 * of the same coordinate transformations between the same source and target <abbr>CRS</abbr>s.
 * Any single coordinate operation in which the input and output coordinates are referenced to
 * different datums (reference frames) will be a coordinate transformation.
 */
public final class Transformation extends SingleOperation
        implements org.opengis.referencing.operation.Transformation
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public Transformation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected Transformation(final org.opengis.referencing.operation.Transformation impl) {
        super(impl, true);
        entityType = "Transformation";
    }
}
