
package com.geomatys.crsjson.pojo;

import java.util.Set;
import java.util.LinkedHashSet;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * non-repeating sequence of coordinate system axes that spans a given coordinate space
 * Note: A coordinate system is derived from a set of mathematical rules for specifying how coordinates in a given space are to be assigned to points. The coordinate values in a coordinate tuple shall be recorded in the order in which the coordinate system axes associations are recorded.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "axis"
})
@Generated("jsonschema2pojo")
public class CoordinateSystem
    extends IdentifiedObject
{

    /**
     * coordinate system axis that is a component of this coordinate system
     * (Required)
     *
     */
    @JsonProperty("axis")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("coordinate system axis that is a component of this coordinate system")
    public Set<Object> axis;


    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected CoordinateSystem() {
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
    protected CoordinateSystem(final org.opengis.referencing.cs.CoordinateSystem impl) {
        super(impl);
        entityType = "CoordinateSystem";
        int dimension = impl.getDimension();
        axis = LinkedHashSet.newLinkedHashSet(dimension);
        for (int i=0; i<dimension; i++) {
            axis.add(new CoordinateSystemAxis(impl.getAxis(i)));
        }
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static CoordinateSystem create(org.opengis.referencing.cs.CoordinateSystem impl) {
        if (impl == null) {
            return null;
        }
        return switch (impl) {
            case org.opengis.referencing.cs.CartesianCS   subtype -> new CartesianCS  (subtype);
            case org.opengis.referencing.cs.SphericalCS   subtype -> new SphericalCS  (subtype);
            case org.opengis.referencing.cs.EllipsoidalCS subtype -> new EllipsoidalCS(subtype);
            case org.opengis.referencing.cs.CylindricalCS subtype -> new CylindricalCS(subtype);
            case org.opengis.referencing.cs.PolarCS       subtype -> new PolarCS      (subtype);
            case org.opengis.referencing.cs.AffineCS      subtype -> new AffineCS     (subtype);
            case org.opengis.referencing.cs.VerticalCS    subtype -> new VerticalCS   (subtype);
            case org.opengis.referencing.cs.TimeCS        subtype -> new TemporalCS   (subtype);
            default -> new CoordinateSystem(impl);
        };
    }
}
