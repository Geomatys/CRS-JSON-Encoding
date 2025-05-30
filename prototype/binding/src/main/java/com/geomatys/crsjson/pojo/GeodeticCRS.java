
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Coordinate reference system associated with a geodetic reference frame
 * and a three-dimensional Cartesian or spherical coordinate system.
 * If the geodetic reference frame is dynamic then the geodetic CRS is dynamic, else it is static.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeodeticCRS
    extends SingleCRS
{
    /**
     * Velocity model or deformation grid that may be applied to this geodetic coordinate reference system.
     */
    @JsonProperty(value="velocityModel", index=300)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("velocity model or deformation grid that may be applied to this geodetic coordinate reference system")
    public Set<Object> velocityModel;

    @JsonProperty(value="definingTransformation", index=310)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    public Set<Object> definingTransformation;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeodeticCRS() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public GeodeticCRS(final org.opengis.referencing.crs.GeodeticCRS impl) {
        super(impl);
        entityType = "GeodeticCRS";
        // TODO: missing velocityModel, definingTransformation.
    }
}
