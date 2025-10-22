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
 * A collection of two or more datums (or if geodetic or vertical, a collection of two or more reference frames)
 * that are realizations of one Conventional Reference System and which for all but the highest accuracy requirements
 * may be considered to be insignificantly different from each other.
 * Within the datum ensemble every frame or datum is constrained to be a realization of the same reference system.
 */
public final class DatumEnsemble extends ObjectUsage
        // TODO: pending the definition of an interface in GeoAPI.
{
    /**
     * Datum or reference frame which is a member of this datum ensemble.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("datum or reference frame which is a member of this datum ensemble")
    public Datum[] datum;

    /**
     * Inaccuracy introduced through use of this collection of reference frames or datums.
     * It is an indication of the differences in coordinate values at all points between
     * the various realizations that have been grouped into this datum ensemble.
     */
    @JsonProperty(index = 21, required = true)
    @JsonPropertyDescription("inaccuracy introduced through use of this collection of reference frames or datums")
    public PositionalAccuracy ensembleAccuracy;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DatumEnsemble() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    @SuppressWarnings("unchecked")
    protected DatumEnsemble(final org.opengis.referencing.IdentifiedObject impl) {
        super(impl, new ObjectDomain().setByReflection(impl));
        entityType = "DatumEnsemble";
        datum = array(getByReflection(Collection.class, impl, "getMembers"), Datum[]::new, Datum::create);
        ensembleAccuracy = PositionalAccuracy.create(getByReflection(org.opengis.metadata.quality.PositionalAccuracy.class, impl, "getEnsembleAccuracy"));
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static DatumEnsemble create(org.opengis.referencing.IdentifiedObject impl) {
        return (impl == null || impl instanceof DatumEnsemble)
                ? (DatumEnsemble) impl : new DatumEnsemble(impl);
    }
}
