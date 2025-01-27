
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * n-dimensional coordinate system in which every axis uses integers
 * Note: The number of associations shall be equal the dimension of the coordinate system.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coordinateType"
})
@Generated("jsonschema2pojo")
public class OrdinalCS
    extends CoordinateSystem
{

    /**
     * datatype of coordinate values
     * (Required)
     *
     */
    @JsonProperty("coordinateType")
    @JsonPropertyDescription("datatype of coordinate values")
    public String coordinateType;

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public OrdinalCS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public OrdinalCS(final org.opengis.referencing.cs.CoordinateSystem impl) {
        super(impl);
        entityType = "OrdinalCS";
        // TODO: missing coordinateType.
    }
}
