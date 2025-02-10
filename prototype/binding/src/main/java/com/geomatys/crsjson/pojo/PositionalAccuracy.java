
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Accuracy of the position of features.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PositionalAccuracy extends QualityElement {
    /**
     * Creates a new instance with all values initialized to null.
     */
    public PositionalAccuracy() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public PositionalAccuracy(org.opengis.metadata.quality.PositionalAccuracy impl) {
        super(impl);
        entityType = "PositionalAccuracy";
    }
}
