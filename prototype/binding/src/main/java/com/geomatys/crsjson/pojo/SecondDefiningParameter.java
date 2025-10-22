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
 * Definition of the second parameter that defines the shape of a biaxial ellipsoid,
 * or the third parameter that defines a triaxial ellipsoid.
 * A biaxial ellipsoid requires two defining parameters:
 * a semi-major axis and inverse flattening or a semi-major axis and a semi-minor axis.
 * When the reference body is a sphere rather than an ellipsoid, only a single defining parameter is required,
 * namely the radius of the sphere. in that case, the semi-major axis “degenerates” into the radius of the sphere.
 */
public final class SecondDefiningParameter extends Entity {
    /**
     * Inverse flattening value of the ellipsoid.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("inverse flattening value of the ellipsoid")
    public Measure inverseFlattening;

    /**
     * Length of the semi-minor axis of the ellipsoid.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("length of the semi-minor axis of the ellipsoid")
    public Measure semiMinorAxis;

    /**
     * Ellipsoid is degenerate and is actually a sphere.
     * The sphere is completely defined by the semi-major axis, which is the radius of the sphere.
     * This attribute has the value {@code true} if the figure is a sphere.
     */
    @JsonProperty(index = 12)
    @JsonPropertyDescription("ellipsoid is degenerate and is actually a sphere")
    public Boolean isSphere;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public SecondDefiningParameter() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public SecondDefiningParameter(org.opengis.referencing.datum.Ellipsoid impl) {
        // `entityType` intentionally null because this is an union.
        isSphere = impl.isSphere();
        if (impl.isIvfDefinitive()) {
            inverseFlattening = new Measure(impl.getInverseFlattening());
        } else {
            semiMinorAxis = new Measure(impl.getSemiMinorAxis(), impl.getAxisUnit());
        }
    }
}
