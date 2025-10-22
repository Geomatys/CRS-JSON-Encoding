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
import java.time.temporal.Temporal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Mathematical operation between two Coordinate Reference Systems or two epochs.
 * It may be an operation:
 *
 * <ul>
 *   <li>on coordinates that transforms or converts them from one coordinate reference system
 *       to another coordinate reference system, or</li>
 *   <li>that describes the change of coordinate values within one coordinate reference system
 *       due to the motion of the point between one coordinate epoch and another coordinate epoch.</li>
 * </ul>
 *
 * Many but not all coordinate operations (from <abbr>CRS</abbr> <var>A</var> to <abbr>CRS</abbr> <var>B</var>) also
 * uniquely define the inverse coordinate operation (from <abbr>CRS</abbr> <var>B</var> to <abbr>CRS</abbr> <var>A</var>).
 * In some cases, the coordinate operation method algorithm for the inverse coordinate operation is the same as for the forward algorithm,
 * but the signs of some coordinate operation parameter values have to be reversed.
 * In other cases, different algorithms are required for the forward and inverse coordinate operations,
 * but the same coordinate operation parameter values are used.
 * If (some) entirely different parameter values are needed, a different coordinate operation shall be defined.
 */
public class CoordinateOperation extends ObjectUsage
        implements org.opengis.referencing.operation.CoordinateOperation
{
    /**
     * Coordinate reference system to which the coordinate set input into this coordinate operation is referenced.
     */
    @JsonProperty(index = 20)
    @JsonPropertyDescription("coordinate reference system to which the coordinate set input into this coordinate operation is referenced")
    public CRS sourceCRS;

    /**
     * Coordinate reference system to which the coordinate set output from this coordinate operation is referenced.
     */
    @JsonProperty(index = 21)
    @JsonPropertyDescription("coordinate reference system to which the coordinate set output from this coordinate operation is referenced")
    public CRS targetCRS;

    /**
     * Coordinate reference system to which gridded data files are referenced which this coordinate operation uses
     * to transform coordinates between two other coordinate reference systems.
     * {@code InterpolationCRS} is only used when it is different from both sourceCRS and targetCRS.
     */
    @JsonProperty(index = 22)
    @JsonPropertyDescription("coordinate reference system to which gridded data files are referenced which this coordinate operation uses to transform coordinates between two other coordinate reference systems")
    public CRS interpolationCRS;

    /**
     * Coordinate epoch of the coordinate set input into this coordinate operation.
     */
    @JsonProperty(index = 23)
    @JsonPropertyDescription("coordinate epoch of the coordinate set input into this coordinate operation")
    public DataEpoch sourceCoordinateEpoch;

    /**
     * Coordinate epoch of the coordinate set output from this coordinate operation.
     */
    @JsonProperty(index = 24)
    @JsonPropertyDescription("coordinate epoch of the coordinate set output from this coordinate operation")
    public DataEpoch targetCoordinateEpoch;

    /**
     * version of the coordinate transformation (i.e., instantiation due to the stochastic nature of the parameters).
     * Mandatory when describing a coordinate transformation or point motion operation,
     * and should not be supplied for a coordinate conversion.
     */
    @JsonProperty(index = 25)
    @JsonPropertyDescription("version of the coordinate transformation (i.e. instantiation due to the stochastic nature of the parameters)")
    public String operationVersion;

    /**
     * Estimate(s) of the impact of this coordinate operation on point accuracy.
     * Gives position error estimates for target coordinates of this coordinate operation, assuming no errors in source coordinates.
     */
    @JsonProperty(index = 26)
    @JsonPropertyDescription("estimate(s) of the impact of this coordinate operation on point accuracy")
    public PositionalAccuracy[] coordinateOperationAccuracy;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CoordinateOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl     implementation of a GeoAPI object to serialize.
     * @param withCRS  whether to initialize also {@link #sourceCRS} and {@link #targetCRS}.
     */
    @SuppressWarnings("unchecked")
    protected CoordinateOperation(final org.opengis.referencing.operation.CoordinateOperation impl, boolean withCRS) {
        super(impl);
        entityType = "CoordinateOperation";
        operationVersion = impl.getOperationVersion();
        coordinateOperationAccuracy = array(impl.getCoordinateOperationAccuracy(), PositionalAccuracy[]::new, PositionalAccuracy::new);
        if (withCRS) {
            sourceCRS = CRS.create(impl.getSourceCRS());
            targetCRS = CRS.create(impl.getTargetCRS());
            interpolationCRS = CRS.create(getByReflection(org.opengis.referencing.crs.CoordinateReferenceSystem.class, impl, "getInterpolationCRS"));
            sourceCoordinateEpoch = DataEpoch.create(getOptionalByReflection(Temporal.class, impl, "getSourceEpoch"));
            targetCoordinateEpoch = DataEpoch.create(getOptionalByReflection(Temporal.class, impl, "getTargetEpoch"));
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static CoordinateOperation create(org.opengis.referencing.operation.CoordinateOperation impl) {
        return switch (impl) {
            case null -> null;
            case CoordinateOperation subtype -> subtype;
            case org.opengis.referencing.operation.ConcatenatedOperation subtype -> new ConcatenatedOperation(subtype);
            case org.opengis.referencing.operation.PassThroughOperation subtype -> new PassThroughOperation(subtype);
            case org.opengis.referencing.operation.SingleOperation subtype -> SingleOperation.create(subtype);
            default -> new CoordinateOperation(impl, true);
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.referencing.crs.CoordinateReferenceSystem getSourceCRS() {
        return sourceCRS;
    }

    @Override
    public org.opengis.referencing.crs.CoordinateReferenceSystem getTargetCRS() {
        return targetCRS;
    }

    @Override
    public String getOperationVersion() {
        return operationVersion;
    }

    @Override
    public Collection<org.opengis.metadata.quality.PositionalAccuracy> getCoordinateOperationAccuracy() {
        return list(coordinateOperationAccuracy);
    }

    @Override
    public org.opengis.referencing.operation.MathTransform getMathTransform() {
        throw new UnsupportedOperationException();
    }
}
