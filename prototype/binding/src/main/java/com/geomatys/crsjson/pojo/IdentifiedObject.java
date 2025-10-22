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

import java.util.Set;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Identifications of a <abbr>CRS</abbr>-related object.
 */
public class IdentifiedObject extends Entity
        implements org.opengis.referencing.IdentifiedObject
{
    /**
     * Primary name by which this object is identified.
     */
    @JsonProperty(index = 10, required = true)
    @JsonPropertyDescription("primary name by which this object is identified")
    public Identifier name;

    /**
     * Identifier which references elsewhere the object's defining information.
     * Alternatively an identifier by which this object can be referenced.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("identifier which references elsewhere the object's defining information")
    public Identifier[] identifier;

    /**
     * Alternative name by which this object is identified.
     */
    @JsonProperty(index = 12)
    @JsonPropertyDescription("alternative name by which this object is identified")
    public String[] alias;

    /**
     * Comments on or information about this object, including data source information.
     */
    @JsonProperty(index = 13)
    @JsonPropertyDescription("comments on or information about this object, including data source information")
    public String remarks;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public IdentifiedObject() {
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
    protected IdentifiedObject(final org.opengis.referencing.IdentifiedObject impl) {
        entityType = "IdentifiedObject";
        name       = Identifier.create(impl.getName());
        identifier = array(impl.getIdentifiers(), Identifier[]::new, Identifier::create);
        alias      = array(impl.getAlias(), String[]::new, org.opengis.util.GenericName::toString);     // TODO: Take locale in account.
        remarks    = text(impl.getRemarks());
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.ReferenceIdentifier getName() {
        return name;
    }

    @Override
    public Set<org.opengis.referencing.ReferenceIdentifier> getIdentifiers() {
        return Set.copyOf(list(identifier));
    }

    @Override
    public Collection<org.opengis.util.GenericName> getAlias() {
        return list(alias).stream().map(Entity::name).toList();
    }

    @Override
    public org.opengis.util.InternationalString getRemarks() {
        return i18n(remarks);
    }

    @Override
    public String toWKT() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
