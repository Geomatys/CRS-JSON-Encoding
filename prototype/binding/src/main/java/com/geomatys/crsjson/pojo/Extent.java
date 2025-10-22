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

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Information about spatial, vertical, and temporal extent of the resource.
 */
public final class Extent extends Entity
        implements org.opengis.metadata.extent.Extent
{
    /**
     * The spatial and temporal extent for the referring object.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("the spatial and temporal extent for the referring object")
    public String description;

    /**
     * Provides geographic component of the extent of the referring object.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("provides geographic component of the extent of the referring object")
    public GeographicExtent[] geographicElement;

    /**
     * Provides vertical component of the extent of the referring object.
     */
    @JsonProperty(index = 12)
    @JsonPropertyDescription("provides vertical component of the extent of the referring object")
    public VerticalExtent[] verticalElement;

    /**
     * Provides temporal component of the extent of the referring object.
     */
    @JsonProperty(index = 13)
    @JsonPropertyDescription("provides temporal component of the extent of the referring object")
    public TemporalExtent[] temporalElement;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Extent() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected Extent(org.opengis.metadata.extent.Extent impl) {
        entityType = "Extent";
        description = text(impl.getDescription());
        geographicElement = array(impl.getGeographicElements(), GeographicExtent[]::new, GeographicExtent::create);
        verticalElement   = array(impl.getVerticalElements(),     VerticalExtent[]::new,   VerticalExtent::create);
        temporalElement   = array(impl.getTemporalElements(),     TemporalExtent[]::new,   TemporalExtent::create);
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static Extent create(org.opengis.metadata.extent.Extent impl) {
        return (impl == null || impl instanceof Extent)
                ? (Extent) impl : new Extent(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.util.InternationalString getDescription() {
        return i18n(description);
    }

    @Override
    public Collection<org.opengis.metadata.extent.GeographicExtent> getGeographicElements() {
        return list(geographicElement);
    }

    @Override
    public Collection<org.opengis.metadata.extent.VerticalExtent> getVerticalElements() {
        return list(verticalElement);
    }

    @Override
    public Collection<org.opengis.metadata.extent.TemporalExtent> getTemporalElements() {
        return list(temporalElement);
    }
}
