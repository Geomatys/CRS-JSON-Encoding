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

import java.util.Collection;
import java.util.Set;


/**
 * Mathematical operation on coordinates in which the parameter values are defined rather than empirically derived.
 * Application of the coordinate conversion introduces no error into output coordinates.
 * The best-known example of a coordinate conversion is a map projection.
 * For coordinate conversions the output coordinates are referenced to the same datum as are the input coordinates.
 * Coordinate conversions forming a component of a derived CRS have a source CRS and a target CRS that are
 * <em>not</em> specified through the source and target associations,
 * but through associations from {@link DerivedCRS} to {@link SingleCRS}.
 */
public final class Conversion extends SingleOperation
        implements org.opengis.referencing.operation.Conversion
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    public Conversion() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl     implementation of a GeoAPI object to serialize.
     * @param withCRS  whether to initialize also {@link #sourceCRS} and {@link #targetCRS}.
     */
    protected Conversion(final org.opengis.referencing.operation.Conversion impl, boolean withCRS) {
        super(impl, withCRS);
        entityType = "Conversion";
    }

    /**
     * View of the conversion as a projection.
     * This is not standard API and was used by GeoAPI 3.0.2.
     */
    final class Projection implements org.opengis.referencing.operation.Projection {
        Projection() {
        }

        @Override
        public org.opengis.referencing.ReferenceIdentifier getName() {
            return Conversion.this.getName();
        }

        @Override
        public Collection<org.opengis.util.GenericName> getAlias() {
            return Conversion.this.getAlias();
        }

        @Override
        public Set<org.opengis.referencing.ReferenceIdentifier> getIdentifiers() {
            return Conversion.this.getIdentifiers();
        }

        @Override
        public org.opengis.util.InternationalString getRemarks() {
            return Conversion.this.getRemarks();
        }

        @Override
        public org.opengis.referencing.crs.CoordinateReferenceSystem getSourceCRS() {
            return Conversion.this.getSourceCRS();
        }

        @Override
        public org.opengis.referencing.crs.CoordinateReferenceSystem getTargetCRS() {
            return Conversion.this.getTargetCRS();
        }

        @Override
        public String getOperationVersion() {
            return Conversion.this.getOperationVersion();
        }

        @Override
        public org.opengis.referencing.operation.OperationMethod getMethod() {
            return Conversion.this.getMethod();
        }

        @Override
        public org.opengis.parameter.ParameterValueGroup getParameterValues() {
            return Conversion.this.getParameterValues();
        }

        @Override
        public Collection<org.opengis.metadata.quality.PositionalAccuracy> getCoordinateOperationAccuracy() {
            return Conversion.this.getCoordinateOperationAccuracy();
        }

        @Override
        public org.opengis.metadata.extent.Extent getDomainOfValidity() {
            return Conversion.this.getDomainOfValidity();
        }

        @Override
        public org.opengis.util.InternationalString getScope() {
            return Conversion.this.getScope();
        }

        @Override
        public org.opengis.referencing.operation.MathTransform getMathTransform() {
            return Conversion.this.getMathTransform();
        }

        @Override
        public String toWKT() {
            return Conversion.this.toWKT();
        }
    }
}
