
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Ordered sequence of two or more single coordinate operations.
 * The sequence of coordinate operations is constrained by the requirement that the source coordinate reference system
 * of step (<var>n</var> + 1) shall be the same as the target coordinate reference system of step (<var>n</var>).
 * The source coordinate reference system of the first step and the target coordinate reference system of the last step
 * are the source and target coordinate reference system associated with the concatenated coordinate operation.
 * For a concatenated coordinate operation sequence of <var>n</var> coordinate operations:
 *
 * <ol>
 *   <li>source <abbr>CRS</abbr> (concatenated coordinate operation) =
 *       source <abbr>CRS</abbr> (coordinate operation step 1)</li>
 *   <li>target <abbr>CRS</abbr> (coordinate operation step <var>i</var>) =
 *       source <abbr>CRS</abbr> (coordinate operation step <var>i</var> + 1); <var>i</var> = 1 ...(<var>n</var> - 1)</li>
 *   <li>target <abbr>CRS</abbr> (concatenated coordinate operation) =
 *       target <abbr>CRS</abbr> (coordinate operation step <var>n</var>)</li>
 * </ol>
 *
 * Instead of a forward coordinate operation, an inverse coordinate operation
 * may be used for one or more of the coordinate operation steps mentioned above,
 * if the inverse coordinate operation is uniquely defined by the forward coordinate operation method.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConcatenatedOperation
    extends CoordinateOperation
{
    /**
     * Coordinate operation that is a step in the sequence forming this concatenated coordinate operation.
     */
    @JsonProperty(value="coordOperation", index=200, required=true)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("coordinate operation that is a step in the sequence forming this concatenated coordinate operation")
    public Set<Object> coordOperation;

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
