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


/**
 * Parameter value or group of parameter values.
 */
public abstract class GeneralParameterValue extends Entity
        implements org.opengis.parameter.GeneralParameterValue, Cloneable
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    protected GeneralParameterValue() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected GeneralParameterValue(final org.opengis.parameter.GeneralParameterValue impl) {
        entityType = "GeneralParameterValue";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeneralParameterValue create(org.opengis.parameter.GeneralParameterValue impl) {
        return switch (impl) {
            case null -> null;
            case GeneralParameterValue subtype -> subtype;
            case org.opengis.parameter.ParameterValue<?>   subtype -> new OperationParameterValue(subtype);
            case org.opengis.parameter.ParameterValueGroup subtype -> new ParameterValueGroup    (subtype);
            default -> throw new IllegalArgumentException("Parameter must be value or group.");
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    /**
     * Returns a copy of this parameter value or group.
     */
    @Override
    public org.opengis.parameter.GeneralParameterValue clone() {
        try {
            return (GeneralParameterValue) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
