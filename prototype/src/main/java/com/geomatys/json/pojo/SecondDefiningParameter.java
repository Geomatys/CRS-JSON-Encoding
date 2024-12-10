
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * definition of the second parameter that defines the shape of a biaxial ellipsoid, or the third parameter that defines a triaxial ellipsoid
 * Note: A biaxial ellipsoid requires two defining parameters: a semi-major axis and inverse flattening or a semi-major axis and a semi-minor axis. When the reference body is a sphere rather than an ellipsoid, only a single defining parameter is required, namely the radius of the sphere; in that case, the semi-major axis “degenerates” into the radius of the sphere.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "inverseFlattening",
    "semiMinorAxis",
    "isSphere"
})
@Generated("jsonschema2pojo")
public class SecondDefiningParameter {

    /**
     * measure object
     * <p>
     * definition of a measure object
     *
     */
    @JsonProperty("inverseFlattening")
    @JsonPropertyDescription("definition of a measure object")
    public Measure inverseFlattening;
    /**
     * measure object
     * <p>
     * definition of a measure object
     *
     */
    @JsonProperty("semiMinorAxis")
    @JsonPropertyDescription("definition of a measure object")
    public Measure semiMinorAxis;
    /**
     * ellipsoid is degenerate and is actually a sphere
     * Note: The sphere is completely defined by the semi-major axis, which is the radius of the sphere. This attribute has the value “true” if the figure is a sphere.
     *
     */
    @JsonProperty("isSphere")
    @JsonPropertyDescription("ellipsoid is degenerate and is actually a sphere\r\nNote: The sphere is completely defined by the semi-major axis, which is the radius of the sphere. This attribute has the value \u201ctrue\u201d if the figure is a sphere.")
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
