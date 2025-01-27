
package com.geomatys.crsjson.pojo;

import javax.measure.Unit;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Value with its unit of measurement.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Measure {
    /**
     * The value.
     */
    @JsonProperty(value="value", index=10, required=true)
    public Double value;

    /**
     * The unit of measurement.
     */
    @JsonProperty(value="uom", index=20, required=true)
    public String uom;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Measure() {
    }

    /**
     * Creates a new instance initialized to the given value and no unit.
     *
     * @param  value  the value.
     */
    public Measure(double value) {
        this.value = value;
    }

    /**
     * Creates a new instance initialized to the given value and unit.
     *
     * @param  value  the value.
     * @param  unit   the unit of measurement, or {@code null} if unspecified.
     */
    public Measure(double value, Unit<?> unit) {
        this.value = value;
        uom = uom(unit);
    }

    /**
     * Returns the symbol of the given unit, or {@code null} if none.
     *
     * @param  unit  the unit for which to get the symbol, or {@code null}.
     * @return the symbol, or {@code null} if none or empty.
     */
    static String uom(Unit<?> unit) {
        if (unit != null) {
            String uom = unit.getSymbol();
            if (!uom.isBlank()) {
                return uom;
            }
        }
        return null;
    }
}
