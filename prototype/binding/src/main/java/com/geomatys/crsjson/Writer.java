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
package com.geomatys.crsjson;

import java.util.Locale;
import java.util.Objects;
import org.opengis.referencing.datum.Datum;
import org.opengis.referencing.cs.CoordinateSystem;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * Utility methods for writing a <abbr>CRS</abbr> in JSON.
 * This class accepts any implementation of GeoAPI.
 */
public class Writer {
    /**
     * The JSON marshaller.
     */
    private final ObjectMapper mapper;

    /**
     * The locale to use for internationalized text, or {@code null} for the default locale.
     * TODO: not yet used.
     */
    private final Locale locale;

    /**
     * Creates a new writer.
     */
    public Writer() {
        locale = null;
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Creates a new writer.
     *
     * @param  mapper  the Jackson object mapper to use.
     * @param  locale  the locale to use for internationalized text, or {@code null} for the default locale.
     */
    public Writer(final ObjectMapper mapper, final Locale locale) {
        this.mapper = Objects.requireNonNull(mapper);
        this.locale = locale;
    }

    /**
     * Formats the given GeoAPI implementation as a JSON document.
     *
     * @param  impl implementation of a GeoAPI object to serialize.
     * @return the JSON document for the given object.
     * @throws JsonProcessingException if an error occurred during the serialization.
     */
    public String write(final CoordinateReferenceSystem impl) throws JsonProcessingException {
        return mapper.writeValueAsString(com.geomatys.crsjson.pojo.Crs.create(impl));
    }

    /**
     * Formats the given GeoAPI implementation as a JSON document.
     *
     * @param  impl implementation of a GeoAPI object to serialize.
     * @return the JSON document for the given object.
     * @throws JsonProcessingException if an error occurred during the serialization.
     */
    public String write(final Datum impl) throws JsonProcessingException {
        return mapper.writeValueAsString(com.geomatys.crsjson.pojo.Datum.create(impl));
    }

    /**
     * Formats the given GeoAPI implementation as a JSON document.
     *
     * @param  impl implementation of a GeoAPI object to serialize.
     * @return the JSON document for the given object.
     * @throws JsonProcessingException if an error occurred during the serialization.
     */
    public String write(final CoordinateSystem impl) throws JsonProcessingException {
        return mapper.writeValueAsString(com.geomatys.crsjson.pojo.CoordinateSystem.create(impl));
    }

    /**
     * Formats the given GeoAPI implementation as a JSON document.
     *
     * @param  impl implementation of a GeoAPI object to serialize.
     * @return the JSON document for the given object.
     * @throws JsonProcessingException if an error occurred during the serialization.
     */
    public String write(final CoordinateOperation impl) throws JsonProcessingException {
        return mapper.writeValueAsString(com.geomatys.crsjson.pojo.CoordinateOperation.create(impl));
    }
}
