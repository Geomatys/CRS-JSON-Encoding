
package com.geomatys.crsjson.pojo;

import java.util.List;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * specification of a subset of coordinate tuples that is subject to a coordinate operation
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "modifiedCoordinate",
    "coordOperation"
})
@Generated("jsonschema2pojo")
public class PassThroughOperation
    extends CoordinateOperation
{

    /**
     * ordered sequence of positive integers defining the positions in a source coordinate tuple of the coordinates affected by this pass-through operation
     *
     */
    @JsonProperty("modifiedCoordinate")
    @JsonPropertyDescription("ordered sequence of positive integers defining the positions in a source coordinate tuple of the coordinates affected by this pass-through operation")
    public List<Integer> modifiedCoordinate;
    /**
     * subset of a coordinate tuple that the coordinate operation will operate upon
     * (Required)
     *
     */
    @JsonProperty("coordOperation")
    @JsonPropertyDescription("subset of a coordinate tuple that the coordinate operation will operate upon")
    public Object coordOperation;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public PassThroughOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public PassThroughOperation(final org.opengis.referencing.operation.PassThroughOperation impl) {
        super(impl, true);
        entityType = "PassThroughOperation";
        modifiedCoordinate = Arrays.stream(impl.getModifiedCoordinates()).mapToObj(Integer::valueOf).toList();
        coordOperation = create(impl.getOperation());
    }
}
