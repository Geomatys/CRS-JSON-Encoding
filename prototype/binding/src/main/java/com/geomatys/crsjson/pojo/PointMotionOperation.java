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
 * Mathematical operation that decribes the change of coordinate values within one coordinate reference system
 * due to the motion of the point between one coordinate epoch and another coordinate epoch.
 * The motion can be due to tectonic plate movement or deformation.
 */
public final class PointMotionOperation extends SingleOperation
        // TODO: pending the definition of an interface in GeoAPI.
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public PointMotionOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl  implementation of a GeoAPI object to serialize.
     */
    protected PointMotionOperation(final org.opengis.referencing.operation.SingleOperation impl) {
        super(impl, true);
        entityType = "PointMotionOperation";
    }
}
