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

import org.opengis.temporal.TemporalPrimitive;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Temporal domain of resource.
 */
public final class TemporalExtent extends Entity
        implements org.opengis.metadata.extent.TemporalExtent
{
    /**
     * Period for the content of the resource.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("period for the content of the resource")
    public Period extent;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public TemporalExtent() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected TemporalExtent(org.opengis.metadata.extent.TemporalExtent impl) {
        entityType = "TemporalExtent";
        extent = Period.create(impl.getExtent());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static TemporalExtent create(org.opengis.metadata.extent.TemporalExtent impl) {
        return (impl == null || impl instanceof TemporalExtent)
                ? (TemporalExtent) impl : new TemporalExtent(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public TemporalPrimitive getExtent() {
        return extent;
    }
}
