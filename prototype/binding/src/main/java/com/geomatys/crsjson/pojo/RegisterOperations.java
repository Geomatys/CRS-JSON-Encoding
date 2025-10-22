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
 * Operations supported in the Coordinate Operations package.
 */
public final class RegisterOperations extends Entity {
    /**
     * Citation used by this register operation.
     */
    @JsonProperty(index = 10, required = true)
    @JsonPropertyDescription("citation used by this register operation")
    public Citation authority;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public RegisterOperations() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected RegisterOperations(final org.opengis.referencing.AuthorityFactory impl) {
        entityType = "RegisterOperations";
        authority = Citation.create(impl.getAuthority());
    }
}
