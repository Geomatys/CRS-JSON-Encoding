
package com.geomatys.crsjson.pojo;

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

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected IdentifiedObject() {
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
    protected IdentifiedObject(final org.opengis.referencing.IdentifiedObject impl) {
        entityType = "IdentifiedObject";
        name       = code(impl.getName());
        identifier = many(impl.getIdentifiers(), IdentifiedObject::code);
        alias      = many(impl.getAlias(), org.opengis.util.GenericName::toString);
        remarks    = text(impl.getRemarks());
    }

    /**
     * Returns the string to marshal for the given international text, or {@code null} if none.
     *
     * @param  impl  the international text, or {@code null}.
     * @return the string to marshal, or {@code null} if none.
     */
    static String text(org.opengis.util.InternationalString impl) {
        return (impl != null) ? impl.toString() : null;
    }

    /**
     * Returns the string to marshal for the given identifier, or {@code null} if none.
     *
     * @param  impl  the identifier, or {@code null}.
     * @return the string to marshal, or {@code null} if none.
     */
    private static String code(org.opengis.metadata.Identifier impl) {
        return (impl != null) ? impl.getCode() : null;
    }

    /**
     * Returns the string to marshal for the given code list value, or {@code null} if none.
     *
     * @param  impl  the code list value, or {@code null}.
     * @return the string to marshal, or {@code null} if none.
     */
    static String code(org.opengis.util.CodeList<?> impl) {
        if (impl != null) {
            String code = impl.identifier();
            return (code != null) ? code : impl.name();
        }
        return null;
    }

    /**
     * Returns a non-empty set of the given elements, or {@code null} if none.
     *
     * @param  <S>       type of elements in the implementation.
     * @param  <T>       type of elements in the POJO to marshal.
     * @param  elements  the elements provided by the implementation.
     * @param  mapper    converter from {@code <S>} to {@code <T>}.
     * @return non-empty set containing the converted elements, or {@code null} if none.
     */
    static <S,T> Set<T> many(Collection<S> elements, Function<S,T> mapper) {
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
}
