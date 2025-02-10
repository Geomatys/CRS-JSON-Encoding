
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;


/**
 * Aspect of quantitative quality information.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QualityElement extends Entity {
    /**
     * Value (or set of values) obtained from applying a data quality measure.
     */
    @JsonProperty(value="result", index=10, required=true)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("value (or set of values) obtained from applying a data quality measure")
    public Set<QualityResult> result;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected QualityElement() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected QualityElement(org.opengis.metadata.quality.Element impl) {
        entityType = "QualityElement";
        result = many(impl.getResults(), QualityResult::create);
        if (result != null && result.removeIf(QualityResult::isEmpty)) {
            if (result.isEmpty()) {
                result = null;
            }
        }
    }

    /**
     * Returns whether this element has no result.
     * An element may be empty because the results are encoded in record structures
     * that are not recognized by the current implementation of this class.
     *
     * @return whether this element has no result.
     */
    final boolean isEmpty() {
        return (result == null) || result.isEmpty();
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
            case org.opengis.metadata.quality.PositionalAccuracy subtype -> new PositionalAccuracy(subtype);
            default -> new QualityElement(impl);
        };
    }
}
