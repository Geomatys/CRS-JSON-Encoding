
package com.geomatys.crsjson.pojo;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Base class of all <abbr>JSON</abbr> object.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entity {
    /**
     * The object type.
     */
    @JsonProperty(value="entityType", index=0, required=true)
    public String entityType;

    /**
     * Creates a new object.
     * Subclasses should set the {@link #entityType} value in their constructor.
     */
    protected Entity() {
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
