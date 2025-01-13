
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * geometric reference surface embedded in 3D Euclidean space formed by an ellipse that is rotated about a main axis
 * Note: For the Earth the ellipsoid is bi-axial with rotation about the polar axis. This results in an oblate ellipsoid with the midpoint of the foci located at the nominal centre of the Earth.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "semiMajorAxis",
    "secondDefiningParameter",
    "semiMedianAxis"
})
@Generated("jsonschema2pojo")
public class Ellipsoid
    extends IdentifiedObject
{

    /**
     * measure object
     * <p>
     * definition of a measure object
     * (Required)
     *
     */
    @JsonProperty("semiMajorAxis")
    @JsonPropertyDescription("definition of a measure object")
    public Measure semiMajorAxis;
    /**
     * definition of the second parameter that defines the shape of a biaxial ellipsoid, or the third parameter that defines a triaxial ellipsoid
     * Note: A biaxial ellipsoid requires two defining parameters: a semi-major axis and inverse flattening or a semi-major axis and a semi-minor axis. When the reference body is a sphere rather than an ellipsoid, only a single defining parameter is required, namely the radius of the sphere; in that case, the semi-major axis “degenerates” into the radius of the sphere.
     * (Required)
     *
     */
    @JsonProperty("secondDefiningParameter")
    @JsonPropertyDescription("definition of the second parameter that defines the shape of a biaxial ellipsoid, or the third parameter that defines a triaxial ellipsoid\r\nNote: A biaxial ellipsoid requires two defining parameters: a semi-major axis and inverse flattening or a semi-major axis and a semi-minor axis. When the reference body is a sphere rather than an ellipsoid, only a single defining parameter is required, namely the radius of the sphere; in that case, the semi-major axis \u201cdegenerates\u201d into the radius of the sphere.")
    public SecondDefiningParameter secondDefiningParameter;
    /**
     * measure object
     * <p>
     * definition of a measure object
     *
     */
    @JsonProperty("semiMedianAxis")
    @JsonPropertyDescription("definition of a measure object")
    public Measure semiMedianAxis;


    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Ellipsoid() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public Ellipsoid(org.opengis.referencing.datum.Ellipsoid impl) {
        super(impl);
        entityType = "Ellipsoid";
        semiMajorAxis = new Measure(impl.getSemiMajorAxis(), impl.getAxisUnit());
        secondDefiningParameter = new SecondDefiningParameter(impl);
        // TODO: missing semiMedianAxis.
    }
}
