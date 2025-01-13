
package com.geomatys.crsjson.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * coordinate reference system describing the position of points through two or more independent single coordinate reference systems
 * Note: two coordinate reference systems are independent of each other if coordinate values in one cannot be converted or transformed into coordinate values in the other.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "componentReferenceSystem"
})
@Generated("jsonschema2pojo")
public class CompoundCRS
    extends Crs
{

    /**
     * coordinate reference system that is a component of this compound coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("componentReferenceSystem")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("coordinate reference system that is a component of this compound coordinate reference system")
    public Set<Object> componentReferenceSystem;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

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
        componentReferenceSystem = many(impl.getComponents(), Crs::create);
    }
}
