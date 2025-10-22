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

import org.opengis.parameter.ParameterNotFoundException;


/**
 * Definition of a parameter or group of parameters used by a coordinate operation method.
 */
public abstract class GeneralOperationParameter extends IdentifiedObject
        implements org.opengis.parameter.GeneralParameterDescriptor
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    protected GeneralOperationParameter() {
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
    protected GeneralOperationParameter(final org.opengis.parameter.GeneralParameterDescriptor impl) {
        super(impl);
        entityType = "GeneralOperationParameter";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static GeneralOperationParameter create(org.opengis.parameter.GeneralParameterDescriptor impl) {
        return switch (impl) {
            case null -> null;
            case GeneralOperationParameter subtype -> subtype;
            case org.opengis.parameter.ParameterDescriptor<?>   subtype -> new OperationParameter     (subtype);
            case org.opengis.parameter.ParameterDescriptorGroup subtype -> new OperationParameterGroup(subtype);
            default -> throw new IllegalArgumentException("Parameter must be value or group.");
        };
    }

    /**
     * Returns whether this parameter has the given name, ignoring case.
     *
     * @param  code  the name to search.
     * @return whether this parameter is the one that we are looking for.
     */
    final boolean isIdentifiedBy(final String code) {
        return (name != null) && code.equalsIgnoreCase(name.code);
    }

    /**
     * Returns the exception to throw if no parameter of the given name was found.
     *
     * @param  name  the name of the parameter requested by the user.
     * @return the exception to throw.
     */
    static ParameterNotFoundException parameterNotFound(final String name) {
        return new ParameterNotFoundException("No parameter named \"" + name + "\".", name);
    }
}
