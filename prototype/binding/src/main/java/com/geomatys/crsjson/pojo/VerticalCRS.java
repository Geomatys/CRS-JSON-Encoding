
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Coordinate reference system having a vertical reference frame and a one-dimensional vertical coordinate system
 * used for recording gravity-related heights or depths.
 * Vertical <abbr>CRS</abbr>s make use of the direction of gravity to define the concept of height or depth,
 * but the relationship with gravity may not be straightforward.
 *
 * <p><b>Note 1:</b> If the vertical reference frame is dynamic then the vertical CRS is dynamic, else it is static.</p>
 *
 * <p><b>Note 2:</b> Ellipsoidal heights cannot be captured in a vertical coordinate reference system.
 * They exist only as an inseparable part of a 3D coordinate tuple defined in a geographic 3D coordinate reference system.</p>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerticalCRS
    extends SingleCRS
{
    /**
     * Geoid model or height correction model that is associated with this vertical coordinate reference system.
     */
    @JsonProperty(value="geoidModel", index=300)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("geoid model or height correction model that is associated with this vertical coordinate reference system")
    public Set<Object> geoidModel;

    /**
     * Velocity model or deformation grid that is applied to this vertical coordinate reference system.
     */
    @JsonProperty(value="velocityModel", index=310)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("velocity model or deformation grid that is applied to this vertical coordinate reference system")
    public Set<Object> velocityModel;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public VerticalCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public VerticalCRS(final org.opengis.referencing.crs.VerticalCRS impl) {
        super(impl);
        entityType = "VerticalCRS";
        // TODO: missing geoidModel, velocityModel.
    }
}
