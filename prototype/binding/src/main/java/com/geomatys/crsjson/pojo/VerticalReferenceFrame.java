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

import org.opengis.util.CodeList;
import org.opengis.referencing.datum.VerticalDatumType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Textual description and/or a set of parameters identifying a particular reference level surface
 * used as a zero-height or zero-depth surface, including its position with respect to the Earth.
 *
 * <p><b>Note:</b> In 19111:2007 this class was called {@code VerticalDatum}.</p>
 */
public class VerticalReferenceFrame extends Datum
        implements org.opengis.referencing.datum.VerticalDatum
{
    /**
     * Specification of the method by which the vertical reference frame is realized.
     */
    @JsonProperty(index = 30)
    @JsonPropertyDescription("specification of the method by which the vertical reference frame is realized")
    public String realizationMethod;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public VerticalReferenceFrame() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    @SuppressWarnings("unchecked")
    protected VerticalReferenceFrame(final org.opengis.referencing.datum.VerticalDatum impl) {
        super(impl);
        entityType = "VerticalReferenceFrame";
        realizationMethod = code(getOptionalByReflection(CodeList.class, impl, "getRealizationMethod"));
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static VerticalReferenceFrame create(org.opengis.referencing.datum.VerticalDatum impl) {
        return (impl == null || impl instanceof VerticalReferenceFrame)
                ? (VerticalReferenceFrame) impl : new VerticalReferenceFrame(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public VerticalDatumType getVerticalDatumType() {
        return codeForName(realizationMethod, VerticalDatumType::valueOf);
    }
}
