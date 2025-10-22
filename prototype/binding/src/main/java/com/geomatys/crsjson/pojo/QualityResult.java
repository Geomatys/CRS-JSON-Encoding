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
 * Base class of more specific result classes.
 */
public class QualityResult extends Entity
        implements org.opengis.metadata.quality.Result
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public QualityResult() {
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
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static QualityResult create(org.opengis.metadata.quality.Result impl) {
        return switch (impl) {
            case null -> null;
            case QualityResult subtype -> subtype;
            case org.opengis.metadata.quality.QuantitativeResult subtype -> new QuantitativeResult(subtype);
            default -> new QualityResult(impl);
        };
    }
}
