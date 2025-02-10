
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Single coordinate reference system that is defined through the application of a specified coordinate conversion to
 * the definition of a previously established single coordinate reference system referred to as the base <abbr>CRS</abbr>.
 * A derived coordinate reference system inherits its datum (or datum ensemble) from its base <abbr>CRS</abbr>.
 * The coordinate conversion between the base and derived coordinate reference system is implemented using the
 * parameters and formula(s) specified in the definition of the coordinate conversion.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DerivedCRS
    extends SingleCRS
{
    /**
     * Coordinate reference system that is the base <abbr>CRS</abbr> for this derived coordinate reference system.
     */
    @JsonProperty(value="baseCRS", index=300, required=true)
    @JsonPropertyDescription("coordinate reference system that is the base CRS for this derived coordinate reference system")
    public Object baseCRS;

    /**
     * Conversion that is a component of this derived coordinate reference system.
     */
    @JsonProperty(value="derivingConversion", index=310, required=true)
    @JsonPropertyDescription("conversion that is a component of this derived coordinate reference system")
    public Object derivingConversion;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected DerivedCRS() {
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
    protected DerivedCRS(final org.opengis.referencing.crs.GeneralDerivedCRS impl) {
        super(impl);
        entityType = "DerivedCRS";
        baseCRS = Crs.create(impl.getBaseCRS());
        derivingConversion = new Conversion(impl.getConversionFromBase(), false);
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static DerivedCRS createDerived(final org.opengis.referencing.crs.GeneralDerivedCRS impl) {
        return switch (impl) {
            case null -> null;
            case org.opengis.referencing.crs.DerivedCRS   subtype -> new DerivedProjectedCRS(subtype);
            case org.opengis.referencing.crs.ProjectedCRS subtype -> new ProjectedCRS(subtype);
            default -> new DerivedCRS(impl);
        };
    }
}
