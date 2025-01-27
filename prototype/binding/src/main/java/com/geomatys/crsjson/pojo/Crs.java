
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Coordinate reference system which is usually single but may be compound.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Crs
    extends ObjectUsage
{

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected Crs() {
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
    protected Crs(final org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        super(impl);
        entityType = "CRS";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static Crs create(org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        if (impl == null) {
            return null;
        }
        return switch (impl) {
            case org.opengis.referencing.crs.GeneralDerivedCRS subtype -> DerivedCRS.createDerived(subtype);
            case org.opengis.referencing.crs.CompoundCRS       subtype -> new CompoundCRS(subtype);
            case org.opengis.referencing.crs.GeographicCRS     subtype -> new GeographicCRS(subtype);
            case org.opengis.referencing.crs.GeodeticCRS       subtype -> new GeodeticCRS(subtype);
            case org.opengis.referencing.crs.VerticalCRS       subtype -> new VerticalCRS(subtype);
            case org.opengis.referencing.crs.EngineeringCRS    subtype -> new EngineeringCRS(subtype);
            case org.opengis.referencing.crs.SingleCRS         subtype -> new SingleCRS(subtype);
            default -> new Crs(impl);
        };
    }
}
