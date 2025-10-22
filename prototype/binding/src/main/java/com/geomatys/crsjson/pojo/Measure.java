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

import java.time.Year;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoField;
import javax.measure.Unit;
import javax.measure.Quantity;
import javax.measure.spi.SystemOfUnits;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnitsService;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Value with its unit of measurement.
 */
public final class Measure extends Entity {
    /**
     * The provider of units of measurement, or {@code null} if none.
     */
    private static final SystemOfUnits UNITS;
    static {
        SystemOfUnits units = null;
        ServiceProvider provider = ServiceProvider.current();
        if (provider != null) {
            SystemOfUnitsService service = provider.getSystemOfUnitsService();
            if (service != null) {
                units = service.getSystemOfUnits();
            }
        }
        UNITS = units;
    }

    /**
     * The value.
     */
    @JsonProperty(index = 10, required = true)
    public double value;

    /**
     * The unit of measurement.
     */
    @JsonProperty(index = 11, required = true)
    public String uom;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Measure() {
        value = Double.NaN;
    }

    /**
     * Creates a new instance initialized to the given value and no unit.
     *
     * @param  value  the value.
     */
    public Measure(double value) {
        // `entityType` intentionally null.
        this.value = value;
    }

    /**
     * Creates a new instance initialized to the given value and unit.
     *
     * @param  value  the value.
     * @param  unit   the unit of measurement, or {@code null} if unspecified.
     */
    public Measure(double value, Unit<?> unit) {
        // `entityType` intentionally null.
        this.value = value;
        uom = symbolOf(unit);
    }

    /**
     * Returns the symbol of the given unit, or {@code null} if none.
     *
     * @param  unit  the unit for which to get the symbol, or {@code null}.
     * @return the symbol, or {@code null} if none or empty.
     */
    static String symbolOf(Unit<?> unit) {
        if (unit != null) {
            String uom = unit.getSymbol();
            if (uom != null && !uom.isBlank()) {
                return uom;
            }
        }
        return null;
    }

    /**
     * Returns the unit of measurement for the given symbol.
     *
     * @param  symbol  the unit symbol, or {@code null}.
     * @return unit of measurement, or {@code null}.
     */
    static Unit<?> unitForSymbol(String symbol) {
        if (UNITS != null && symbol != null) {
            return UNITS.getUnit(symbol);
        }
        return null;
    }

    /**
     * Returns the value of the given measure, or NaN if the measure is null.
     *
     * @param  measure  the measure from which to get the value.
     * @return the value, or NaN if none.
     */
    static double valueOf(Measure measure) {
        return (measure != null) ? measure.value : Double.NaN;
    }

    /**
     * Returns the unit of the given measure, or null if none.
     *
     * @param  measure  the measure from which to get the value.
     * @return the unit, or {@code null} if none.
     */
    static Unit<?> unitOf(Measure measure) {
        return (measure != null) ? unitForSymbol(measure.uom) : null;
    }

    /**
     * Returns the unit of the given measure, or null if none.
     *
     * @param  <Q>      compile-time value of {@code type}.
     * @param  measure  the measure from which to get the value.
     * @param  type     the type of the quantity which is measured.
     * @return the unit, or NaN if none.
     * @throws ClassCastException if the unit is not of the specified type.
     */
    static <Q extends Quantity<Q>> Unit<Q> unitOf(Measure measure, Class<Q> type) {
        final Unit<?> unit = unitOf(measure);
        return (unit != null) ? unit.asType(type) : null;
    }

    /**
     * Creates a new instance with values initialized from the given object.
     *
     * @param impl value to serialize, or {@code null}.
     * @return the serializable object, or {@code null} if the given object was null.
     */
    public static Measure create(final Temporal impl) {
        if (impl == null) {
            return null;
        }
        final var date = LocalDate.from(impl);
        final int year = date.getYear();
        final var epoch = new Measure(year);
        epoch.value += (date.getDayOfYear() - 1) / (double) Year.of(year).length();
        if (impl.isSupported(ChronoField.NANO_OF_DAY)) {
            epoch.value += impl.getLong(ChronoField.NANO_OF_DAY) / (24 * 60 * 60 * 1E+9);
        }
        epoch.uom = "yr";
        return epoch;
    }
}
