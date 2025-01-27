
package com.geomatys.crsjson.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * A collection of two or more datums (or if geodetic or vertical, a collection of two or more reference frames) that are realizations of one Conventional Reference System and which for all but the highest accuracy requirements may be considered to be insignificantly different from each other.
 *
 * Note: Within the datum ensemble every frame or datum is constrained to be a realization of the same reference system.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class DatumEnsemble
    extends ObjectUsage
{
    /**
     * inaccuracy introduced through use of this collection of reference frames or datums
     * Note: It is an indication of the differences in coordinate values at all points between the various realizations that have been grouped into this datum ensemble.
     * (Required)
     *
     */
    @JsonProperty(value="ensembleAccuracy", index=100)
    @JsonPropertyDescription("inaccuracy introduced through use of this collection of reference frames or datums\r\nNote: It is an indication of the differences in coordinate values at all points between the various realizations that have been grouped into this datum ensemble.")
    public Object ensembleAccuracy;

    /**
     * datum or reference frame which is a member of this datum ensemble
     * (Required)
     *
     */
    @JsonProperty(value="datum", index=110)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("datum or reference frame which is a member of this datum ensemble")
    public Set<Object> datum;

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DatumEnsemble() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public DatumEnsemble(final org.opengis.referencing.datum.Datum impl) {
        super(impl);
        entityType = "DatumEnsemble";
    }
}
