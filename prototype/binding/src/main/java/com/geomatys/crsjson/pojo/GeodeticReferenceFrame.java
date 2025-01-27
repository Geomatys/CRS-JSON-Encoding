
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Definition of the position, scale and orientation of a geocentric Cartesian 3D coordinate system relative to the Earth.
 *
 * <p><b>Note 1:</b> It may also identify a defined ellipsoid (or sphere) that approximates
 * the shape of the Earth and which is centred on and aligned to this geocentric coordinate system.
 * Older geodetic datums define the location and orientation of a defined ellipsoid (or sphere)
 * that approximates the shape of the earth.</p>
 *
 * <p><b>Note 2:</b> In 19111:2007 this class was called GeodeticDatum.</p>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class GeodeticReferenceFrame
    extends Datum
{
    /**
     * Prime meridian which is a component of this geodetic reference frame.
     */
    @JsonProperty(value="primeMeridian", index=200, required=true)
    @JsonPropertyDescription("prime meridian which is a component of this geodetic reference frame")
    public Object primeMeridian;

    /**
     * Ellipsoid which is a component of this geodetic reference frame.
     */
    @JsonProperty(value="ellipsoid", index=210)
    @JsonPropertyDescription("ellipsoid which is a component of this geodetic reference frame")
    public Object ellipsoid;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeodeticReferenceFrame() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public GeodeticReferenceFrame(org.opengis.referencing.datum.GeodeticDatum impl) {
        super(impl);
        entityType    = "GeodeticReferenceFrame";
        primeMeridian = new PrimeMeridian(impl.getPrimeMeridian());
        ellipsoid     = new Ellipsoid(impl.getEllipsoid());
    }
}
