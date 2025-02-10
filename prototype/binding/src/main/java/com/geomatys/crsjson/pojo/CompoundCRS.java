
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Coordinate reference system describing the position of points
 * through two or more independent single coordinate reference systems.
 * Two coordinate reference systems are independent of each other if coordinate values
 * in one cannot be converted or transformed into coordinate values in the other.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompoundCRS
    extends CRS
{
    /**
     * Coordinate reference system that is a component of this compound coordinate reference system.
     */
    @JsonProperty(value="componentReferenceSystem", index=200, required=true)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("coordinate reference system that is a component of this compound coordinate reference system")
    public Set<Object> componentReferenceSystem;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CompoundCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public CompoundCRS(final org.opengis.referencing.crs.CompoundCRS impl) {
        super(impl);
        entityType = "CompoundCRS";
        componentReferenceSystem = many(impl.getComponents(), CRS::create);
    }
}
