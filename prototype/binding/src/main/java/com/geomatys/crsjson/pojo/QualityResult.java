
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Base interface of more specific result classes.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QualityResult {
    /**
     * The object type.
     */
    @JsonProperty(value="entityType", index=0, required=true)
    public String entityType;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected QualityResult() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected QualityResult(org.opengis.metadata.quality.Result impl) {
        entityType = "QualityResult";
    }

    /**
     * Returns whether this element has no result.
     *
     * @return whether this element has no result.
     */
    boolean isEmpty() {
        return false;
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static QualityResult create(org.opengis.metadata.quality.Result impl) {
        return switch (impl) {
            case null -> null;
            case org.opengis.metadata.quality.QuantitativeResult subtype -> new QuantitativeResult(subtype);
            default -> new QualityResult(impl);
        };
    }
}
