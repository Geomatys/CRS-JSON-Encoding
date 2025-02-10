
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.opengis.util.Record;


/**
 * The values or information about the value(s) (or set of values) obtained from applying a data quality measure.
 *
 * @todo The value is a {@code Record}. But how to serialize records in <abbr>JSON</abbr> is unclear.
 *       It was unclear in <abbr>XML</abbr> too.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuantitativeResult extends QualityResult {
    /**
     * Quantitative value or values, content determined by the evaluation procedure used.
     * Note: this is a {@code Record} in ISO 19157.
     */
    @JsonProperty(value="value", index=100, required=true)
    @JsonPropertyDescription("quantitative value or values, content determined by the evaluation procedure usede")
    public Measure value;

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
    public QuantitativeResult(org.opengis.metadata.quality.QuantitativeResult impl) {
        super(impl);
        entityType = "QuantitativeResult";
        for (Record r : impl.getValues()) {
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

    /**
     * Returns whether this element has no result.
     *
     * @return whether this element has no result.
     */
    @Override
    final boolean isEmpty() {
        return value == null;
    }
}
