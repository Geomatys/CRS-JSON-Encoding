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
 * Two-dimensional coordinate system in Euclidean space in which position is specified by the distance
 * from the origin and the angle between the line from the origin to a point and a reference direction.
 * A {@code PolarCS} shall have two axis associations.
 */
public final class PolarCS extends CoordinateSystem
        implements org.opengis.referencing.cs.PolarCS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public PolarCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected PolarCS(final org.opengis.referencing.cs.PolarCS impl) {
        super(impl);
        entityType = "PolarCS";
    }
}
