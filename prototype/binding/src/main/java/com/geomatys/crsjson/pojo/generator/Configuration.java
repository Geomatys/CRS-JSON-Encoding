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
package com.geomatys.crsjson.pojo.generator;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JDefinedClass;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;


/**
 * Configuration of the {@code jsonschema2pojo} tool used for generating POJO.
 */
final class Configuration extends DefaultGenerationConfig {
    /**
     * Creates a new configuration.
     */
    Configuration() {
    }

    /**
     * Generator of the annotations to put on every classes.
     */
    static class Annotator extends Jackson2Annotator {
        Annotator(Configuration config) {
            super(config);
        }

        @Override
        protected void addJsonTypeInfoAnnotation(JDefinedClass jclass, String propertyName) {
            JAnnotationUse jsonTypeInfo = jclass.annotate(JsonTypeInfo.class);
            jsonTypeInfo.param("use", JsonTypeInfo.Id.CLASS);
            jsonTypeInfo.param("include", JsonTypeInfo.As.EXISTING_PROPERTY);
            jsonTypeInfo.param("property", "entityType");
        }
    }

    /**
     * Whether to include JSON type information.
     * Used to support polymorphic type deserialization.
     */
    @Override
    public boolean isIncludeTypeInfo() {
        return true;
    }

    /**
     * Do not generate additional properties.
     */
    @Override
    public boolean isIncludeAdditionalProperties() {
        return false;
    }

    /**
     * Whether to use include hashCode and equals methods in generated Java types.
     * Omitted because the JSON types generated in this project are only temporary.
     */
    @Override
    public boolean isIncludeHashcodeAndEquals() {
        return false;
    }

    /**
     * Whether to use include a toString method in generated Java types.
     * Omitted because the JSON types generated in this project are only temporary.
     */
    @Override
    public boolean isIncludeToString() {
        return false;
    }

    /**
     * Whether the resulting object should include a constructor with all listed properties as parameters.
     * Not needed because properties will be initialized from GeoAPI interfaces instead.
     */
    @Override
    public boolean isIncludeAllPropertiesConstructor() {
        return false;
    }

    /**
     * Do not initializes constructors, leave them to {@code null}.
     * It avoids writing empty collections at marshaling time.
     */
    @Override
    public boolean isInitializeCollections() {
        return false;
    }

    /**
     * Whether to include getters.
     * Not needed because the <abbr>POJO</abbr> are converted quickly to GeoAPI objects.
     */
    @Override
    public boolean isIncludeGetters() {
        return false;
    }

    /**
     * Whether to include setters.
     * Not needed because the <abbr>POJO</abbr> are created from GeoAPI objects.
     */
    @Override
    public boolean isIncludeSetters() {
        return false;
    }
}
