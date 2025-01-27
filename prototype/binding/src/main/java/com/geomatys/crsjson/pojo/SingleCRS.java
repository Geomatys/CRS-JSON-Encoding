
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Coordinate reference system consisting of one coordinate system and either one datum or one datum ensemble.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class SingleCRS
    extends Crs
{
    /**
     * Coordinate system that is a component of this single coordinate reference system.
     */
    @JsonProperty(value="coordinateSystem", index=200, required=true)
    @JsonPropertyDescription("coordinate system that is a component of this single coordinate reference system")
    public Object coordinateSystem;

    /**
     * Datum that is a component of this single coordinate reference system.
     */
    @JsonProperty(value="datum", index=210)
    @JsonPropertyDescription("datum that is a component of this single coordinate reference system")
    public Object datum;

    /**
     * Datum ensemble that is a component of this single coordinate reference system.
     */
    @JsonProperty(value="datumEnsemble", index=220)
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
