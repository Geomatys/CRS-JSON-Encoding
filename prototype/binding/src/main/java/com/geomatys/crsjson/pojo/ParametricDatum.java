
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Textual description and/or a set of parameters identifying a particular reference surface
 * used as the origin of a parametric coordinate system, including its position with respect to the Earth.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParametricDatum
    extends Datum
{
    /**
     * Parameter used to define the parametric datum.
     */
    @JsonProperty(value="datumDefiningParameter", index=200)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("parameter used to define the parametric datum")
    public Set<Object> datumDefiningParameter;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ParametricDatum() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ParametricDatum(org.opengis.referencing.datum.Datum impl) {
        super(impl);
        entityType = "ParametricDatum";
    }
}
