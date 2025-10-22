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
import java.util.function.Function;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.IncommensurableException;
import org.opengis.parameter.InvalidParameterTypeException;
import org.opengis.parameter.InvalidParameterValueException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Parameter value, ordered sequence of values, or reference to a file of parameter values.
 */
public final class OperationParameterValue extends GeneralParameterValue
        implements org.opengis.parameter.ParameterValue<Object>
{
    /**
     * Parameter or parameter group which has this value or value group.
     */
    @JsonProperty(index = 20, required = true)
    @JsonPropertyDescription("parameter or parameter group which has this value or value group")
    public OperationParameter parameter;

    /**
     * Value of the coordinate operation parameter.
     */
    @JsonProperty(index = 21, required = true)
    @JsonPropertyDescription("value of the coordinate operation parameter")
    public ParameterValue parameterValue;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public OperationParameterValue() {
    }

    /**
     * Creates a new instance associated to the given parameter descriptor.
     *
     * @param  parameter  description of the parameter.
     */
    protected OperationParameterValue(final OperationParameter parameter) {
        this.parameter = parameter;
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected OperationParameterValue(final org.opengis.parameter.ParameterValue<?> impl) {
        entityType = "OperationParameterValue";
        parameterValue = new ParameterValue(impl);
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    /**
     * Returns the abstract definition of this parameter value.
     */
    @Override
    public org.opengis.parameter.ParameterDescriptor<Object> getDescriptor() {
        return parameter;
    }

    /**
     * Returns the name of this parameter, for error messages only.
     * All parameter shall have a name since it is a mandatory property,
     * but if this parameter is nevertheless unnamed, an arbitrary value is returned.
     */
    private String getName() {
        if (parameter != null) {
            final Identifier id = parameter.name;
            if (id != null) {
                return id.code;
            }
        }
        return "unnamed";
    }

    /**
     * Returns the exception to throw for an unconvertible unit.
     */
    private IllegalArgumentException cannotConvert(Unit<?> unit, IncommensurableException cause) {
        String name = getName();
        var e = new IllegalArgumentException("Can not convert the value of \"" + name + "\" to " + unit + " unit.");
        if (cause != null) e.initCause(cause);
        return e;
    }

    /**
     * Returns the unit of measure of the parameter value.
     * If the parameter value has no unit (for example because it is a {@link String} type),
     * then this method returns {@code null}. Note that "no unit" doesn't means
     * "dimensionless".
     */
    @Override
    public Unit<?> getUnit() {
        if (parameterValue == null) {
            return null;
        }
        Unit<?> unit = Measure.unitOf(parameterValue.value);
        if (unit == null) {
            final Measure[] values = parameterValue.valueList;
            if (values != null) {
                for (Measure value : values) {
                    unit = Measure.unitOf(value);
                    if (unit != null) break;
                }
            }
        }
        return unit;
    }

    /**
     * Returns the numeric value of this parameter in the specified unit of measure.
     * This convenience method applies unit conversion on the fly as needed.
     *
     * @param  unit  the unit of measure for the value to be returned.
     * @return the numeric value represented by this parameter after conversion.
     * @throws IllegalArgumentException if the specified unit is invalid for this parameter.
     * @throws InvalidParameterTypeException if the value is not a numeric type.
     */
    @Override
    public double doubleValue(Unit<?> unit) {
        double value = doubleValue();
        final Unit<?> uom = getUnit();
        if (uom != null) try {
            value = uom.getConverterToAny(unit).convert(value);
        } catch (IncommensurableException cause) {
            throw cannotConvert(unit, cause);
        }
        return value;
    }

    /**
     * Returns the numeric value of this operation parameter.
     * The unit of measurement is specified by {@link #getUnit()}.
     *
     * @return the numeric value represented by this parameter after conversion to type {@code double}.
     * @throws InvalidParameterTypeException if the value is not a numeric type.
     */
    @Override
    public double doubleValue() {
        return getValue((p) -> Measure.valueOf(p.value));
    }

    /**
     * Returns the integer value of this parameter, usually used for a count.
     * An integer value does not have an associated unit of measure.
     *
     * @return the numeric value represented by this parameter after conversion to type {@code int}.
     * @throws InvalidParameterTypeException if the value is not an integer type.
     */
    @Override
    public int intValue() {
        return getValue((p) -> p.integerValue);
    }

    /**
     * Returns the Boolean value of this parameter.
     * A Boolean value does not have an associated unit of measure.
     *
     * @return the Boolean value represented by this parameter.
     * @throws InvalidParameterTypeException if the value is not a Boolean type.
     */
    @Override
    public boolean booleanValue() {
        return getValue((p) -> p.booleanValue);
    }

    /**
     * Returns the string value of this parameter.
     * A string value does not have an associated unit of measure.
     *
     * @return the string value represented by this parameter.
     * @throws InvalidParameterTypeException if the value is not a string.
     */
    @Override
    public String stringValue() {
        return getValue((p) -> p.stringValue);
    }

    /**
     * Returns an ordered sequence of numeric values in the specified unit of measure.
     * This convenience method applies unit conversions on the fly as needed.
     *
     * @param  unit  the unit of measure for the value to be returned.
     * @return the sequence of values represented by this parameter after conversion.
     * @throws IllegalArgumentException if the specified unit is invalid for this parameter.
     * @throws InvalidParameterTypeException if the value is not an array of {@code double}s.
     */
    @Override
    public double[] doubleValueList(Unit<?> unit) {
        final double[] values = doubleValueList();
        if (values != null && unit != null) {
            final Unit<?> uom = getUnit();
            if (uom != null) try {
                final UnitConverter c = uom.getConverterToAny(unit);
                for (int i=0; i<values.length; i++) {
                    values[i] = c.convert(values[i]);
                }
            } catch (IncommensurableException cause) {
                throw cannotConvert(unit, cause);
            } else {
                throw cannotConvert(unit, null);
            }
        }
        return values;
    }

    /**
     * Returns an ordered sequence of two or more numeric values of this parameter,
     * where each value has the same associated unit of measure.
     *
     * @return the sequence of values represented by this parameter.
     * @throws InvalidParameterTypeException if the value is not an array of {@code double}s.
     */
    @Override
    public double[] doubleValueList() {
        return getValue(ParameterValue::doubleValueList);
    }

    /**
     * Returns an ordered sequence of two or more integer values of this parameter, usually used for counts.
     * These integer values do not have an associated unit of measure.
     *
     * @return the sequence of values represented by this parameter.
     * @throws InvalidParameterTypeException if the value is not an array of {@code int}s.
     */
    @Override
    public int[] intValueList() {
        return getValue(ParameterValue::integerValueList);
    }

    /**
     * Returns a reference to a file or a part of a file containing one or more parameter values.
     *
     * @return the reference to a file containing parameter values.
     * @throws InvalidParameterTypeException if the value is not a reference to a file or a URI.
     * @throws IllegalStateException if the <abbr>URI</abbr> syntax is invalid.
     */
    @Override
    public URI valueFile() {
        return getValue(ParameterValue::valueFile);
    }

    /**
     * Returns the parameter value as an object. The object type is typically (but not restricted to)
     * {@link Double}, {@link Integer}, {@link Boolean}, {@link String}, {@link URI}, {@code double[]}
     * or {@code int[]}.
     *
     * @return the parameter value as an object, or {@code null} if no value has been set and there is no default value.
     */
    @Override
    public Object getValue() {
        return (parameterValue != null) ? parameterValue.getAnyValue() : null;
    }

    /**
     * Returns the value by invoking the specified method on the parameter value.
     *
     * @param  <T>     the type of the desired object.
     * @param  mapper  the function to invoke for getting the value.
     * @return the parameter value.
     * @throws InvalidParameterTypeException if there is no value of the expected type.
     */
    private <T> T getValue(final Function<ParameterValue, T> mapper) {
        if (parameterValue != null) {
            final T value = mapper.apply(parameterValue);
            if (value != null) {
                return value;
            }
        }
        final String name = getName();
        throw new InvalidParameterTypeException("No value of requested type for the \"" + name + "\" parameter.", name);
    }

    /**
     * Sets the parameter value as an array of floating point and their associated unit.
     *
     * @param  values  the parameter values.
     * @param  unit    the unit for the specified value.
     */
    @Override
    public void setValue(double[] values, Unit<?> unit) {
        parameterValue = new ParameterValue();
        parameterValue.set(values, unit);
    }

    /**
     * Sets the parameter value as a floating point and its associated unit.
     *
     * @param  value  the parameter value.
     * @param  unit   the unit for the specified values.
     */
    @Override
    public void setValue(double value, Unit<?> unit) {
        parameterValue = new ParameterValue();
        parameterValue.value = new Measure(value, unit);
    }

    /**
     * Sets the parameter value as a floating point.
     *
     * @param  value  the parameter value.
     */
    @Override
    public void setValue(double value) {
        parameterValue = new ParameterValue();
        parameterValue.value = new Measure(value);
    }

    /**
     * Sets the parameter value as an integer.
     *
     * @param  value  the parameter value.
     */
    @Override
    public void setValue(int value) {
        parameterValue = new ParameterValue();
        parameterValue.integerValue = value;
    }

    /**
     * Sets the parameter value as a Boolean.
     *
     * @param  value  the parameter value.
     */
    @Override
    public void setValue(boolean value) {
        parameterValue = new ParameterValue();
        parameterValue.booleanValue = value;
    }

    /**
     * Sets the parameter value as an object. The object type is typically (but not restricted to)
     * {@link Double}, {@link Integer}, {@link Boolean}, {@link String}, {@link URI}, {@code double[]}
     * or {@code int[]}.
     *
     * @param  value  the parameter value.
     * @throws InvalidParameterValueException if the type of {@code value} is incorrect for this parameter.
     */
    @Override
    public void setValue(Object value) {
        switch (value) {
            case null: parameterValue = null; break;
            case double[] v: setValue(v, null); break;
            case Double   v: setValue(v.doubleValue()); break;
            case Integer  v: setValue(v.intValue()); break;
            case Boolean  v: setValue(v.booleanValue()); break;
            default: throw new InvalidParameterValueException("Unsupported value type.", getName(), value);
        }
    }

    /**
     * Returns a copy of this parameter value.
     */
    @Override
    public org.opengis.parameter.ParameterValue<Object> clone() {
        return (OperationParameterValue) super.clone();
    }
}
