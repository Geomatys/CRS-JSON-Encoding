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
 * One-dimensional coordinate system used to record the heights or depths of points,
 * usually dependent on the Earth's gravity field.
 * A {@code VerticalCS} shall have one axis association.
 */
public final class VerticalCS extends CoordinateSystem
        implements org.opengis.referencing.cs.VerticalCS
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public VerticalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected VerticalCS(final org.opengis.referencing.cs.VerticalCS impl) {
        super(impl);
        entityType = "VerticalCS";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static VerticalCS create(org.opengis.referencing.cs.VerticalCS impl) {
        return (impl == null || impl instanceof VerticalCS)
                ? (VerticalCS) impl : new VerticalCS(impl);
    }
}
