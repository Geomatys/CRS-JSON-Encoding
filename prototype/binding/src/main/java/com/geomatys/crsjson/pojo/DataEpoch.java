
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Time attribute of a coordinate set that is referenced to a dynamic <abbr>CRS</abbr>.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataEpoch extends Entity {
    /**
     * Date at which coordinates are referenced to a dynamic coordinate reference system,
     * expressed as a decimal year in the Gregorian calendar.
     * Example: 2017-03-25 in the Gregorian calendar is epoch 2017.23.
     */
    @JsonProperty(value="coordinateEpoch", index=10)
    @JsonPropertyDescription("date at which coordinates are referenced to a dynamic coordinate reference system, expressed as a decimal year in the Gregorian calendar")
    public Measure coordinateEpoch;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public DataEpoch() {
    }
}
