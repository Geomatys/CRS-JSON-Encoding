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
 * Two- or three-dimensional coordinate system in Euclidean space with straight axes that are not necessarily orthogonal.
 * The number of associations shall equal the dimension of the coordinate system.
 */
public class AffineCS extends CoordinateSystem
        implements org.opengis.referencing.cs.AffineCS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public AffineCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected AffineCS(final org.opengis.referencing.cs.AffineCS impl) {
        super(impl);
        entityType = "AffineCS";
    }
}
