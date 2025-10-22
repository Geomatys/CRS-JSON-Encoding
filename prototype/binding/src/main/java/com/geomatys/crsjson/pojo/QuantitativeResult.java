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

import java.util.List;
import java.util.Collection;
import javax.measure.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * The values or information about the value(s) (or set of values) obtained from applying a data quality measure.
 *
 * @todo The value is a {@code Record}. But how to serialize records in <abbr>JSON</abbr> is unclear.
 *       It was unclear in <abbr>XML</abbr> too.
 */
public final class QuantitativeResult extends QualityResult
        implements org.opengis.metadata.quality.QuantitativeResult
{
    /**
     * Quantitative value or values, content determined by the evaluation procedure used.
     * Note: this is a {@code Record} in ISO 19157.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("quantitative value or values, content determined by the evaluation procedure used")
    public Measure value;

    /**
     * Statistical method used to determine the value.
     */
    @JsonProperty(index = 21)
    @JsonPropertyDescription("statistical method used to determine the value")
    public String errorStatistic;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public QuantitativeResult() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected QuantitativeResult(org.opengis.metadata.quality.QuantitativeResult impl) {
        super(impl);
        entityType = "QuantitativeResult";
        errorStatistic = text(impl.getErrorStatistic());
        for (org.opengis.util.Record r : impl.getValues()) {
            for (Object v : r.getAttributes().values()) {
                // We do not have a way to identify which entry is the value. So we take the first number.
                if (v instanceof Number n) {
                    final double d = n.doubleValue();
                    if (d > 0) {
                        value = new Measure(d, impl.getValueUnit());
                        return;
                    }
                }
            }
        }
    }

    @Override
    public Collection<org.opengis.util.Record> getValues() {
        return List.of();    // TODO
    }

    @Override
    public Unit<?> getValueUnit() {
        return Measure.unitOf(value);
    }

    @Override
    public org.opengis.util.RecordType getValueType() {
        return null;    // TODO
    }

    @Override
    public org.opengis.util.InternationalString getErrorStatistic() {
        return i18n(errorStatistic);
    }
}
