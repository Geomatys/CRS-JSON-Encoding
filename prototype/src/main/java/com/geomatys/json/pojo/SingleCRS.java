
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * coordinate reference system consisting of one coordinate system and either one datum or one datum ensemble
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datum",
    "coordinateSystem",
    "datumEnsemble"
})
@Generated("jsonschema2pojo")
public class SingleCRS
    extends Crs
{

    /**
     * datum that is a component of this single coordinate reference system
     *
     */
    @JsonProperty("datum")
    @JsonPropertyDescription("datum that is a component of this single coordinate reference system")
    public Object datum;
    /**
     * coordinate system that is a component of this single coordinate reference system
     * (Required)
     *
     */
    @JsonProperty("coordinateSystem")
    @JsonPropertyDescription("coordinate system that is a component of this single coordinate reference system")
    public Object coordinateSystem;
    /**
     * datum ensemble that is a component of this single coordinate reference system
     *
     */
    @JsonProperty("datumEnsemble")
    @JsonPropertyDescription("datum ensemble that is a component of this single coordinate reference system")
    public Object datumEnsemble;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected SingleCRS() {
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
    protected SingleCRS(final org.opengis.referencing.crs.SingleCRS impl) {
        super(impl);
        entityType = "SingleCRS";
        datum = Datum.create(impl.getDatum());
        coordinateSystem = CoordinateSystem.create(impl.getCoordinateSystem());
        // TODO: missing datumEnsemble.
    }
}
