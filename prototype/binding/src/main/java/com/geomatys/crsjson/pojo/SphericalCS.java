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
 * Two or three-dimensional coordinate system in Euclidean space with two angular coordinates
 * and (in the 3D case) one distance measured from the origin.
 * Not to be confused with an ellipsoidal coordinate system based on an ellipsoid "degenerated" into a sphere.
 * A {@code SphericalCS} shall have two or three axis associations.
 * The number of associations shall equal the dimension of the coordinate system.
 */
public final class SphericalCS extends CoordinateSystem
        implements org.opengis.referencing.cs.SphericalCS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public SphericalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected SphericalCS(final org.opengis.referencing.cs.SphericalCS impl) {
        super(impl);
        entityType = "SphericalCS";
    }
}
