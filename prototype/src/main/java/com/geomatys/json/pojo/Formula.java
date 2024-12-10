
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * specification of the coordinate operation method formula
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "formula",
    "formulaCitation"
})
@Generated("jsonschema2pojo")
public class Formula {

    /**
     * formula(s) or procedure used by the coordinate operation method
     *
     */
    @JsonProperty("formula")
    @JsonPropertyDescription("formula(s) or procedure used by the coordinate operation method")
    public String formula;
    /**
     * reference to a publication giving the formula(s) or procedure used by the coordinate operation method
     *
     */
    @JsonProperty("formulaCitation")
    @JsonPropertyDescription("reference to a publication giving the formula(s) or procedure used by the coordinate operation method")
    public Object formulaCitation;

}
