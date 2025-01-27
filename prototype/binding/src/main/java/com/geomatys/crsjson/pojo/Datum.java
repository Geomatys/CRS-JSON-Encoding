
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * specification of the relationship of a coordinate system to an object, thus creating a coordinate reference system
 * Note: For geodetic and vertical coordinate reference systems, it relates a coordinate system to the Earth. With other types of coordinate reference systems, the datum may relate the coordinate system to another physical or virtual object. A datum uses a parameter or set of parameters that determine the location of the origin of the coordinate reference system. Each datum subtype can be associated with only specific types of coordinate reference systems.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "anchorDefinition",
    "anchorEpoch",
    "publicationDate",
    "conventionalRS"
})
@Generated("jsonschema2pojo")
public class Datum
    extends ObjectUsage
{

    /**
     * description, possibly including coordinates of an identified point or points, of the relationship used to anchor a coordinate system to the Earth or alternate object
     * Note: For modern geodetic reference frames the anchor may be a set of station coordinates; if the reference frame is dynamic it will also include coordinate velocities. For a traditional geodetic datum, the anchor may be a point known as the fundamental point, which is traditionally the point where the relationship between geoid and ellipsoid is defined, together with a direction from that point.
     * - For a vertical reference frame the anchor may be the zero level at one or more defined locations or a conventionally defined surface.
     * - For an engineering datum, the anchor may be an identified physical point with the orientation defined relative to the object.
     *
     */
    @JsonProperty("anchorDefinition")
    @JsonPropertyDescription("description, possibly including coordinates of an identified point or points, of the relationship used to anchor a coordinate system to the Earth or alternate object \r\nNote: For modern geodetic reference frames the anchor may be a set of station coordinates; if the reference frame is dynamic it will also include coordinate velocities. For a traditional geodetic datum, the anchor may be a point known as the fundamental point, which is traditionally the point where the relationship between geoid and ellipsoid is defined, together with a direction from that point.\r\n- For a vertical reference frame the anchor may be the zero level at one or more defined locations or a conventionally defined surface. \r\n- For an engineering datum, the anchor may be an identified physical point with the orientation defined relative to the object.")
    public String anchorDefinition;
    /**
     * measure object
     * <p>
     * definition of a measure object
     *
     */
    @JsonProperty("anchorEpoch")
    @JsonPropertyDescription("definition of a measure object")
    public Measure anchorEpoch;
    /**
     * date on which the datum definition was published
     *
     */
    @JsonProperty("publicationDate")
    @JsonPropertyDescription("date on which the datum definition was published")
    public String publicationDate;
    /**
     * name, identifier, alias and remarks for the terrestrial reference system or vertical reference system realized by this reference frame
     * Examples: "ITRS" for ITRF88 through ITRF2008 and ITRF2014, or "EVRS" for EVRF2000 and EVRF2007.
     *
     */
    @JsonProperty("conventionalRS")
    @JsonPropertyDescription("name, identifier, alias and remarks for the terrestrial reference system or vertical reference system realized by this reference frame\r\nExamples: \"ITRS\" for ITRF88 through ITRF2008 and ITRF2014, or \"EVRS\" for EVRF2000 and EVRF2007.")
    public Object conventionalRS;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

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
