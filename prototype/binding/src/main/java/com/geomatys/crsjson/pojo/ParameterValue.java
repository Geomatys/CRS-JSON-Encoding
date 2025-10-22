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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import javax.measure.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Value of the coordinate operation parameter.
 */
public final class ParameterValue extends Entity {
    /**
     * Numeric value of the coordinate operation parameter with its associated unit.
     */
    @JsonProperty(index = 10)
    @JsonPropertyDescription("numeric value of the coordinate operation parameter with its associated unit")
    public Measure value;

    /**
     * String value of a coordinate operation parameter.
     * A string value does not have an associated unit.
     */
    @JsonProperty(index = 11)
    @JsonPropertyDescription("string value of a coordinate operation parameter")
    public String stringValue;

    /**
     * Positive integer value of a coordinate operation parameter, usually used for a count.
     * An integer value does not have an associated unit.
     */
    @JsonProperty(index = 12)
    @JsonPropertyDescription("positive integer value of a coordinate operation parameter, usually used for a count")
    public Integer integerValue;

    /**
     * Boolean value of a coordinate operation parameter.
     * A Boolean value does not have an associated unit.
     */
    @JsonProperty(index = 13)
    @JsonPropertyDescription("boolean value of a coordinate operation parameter")
    public Boolean booleanValue;

    /**
     * Ordered collection (sequence), of two or more numeric values of a coordinate operation parameter list,
     * where each value has the same associated unit.
     */
    @JsonProperty(index = 14)
    @JsonPropertyDescription("ordered collection, i.e. sequence, of two or more numeric values of a coordinate operation parameter list, where each value has the same associated unit")
    public Measure[] valueList;

    /**
     * Ordered collection (sequence), of two or more integer values of a coordinate operation parameter list, usually used for counts.
     * These integer values do not have an associated unit.
     */
    @JsonProperty(index = 15)
    @JsonPropertyDescription("ordered collection, i.e. sequence, of two or more integer values of a coordinate operation parameter list, usually used for counts")
    public int[] integerValueList;

    /**
     * Reference to a file or an identified part of a file containing one or more parameter values.
     * The referenced file or part of a file can reference another part of the same or different files, as allowed in XML documents.
     */
    @JsonProperty(index = 16)
    @JsonPropertyDescription("reference to a file or an identified part of a file containing one or more parameter values")
    public String valueFile;

    /**
     * Citation for a reference to a file or an identified part of a file containing one or more parameter values.
     * The referenced file or part of a file can reference another part of the same or different files, as allowed in XML documents.
     */
    @JsonProperty(index = 17)
    @JsonPropertyDescription("citation for a reference to a file or an identified part of a file containing one or more parameter values")
    public Citation valueFileCitation;

    /**
     * Identifier of a geographic feature of which the coordinates are used as operation parameters.
     */
    @JsonProperty(index = 18)
    @JsonPropertyDescription("identifier of a geographic feature of which the coordinates are used as operation parameters")
    public GeographicObject geographicObject;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ParameterValue() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ParameterValue(final org.opengis.parameter.ParameterValue<?> impl) {
        // `entityType` intentionally null because this is an union.
        final Object obj = impl.getValue();
        if (obj != null) {
            switch (obj) {
                case Measure  v -> value            = v;
                case String   v -> stringValue      = v;
                case Integer  v -> integerValue     = v;
                case Boolean  v -> booleanValue     = v;
                case URI      v -> valueFile        = v.toString();
                case int[]    v -> integerValueList = v;
                case double[] v -> set(v, impl.getUnit());
                case org.opengis.metadata.citation.Citation v -> valueFileCitation = new Citation(v);
                case org.opengis.geometry.Geometry v -> geographicObject = new GeographicObject(v);
                default -> value = new Measure(impl.doubleValue(), impl.getUnit());
            }
        }
    }

    /**
     * Sets the values from an array of floating point values.
     *
     * @param  values  the values to set.
     * @param  unit    the unit of measurement, or {@code null} if none.
     */
    final void set(final double[] values, final Unit<?> unit) {
        valueList = Arrays.stream(values).mapToObj((v) -> new Measure(v, unit)).toArray(Measure[]::new);
    }

    /**
     * Returns the first non-null property, in the order they are declared.
     *
     * @return the first non-null property.
     */
    public Object getAnyValue() {
        Object obj;
        if (null == (obj = value())
        || (null == (obj = stringValue))
        || (null == (obj = integerValue))
        || (null == (obj = booleanValue))
        || (null == (obj = doubleValueList()))
        || (null == (obj = integerValueList()))
        || (null == (obj = valueFile()))
        || (null == (obj = valueFileCitation)))
                     obj = geographicObject;
        return obj;
    }

    /**
     * Returns {@link #value} as a floating point.
     */
    private Double value() {
        if (value != null) {
            return value.value;
        } else {
            return null;
        }
    }

    /**
     * Returns {@link #valueList} as an array.
     */
    final double[] doubleValueList() {
        if (valueList != null) {
            return Arrays.stream(valueList).mapToDouble((measure) -> measure.value).toArray();
        } else {
            return null;
        }
    }

    /**
     * Returns {@link #integerValueList} as an array.
     */
    final int[] integerValueList() {
        if (integerValueList != null) {
            return integerValueList.clone();
        } else {
            return null;
        }
    }

    /**
     * Returns {@link #valueFile} as an <abbr>URI</abbr>.
     *
     * @return the reference to a file containing parameter values, or {@code null} if none.
     * @throws IllegalStateException if the <abbr>URI</abbr> syntax is invalid.
     */
    final URI valueFile() {
        if (valueFile != null) try {
            return new URI(valueFile);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Value file is not a valid URI.", e);
        } else {
            return null;
        }
    }
}
