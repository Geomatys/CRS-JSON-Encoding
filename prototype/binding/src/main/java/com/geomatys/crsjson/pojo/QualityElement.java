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

import java.util.Date;
import java.util.Collection;
import org.opengis.metadata.quality.EvaluationMethodType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.util.function.Function;


/**
 * Aspect of quantitative quality information.
 */
public class QualityElement extends Entity
        implements org.opengis.metadata.quality.Element
{
    /**
     * Name of the test applied to the data.
     */
    @JsonProperty(index = 10)
    public String[] nameOfMeasure;

    /**
     * Code identifying a registered standard procedure.
     */
    @JsonProperty(index = 11)
    public Identifier measureIdentification;

    /**
     * Description of the measure being determined.
     */
    @JsonProperty(index = 12)
    public String measureDescription;

    /**
     * Type of method used to evaluate quality of the dataset.
     */
    @JsonProperty(index = 13)
    public String evaluationMethodType;

    /**
     * Description of the evaluation method.
     */
    @JsonProperty(index = 14)
    public String evaluationMethodDescription;

    /**
     * Reference to the procedure information.
     */
    @JsonProperty(index = 15)
    public Citation evaluationProcedure;

    /**
     * Date or range of dates on which a data quality measure was applied.
     * The array length is 1 for a single date, or 2 for a range.
     */
    @JsonProperty(index = 16)
    public Date[] dateTime;

    /**
     * Value (or set of values) obtained from applying a data quality measure.
     */
    @JsonProperty(index = 17, required = true)
    @JsonPropertyDescription("value (or set of values) obtained from applying a data quality measure")
    public QualityResult[] result;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public QualityElement() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected QualityElement(org.opengis.metadata.quality.Element impl) {
        entityType = "QualityElement";
        nameOfMeasure = array(impl.getNamesOfMeasure(), String[]::new, Entity::text);
        measureIdentification = Identifier.create(impl.getMeasureIdentification());
        measureDescription = text(impl.getMeasureDescription());
        evaluationMethodType = code(impl.getEvaluationMethodType());
        evaluationMethodDescription = text(impl.getEvaluationMethodDescription());
        evaluationProcedure = Citation.create(impl.getEvaluationProcedure());
        dateTime = array(impl.getDates(), Date[]::new, Function.identity());
        result = array(impl.getResults(), QualityResult[]::new, QualityResult::create);
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static QualityElement create(org.opengis.metadata.quality.Element impl) {
        return switch (impl) {
            case null -> null;
            case QualityElement subtype -> subtype;
            case org.opengis.metadata.quality.PositionalAccuracy subtype -> new PositionalAccuracy(subtype);
            default -> new QualityElement(impl);
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public Collection<org.opengis.util.InternationalString> getNamesOfMeasure() {
        return list(nameOfMeasure, Entity::i18n);
    }

    @Override
    public org.opengis.metadata.Identifier getMeasureIdentification() {
        return measureIdentification;
    }

    @Override
    public org.opengis.util.InternationalString getMeasureDescription() {
        return i18n(measureDescription);
    }

    @Override
    public EvaluationMethodType getEvaluationMethodType() {
        return codeForName(evaluationMethodType, EvaluationMethodType::valueOf);
    }

    @Override
    public org.opengis.util.InternationalString getEvaluationMethodDescription() {
        return i18n(evaluationMethodDescription);
    }

    @Override
    public org.opengis.metadata.citation.Citation getEvaluationProcedure() {
        return evaluationProcedure;
    }

    @Override
    public Collection<Date> getDates() {
        return list(dateTime);
    }

    @Override
    public Collection<org.opengis.metadata.quality.Result> getResults() {
        return list(result);
    }
}
