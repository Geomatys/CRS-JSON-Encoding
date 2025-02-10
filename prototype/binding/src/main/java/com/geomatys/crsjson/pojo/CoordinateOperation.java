
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


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
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoordinateOperation
    extends ObjectUsage
{
    /**
     * Coordinate reference system to which the coordinate set input into this coordinate operation is referenced.
     */
    @JsonProperty(value="sourceCRS", index=100)
    @JsonPropertyDescription("coordinate reference system to which the coordinate set input into this coordinate operation is referenced")
    public Object sourceCRS;

    /**
     * Coordinate reference system to which the coordinate set output from this coordinate operation is referenced.
     */
    @JsonProperty(value="targetCRS", index=110)
    @JsonPropertyDescription("coordinate reference system to which the coordinate set output from this coordinate operation is referenced")
    public Object targetCRS;

    /**
     * Coordinate reference system to which gridded data files are referenced which this coordinate operation uses
     * to transform coordinates between two other coordinate reference systems.
     * {@code InterpolationCRS} is only used when it is different from both sourceCRS and targetCRS.
     */
    @JsonProperty(value="interpolationCRS", index=120)
    @JsonPropertyDescription("coordinate reference system to which gridded data files are referenced which this coordinate operation uses to transform coordinates between two other coordinate reference systems")
    public Object interpolationCRS;

    /**
     * Coordinate epoch of the coordinate set input into this coordinate operation.
     */
    @JsonProperty(value="sourceCoordinateEpoch", index=130)
    @JsonPropertyDescription("coordinate epoch of the coordinate set input into this coordinate operation")
    public Object sourceCoordinateEpoch;

    /**
     * Coordinate epoch of the coordinate set output from this coordinate operation.
     */
    @JsonProperty(value="targetCoordinateEpoch", index=140)
    @JsonPropertyDescription("coordinate epoch of the coordinate set output from this coordinate operation")
    public Object targetCoordinateEpoch;

    /**
     * version of the coordinate transformation (i.e., instantiation due to the stochastic nature of the parameters).
     * Mandatory when describing a coordinate transformation or point motion operation,
     * and should not be supplied for a coordinate conversion.
     */
    @JsonProperty(value="operationVersion", index=150)
    @JsonPropertyDescription("version of the coordinate transformation (i.e. instantiation due to the stochastic nature of the parameters)")
    public String operationVersion;

    /**
     * Estimate(s) of the impact of this coordinate operation on point accuracy.
     * Gives position error estimates for target coordinates of this coordinate operation, assuming no errors in source coordinates.
     */
    @JsonProperty(value="coordinateOperationAccuracy", index=160)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("estimate(s) of the impact of this coordinate operation on point accuracy")
    public Set<PositionalAccuracy> coordinateOperationAccuracy;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected CoordinateOperation() {
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
    protected CoordinateOperation(final org.opengis.referencing.operation.CoordinateOperation impl, boolean withCRS) {
        super(impl);
        entityType = "CoordinateOperation";
        operationVersion = impl.getOperationVersion();
        coordinateOperationAccuracy = many(impl.getCoordinateOperationAccuracy(), PositionalAccuracy::new);
        if (coordinateOperationAccuracy != null && coordinateOperationAccuracy.removeIf(PositionalAccuracy::isEmpty)) {
            if (coordinateOperationAccuracy.isEmpty()) {
                coordinateOperationAccuracy = null;
            }
        }
        if (withCRS) {
            sourceCRS = CRS.create(impl.getSourceCRS());
            targetCRS = CRS.create(impl.getTargetCRS());
        }
        // TODO: missing sourceCoordinateEpoch, targetCoordinateEpoch, interpolationCRS.
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
            case org.opengis.referencing.operation.ConcatenatedOperation subtype -> new ConcatenatedOperation(subtype);
            case org.opengis.referencing.operation.PassThroughOperation  subtype -> new PassThroughOperation (subtype);
            case org.opengis.referencing.operation.Transformation        subtype -> new Transformation       (subtype);
            case org.opengis.referencing.operation.Conversion            subtype -> new Conversion           (subtype, true);
            case org.opengis.referencing.operation.SingleOperation       subtype -> new SingleOperation      (subtype, true);
            default -> new CoordinateOperation(impl, true);
        };
    }
}
