
package com.geomatys.json.referencing.pojo;

import java.util.Set;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.function.Function;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * identifications of a CRS-related object
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entityType",
    "name",
    "identifier",
    "alias",
    "remarks"
})
@Generated("jsonschema2pojo")
public class IdentifiedObject {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("entityType")
    public String entityType;
    /**
     * primary name by which this object is identified
     * (Required)
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("primary name by which this object is identified")
    public Object name;
    /**
     * identifier which references elsewhere the object's defining information; alternatively an identifier by which this object can be referenced
     *
     */
    @JsonProperty("identifier")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("identifier which references elsewhere the object's defining information; alternatively an identifier by which this object can be referenced")
    public Set<Object> identifier;
    /**
     * alternative name by which this object is identified
     *
     */
    @JsonProperty("alias")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("alternative name by which this object is identified")
    public Set<String> alias;
    /**
     * comments on or information about this object, including data source information
     *
     */
    @JsonProperty("remarks")
    @JsonPropertyDescription("comments on or information about this object, including data source information")
    public String remarks;

    public IdentifiedObject() {
    }

    public IdentifiedObject(final org.opengis.referencing.IdentifiedObject obj) {
        name = code(obj.getName());
        identifier = set(obj.getIdentifiers(), IdentifiedObject::code);
        alias = set(obj.getAlias(), org.opengis.util.GenericName::toString);
        remarks = text(obj.getRemarks());
    }

    static String code(org.opengis.metadata.Identifier id) {
        return (id != null) ? id.getCode() : null;
    }

    static <S,T> Set<T> set(Collection<S> elements, Function<S,T> mapper) {
        if (elements == null || elements.isEmpty()) {
            return null;
        }
        var result = new LinkedHashSet<T>(elements.size());
        elements.forEach((e) -> {
            T t = mapper.apply(e);
            if (t != null) {
                result.add(t);
            }
        });
        return result;
    }

    static String text(org.opengis.util.InternationalString i18n) {
        return (i18n != null) ? i18n.toString() : null;
    }
}
