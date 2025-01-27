
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Metadata required to reference coordinates.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class CoordinateMetadata {
    /**
     * The object type.
     */
    @JsonProperty(value="entityType", index=0, required=true)
    public String entityType;

    /**
     * Identifier of the coordinate reference system to which a coordinate set is referenced.
     */
    @JsonProperty(value="crsID", index=10)
    @JsonPropertyDescription("identifier of the coordinate reference system to which a coordinate set is referenced")
    public Object crsID;

    /**
     * Full definition of the coordinate reference system to which a coordinate set is referenced.
     */
    @JsonProperty(value="crs", index=20)
    @JsonPropertyDescription("full definition of the coordinate reference system to which a coordinate set is referenced")
    public Object crs;

    /**
     * Epoch at which a coordinate set referenced to a dynamic CRS is valid.
     * Required if the <abbr>CRS</abbr> is dynamic, otherwise should no be given.
     */
    @JsonProperty(value="coordinateEpoch", index=30)
    @JsonPropertyDescription("epoch at which a coordinate set referenced to a dynamic CRS is valid")
    public Object coordinateEpoch;

    // ════════════════════════════ Codes below this point were added/removed manually ════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public CoordinateMetadata() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public CoordinateMetadata(final Object impl) {
        entityType = "CoordinateMetadata";
    }
}
