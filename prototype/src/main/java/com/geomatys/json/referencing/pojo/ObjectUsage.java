
package com.geomatys.json.referencing.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * usage of a CRS-related object
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "domain"
})
@Generated("jsonschema2pojo")
public class ObjectUsage
    extends IdentifiedObject
{

    /**
     * scope and validity of a CRS-related object
     *
     */
    @JsonProperty("domain")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("scope and validity of a CRS-related object")
    public Set<ObjectDomain> domain;

    public ObjectUsage() {
    }

    public ObjectUsage(org.opengis.referencing.datum.Datum obj) {
        super(obj);
        domain = set(new ObjectDomain(obj));
    }

    private static Set<ObjectDomain> set(ObjectDomain element) {
        return (element.scope != null || element.domainOfValidity != null) ? Set.of(element) : null;
    }
}
