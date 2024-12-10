
package com.geomatys.json.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * mathematical operation (a) on coordinates that transforms or converts them from one coordinate reference system to another coordinate reference system, or (b) that decribes the change of coordinate values within one coordinate reference system due to the motion of the point between one coordinate epoch and another coordinate epoch
 * Note: Many but not all coordinate operations (from CRS A to CRS B) also uniquely define the inverse coordinate operation (from CRS B to CRS A). In some cases, the coordinate operation method algorithm for the inverse coordinate operation is the same as for the forward algorithm, but the signs of some coordinate operation parameter values have to be reversed. In other cases, different algorithms are required for the forward and inverse coordinate operations, but the same coordinate operation parameter values are used. If (some) entirely different parameter values are needed, a different coordinate operation shall be defined.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "operationVersion",
    "coordinateOperationAccuracy",
    "targetCoordinateEpoch",
    "sourceCoordinateEpoch",
    "sourceCRS",
    "interpolationCRS",
    "targetCRS"
})
@Generated("jsonschema2pojo")
public class CoordinateOperation
    extends ObjectUsage
{

    /**
     * version of the coordinate transformation (i.e. instantiation due to the stochastic nature of the parameters)
     * Condition: Mandatory when describing a coordinate transformation or point motion operation, and should not be supplied for a coordinate conversion.
     *
     */
    @JsonProperty("operationVersion")
    @JsonPropertyDescription("version of the coordinate transformation (i.e. instantiation due to the stochastic nature of the parameters) \r\nCondition: Mandatory when describing a coordinate transformation or point motion operation, and should not be supplied for a coordinate conversion.")
    public String operationVersion;
    /**
     * estimate(s) of the impact of this coordinate operation on point accuracy
     * Note: Gives position error estimates for target coordinates of this coordinate operation, assuming no errors in source coordinates.
     *
     */
    @JsonProperty("coordinateOperationAccuracy")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("estimate(s) of the impact of this coordinate operation on point accuracy\r\nNote: Gives position error estimates for target coordinates of this coordinate operation, assuming no errors in source coordinates.")
    public Set<Object> coordinateOperationAccuracy;
    /**
     * coordinate epoch of the coordinate set output from this coordinate operation
     *
     */
    @JsonProperty("targetCoordinateEpoch")
    @JsonPropertyDescription("coordinate epoch of the coordinate set output from this coordinate operation")
    public Object targetCoordinateEpoch;
    /**
     * coordinate epoch of the coordinate set input into this coordinate operation
     *
     */
    @JsonProperty("sourceCoordinateEpoch")
    @JsonPropertyDescription("coordinate epoch of the coordinate set input into this coordinate operation")
    public Object sourceCoordinateEpoch;
    /**
     * coordinate reference system to which the coordinate set input into this coordinate operation is referenced
     *
     */
    @JsonProperty("sourceCRS")
    @JsonPropertyDescription("coordinate reference system to which the coordinate set input into this coordinate operation is referenced")
    public Object sourceCRS;
    /**
     * "coordinate reference system to which gridded data files are referenced which this coordinate operation uses to  transform coordinates between two other coordinate reference systems
     * Note: InterpolationCRS is only used when it is different from both sourceCRS and targetCRS."
     *
     */
    @JsonProperty("interpolationCRS")
    @JsonPropertyDescription("\"coordinate reference system to which gridded data files are referenced which this coordinate operation uses to  transform coordinates between two other coordinate reference systems\r\nNote: InterpolationCRS is only used when it is different from both sourceCRS and targetCRS.\"")
    public Object interpolationCRS;
    /**
     * coordinate reference system to which the coordinate set output from this coordinate operation is referenced
     *
     */
    @JsonProperty("targetCRS")
    @JsonPropertyDescription("coordinate reference system to which the coordinate set output from this coordinate operation is referenced")
    public Object targetCRS;

}
