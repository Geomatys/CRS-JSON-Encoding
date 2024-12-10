
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * metadata required to reference coordinates
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entityType",
    "crsID",
    "crs",
    "coordinateEpoch"
})
@Generated("jsonschema2pojo")
public class CoordinateMetadata {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("entityType")
    public String entityType;
    /**
     * identifier of the coordinate reference system to which a coordinate set is referenced
     *
     */
    @JsonProperty("crsID")
    @JsonPropertyDescription("identifier of the coordinate reference system to which a coordinate set is referenced")
    public Object crsID;
    /**
     * full definition of the coordinate reference system to which a coordinate set is referenced
     *
     */
    @JsonProperty("crs")
    @JsonPropertyDescription("full definition of the coordinate reference system to which a coordinate set is referenced")
    public Object crs;
    /**
     * epoch at which a coordinate set referenced to a dynamic CRS is valid
     * Note: Required if the CRS is dynamic, otherwise should no be given.
     *
     */
    @JsonProperty("coordinateEpoch")
    @JsonPropertyDescription("epoch at which a coordinate set referenced to a dynamic CRS is valid \r\nNote: Required if the CRS is dynamic, otherwise should no be given.")
    public Object coordinateEpoch;

}
