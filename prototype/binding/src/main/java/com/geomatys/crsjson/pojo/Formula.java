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
import org.opengis.util.InternationalString;


/**
 * Specification of the coordinate operation method formula.
 */
public final class Formula extends Entity
        implements org.opengis.referencing.operation.Formula
{
    /**
     * Formula(s) or procedure used by the coordinate operation method.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("formula(s) or procedure used by the coordinate operation method")
    public String formula;

    /**
     * Reference to a publication giving the formula(s) or procedure used by the coordinate operation method.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("reference to a publication giving the formula(s) or procedure used by the coordinate operation method")
    public Citation formulaCitation;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Formula() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected Formula(final org.opengis.referencing.operation.Formula impl) {
        entityType = "Formula";
        formula = text(impl.getFormula());
        formulaCitation = Citation.create(impl.getCitation());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static Formula create(org.opengis.referencing.operation.Formula impl) {
        return (impl == null || impl instanceof Formula)
                ? (Formula) impl : new Formula(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public InternationalString getFormula() {
        return i18n(formula);
    }

    @Override
    public org.opengis.metadata.citation.Citation getCitation() {
        return formulaCitation;
    }
}
