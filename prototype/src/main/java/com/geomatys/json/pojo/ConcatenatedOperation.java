
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
 * ordered sequence of two or more single coordinate operations
 * Note: The sequence of coordinate operations is constrained by the requirement that the source coordinate reference system of step (n + 1) shall be the same as the target coordinate reference system of step (n). The source coordinate reference system of the first step and the target coordinate reference system of the last step are the source and target coordinate reference system associated with the concatenated coordinate operation. For a concatenated coordinate operation sequence of n coordinate operations:
 *     source CRS (concatenated coordinate operation) = source CRS (coordinate operation step 1)
 *     target CRS (coordinate operation step i) = source CRS (coordinate operation step i + 1); i = 1 ...(n - 1)
 *     target CRS (concatenated coordinate operation) = target CRS (coordinate operation step n)
 * Instead of a forward coordinate operation, an inverse coordinate operation may be used for one or more of the coordinate operation steps mentioned above, if the inverse coordinate operation is uniquely defined by the forward coordinate operation method.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coordOperation"
})
@Generated("jsonschema2pojo")
public class ConcatenatedOperation
    extends CoordinateOperation
{

    /**
     * coordinate operation that is a step in the sequence forming this concatenated coordinate operation
     * (Required)
     *
     */
    @JsonProperty("coordOperation")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("coordinate operation that is a step in the sequence forming this concatenated coordinate operation")
    public Set<Object> coordOperation;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ConcatenatedOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ConcatenatedOperation(final org.opengis.referencing.operation.ConcatenatedOperation impl) {
        super(impl, true);
        entityType = "ConcatenatedOperation";
        coordOperation = many(impl.getOperations(), CoordinateOperation::create);
    }
}
