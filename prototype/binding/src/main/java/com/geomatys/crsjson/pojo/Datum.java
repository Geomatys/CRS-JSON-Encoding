
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Specification of the relationship of a coordinate system to an object, thus creating a coordinate reference system.
 * For geodetic and vertical coordinate reference systems, it relates a coordinate system to the Earth.
 * With other types of coordinate reference systems, the datum may relate the coordinate system to another physical or virtual object.
 * A datum uses a parameter or set of parameters that determine the location of the origin of the coordinate reference system.
 * Each datum subtype can be associated with only specific types of coordinate reference systems.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Datum
    extends ObjectUsage
{
    /**
     * Description, possibly including coordinates of an identified point or points,
     * of the relationship used to anchor a coordinate system to the Earth or alternate object.
     * For modern geodetic reference frames the anchor may be a set of station coordinates.
     * If the reference frame is dynamic it will also include coordinate velocities.
     * For a traditional geodetic datum, the anchor may be a point known as the fundamental point,
     * which is traditionally the point where the relationship between geoid and ellipsoid is defined,
     * together with a direction from that point.
     *
     * <ul>
     *   <li>For a vertical reference frame the anchor may be the zero level at one or more defined locations or a conventionally defined surface.</li>
     *   <li>For an engineering datum, the anchor may be an identified physical point with the orientation defined relative to the object.</li>
     * </ul>
     */
    @JsonProperty(value="anchorDefinition", index=100)
    @JsonPropertyDescription("description, possibly including coordinates of an identified point or points, of the relationship used to anchor a coordinate system to the Earth or alternate object")
    public String anchorDefinition;

    /**
     * Epoch at which a datum (reference frame) is aligned with another datum (reference frame).
     * Not to be confused with the frame reference epoch of dynamic geodetic and dynamic vertical reference frames.
     * Nor with the epoch at which a reference frame is defined to be aligned with another reference frame.
     * This information should be included in the datum anchor definition.
     */
    @JsonProperty(value="anchorEpoch", index=110)
    @JsonPropertyDescription("epoch at which a datum (reference frame) is aligned with another datum (reference frame)")
    public Measure anchorEpoch;

    /**
     * Date on which the datum definition was published.
     */
    @JsonProperty(value="publicationDate", index=120)
    @JsonPropertyDescription("date on which the datum definition was published")
    public String publicationDate;

    /**
     * Name, identifier, alias and remarks for the terrestrial reference system or vertical reference system realized by this reference frame.
     * Examples: "ITRS" for ITRF88 through ITRF2008 and ITRF2014, or "EVRS" for EVRF2000 and EVRF2007.
     */
    @JsonProperty(value="conventionalRS", index=130)
    @JsonPropertyDescription("name, identifier, alias and remarks for the terrestrial reference system or vertical reference system realized by this reference frame")
    public Object conventionalRS;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected Datum() {
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
    protected Datum(org.opengis.referencing.datum.Datum impl) {
        super(impl);
        entityType = "Datum";
        anchorDefinition = text(impl.getAnchorPoint());
        // TODO: missing anchorEpoch, publicationDate and conventionalRS.
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static Datum create(org.opengis.referencing.datum.Datum impl) {
        if (impl == null) {
            return null;
        }
        return switch (impl) {
            case org.opengis.referencing.datum.GeodeticDatum    subtype -> new GeodeticReferenceFrame(subtype);
            case org.opengis.referencing.datum.VerticalDatum    subtype -> new VerticalReferenceFrame(subtype);
            case org.opengis.referencing.datum.TemporalDatum    subtype -> new TemporalDatum         (subtype);
            case org.opengis.referencing.datum.EngineeringDatum subtype -> new EngineeringDatum      (subtype);
            default -> new Datum(impl);
        };
    }
}
