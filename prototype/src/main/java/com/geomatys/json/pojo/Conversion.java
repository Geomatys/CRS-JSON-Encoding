
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * mathematical operation on coordinates in which the parameter values are defined rather than empirically derived; application of the coordinate conversion introduces no error into output coordinates
 * Note: The best-known example of a coordinate conversion is a map projection. For coordinate conversions the output coordinates are referenced to the same datum as are the input coordinates.
 * Coordinate conversions forming a component of a derived CRS have a source CRS and a target CRS that are NOT specified through the source and target associations, but through associations from DerivedCRS to SingleCRS.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "operationVersion"
})
@Generated("jsonschema2pojo")
public class Conversion
    extends SingleOperation
{

    /**
     * (not applicable)
     * Note: This attribute is not used in a coordinate conversion.
     *
     */
    @JsonProperty("operationVersion")
    @JsonPropertyDescription("(not applicable) \r\nNote: This attribute is not used in a coordinate conversion.")
    public String operationVersion;

}
