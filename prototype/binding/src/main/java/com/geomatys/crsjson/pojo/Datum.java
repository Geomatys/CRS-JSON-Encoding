/*
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership. You may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.geomatys.crsjson.pojo;

import java.util.Date;
import java.time.temporal.Temporal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;


/**
 * Specification of the relationship of a coordinate system to an object, thus creating a coordinate reference system.
 * For geodetic and vertical coordinate reference systems, it relates a coordinate system to the Earth.
 * With other types of coordinate reference systems, the datum may relate the coordinate system to another physical or virtual object.
 * A datum uses a parameter or set of parameters that determine the location of the origin of the coordinate reference system.
 * Each datum subtype can be associated with only specific types of coordinate reference systems.
 */
public class Datum extends ObjectUsage
        implements org.opengis.referencing.datum.Datum
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
    @JsonProperty(index = 20)
    @JsonPropertyDescription("description, possibly including coordinates of an identified point or points, of the relationship used to anchor a coordinate system to the Earth or alternate object")
    public String anchorDefinition;

    /**
     * Epoch at which a datum (reference frame) is aligned with another datum (reference frame).
     * Not to be confused with the frame reference epoch of dynamic geodetic and dynamic vertical reference frames.
     * Nor with the epoch at which a reference frame is defined to be aligned with another reference frame.
     * This information should be included in the datum anchor definition.
     */
    @JsonProperty(index = 21)
    @JsonPropertyDescription("epoch at which a datum (reference frame) is aligned with another datum (reference frame)")
    public Measure anchorEpoch;

    /**
     * Date on which the datum definition was published.
     */
    @JsonProperty(index = 22)
    @JsonPropertyDescription("date on which the datum definition was published")
    public String publicationDate;

    /**
     * Name, identifier, alias and remarks for the terrestrial reference system or vertical reference system realized by this reference frame.
     * Examples: "ITRS" for ITRF88 through ITRF2008 and ITRF2014, or "EVRS" for EVRF2000 and EVRF2007.
     */
    @JsonProperty(index = 23)
    @JsonPropertyDescription("name, identifier, alias and remarks for the terrestrial reference system or vertical reference system realized by this reference frame")
    public IdentifiedObject conventionalRS;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public Datum() {
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
        var rs = getOptionalByReflection(org.opengis.referencing.IdentifiedObject.class, impl, "getConventionalRS");
        if (rs != null) {
            if (rs instanceof IdentifiedObject c) {
                conventionalRS = c;
            } else {
                conventionalRS = new IdentifiedObject(rs);  // Intentionally do not check for subtypes.
            }
        }
        anchorEpoch = Measure.create(getOptionalByReflection(Temporal.class, impl, "getAnchorEpoch"));
        publicationDate = text(getOptionalByReflection(Temporal.class, impl, "getPublicationDate"));
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static Datum create(org.opengis.referencing.datum.Datum impl) {
        return switch (impl) {
            case null -> null;
            case Datum subtype -> subtype;
            case org.opengis.referencing.datum.GeodeticDatum    subtype -> new GeodeticReferenceFrame(subtype);
            case org.opengis.referencing.datum.VerticalDatum    subtype -> new VerticalReferenceFrame(subtype);
            case org.opengis.referencing.datum.TemporalDatum    subtype -> new TemporalDatum         (subtype);
            case org.opengis.referencing.datum.EngineeringDatum subtype -> new EngineeringDatum      (subtype);
            default -> {
                if (isInstanceByReflection("ParametricDatum", impl)) {
                    yield new ParametricDatum(impl);
                }
                yield new Datum(impl);
            }
        };
    }

    // ┌────────────────────────────────────────┐
    // │    Implementation of GeoAPI methods    │
    // └────────────────────────────────────────┘

    @Override
    public org.opengis.util.InternationalString getAnchorPoint() {
        return i18n(anchorDefinition);
    }

    @Override
    public Date getRealizationEpoch() {
        return null;    // TODO
    }
}
