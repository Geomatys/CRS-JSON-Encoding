
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * <var>n</var>-dimensional coordinate system in which every axis uses integers.
 * The number of associations shall be equal the dimension of the coordinate system.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdinalCS
    extends CoordinateSystem
{
    /**
     * Datatype of coordinate values.
     */
    @JsonProperty(value="coordinateType", index=200, required=true)
    @JsonPropertyDescription("datatype of coordinate values")
    public String coordinateType;

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
