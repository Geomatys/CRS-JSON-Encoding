
package com.geomatys.json.referencing.pojo;

import javax.measure.Unit;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * measure object
 * <p>
 * definition of a measure object
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "uom"
})
@Generated("jsonschema2pojo")
public class Measure {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("value")
    public Double value;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("uom")
    public String uom;

    public Measure() {
    }

    public Measure(double v) {
        value = v;
    }

    public Measure(double v, Unit<?> unit) {
        value = v;
        uom = unit.getSymbol();
    }
}
