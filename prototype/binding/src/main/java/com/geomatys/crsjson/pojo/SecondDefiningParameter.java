
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Definition of the second parameter that defines the shape of a biaxial ellipsoid,
 * or the third parameter that defines a triaxial ellipsoid.
 * A biaxial ellipsoid requires two defining parameters:
 * a semi-major axis and inverse flattening or a semi-major axis and a semi-minor axis.
 * When the reference body is a sphere rather than an ellipsoid, only a single defining parameter is required,
 * namely the radius of the sphere. in that case, the semi-major axis “degenerates” into the radius of the sphere.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class SecondDefiningParameter {
    /**
     * Inverse flattening value of the ellipsoid.
     */
    @JsonProperty(value="inverseFlattening", index=100)
    @JsonPropertyDescription("inverse flattening value of the ellipsoid")
    public Measure inverseFlattening;

    /**
     * Length of the semi-minor axis of the ellipsoid.
     */
    @JsonProperty(value="semiMinorAxis", index=110)
    @JsonPropertyDescription("length of the semi-minor axis of the ellipsoid")
    public Measure semiMinorAxis;

    /**
     * Ellipsoid is degenerate and is actually a sphere.
     * The sphere is completely defined by the semi-major axis, which is the radius of the sphere.
     * This attribute has the value {@code true} if the figure is a sphere.
     */
    @JsonProperty(value="isSphere", index=120)
    @JsonPropertyDescription("ellipsoid is degenerate and is actually a sphere")
    public Boolean isSphere;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public SecondDefiningParameter() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public SecondDefiningParameter(org.opengis.referencing.datum.Ellipsoid impl) {
        isSphere = impl.isSphere();
        if (impl.isIvfDefinitive()) {
            inverseFlattening = new Measure(impl.getInverseFlattening());
        } else {
            semiMinorAxis = new Measure(impl.getSemiMinorAxis(), impl.getAxisUnit());
        }
    }
}
