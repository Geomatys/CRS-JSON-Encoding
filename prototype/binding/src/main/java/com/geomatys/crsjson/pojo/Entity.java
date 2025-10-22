/*
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership. You may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.geomatys.crsjson.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;


/**
 * Base class of all <abbr>JSON</abbr> objects.
 */
@JsonTypeInfo(
    use      = JsonTypeInfo.Id.CLASS,
    include  = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "entityType")
@JsonAutoDetect(
    fieldVisibility    = JsonAutoDetect.Visibility.PUBLIC_ONLY,
    setterVisibility   = JsonAutoDetect.Visibility.NONE,
    getterVisibility   = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility  = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entity {
    /**
     * The object type.
     */
    @JsonProperty(index = 0, required = true)
    public String entityType;

    /**
     * Creates a new object.
     * Subclasses should set the {@link #entityType} value in their constructor.
     */
    protected Entity() {
    }

    /**
     * Returns the string to marshal for the given temporal object, or {@code null} if none.
     *
     * @param  impl  the temporal object, or {@code null}.
     * @return the string to marshal, or {@code null} if none.
     */
    static String text(java.time.temporal.Temporal impl) {
        return (impl != null) ? impl.toString() : null;
    }

    /**
     * Returns the string to marshal for the given international text, or {@code null} if none.
     *
     * @param  impl  the international text, or {@code null}.
     * @return the string to marshal, or {@code null} if none.
     *
     * @todo Take locale in account.
     */
    static String text(org.opengis.util.InternationalString impl) {
        return (impl != null) ? impl.toString() : null;
    }

    /**
     * Returns the given string as a pseudo-international text, or {@code null} if none.
     *
     * @param  text  the text, or {@code null}.
     * @return the pseudo-international text, or {@code null} if none.
     */
    static org.opengis.util.InternationalString i18n(String text) {
        return (text == null || text.isBlank()) ? null : new I18N(text);
    }

    /**
     * Returns the given string as a local name, or {@code null} if none.
     *
     * @param  impl  the text, or {@code null}.
     * @return the local name, or {@code null} if none.
     */
    static org.opengis.util.GenericName name(String text) {
        return (text == null || text.isBlank()) ? null : new LocalName(text);
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
     * Returns the code list value for the given name, or {@code null} if the name is null.
     *
     * @param  <E>      the type of the code list.
     * @param  name     the name of the code list to get.
     * @param  creator  the function to invoke for creating the code list instance.
     * @return the code list instance for the given name, or {@code null}.
     */
    static <E extends org.opengis.util.CodeList<E>> E codeForName(String name, Function<String, E> creator) {
        return (name != null) ? creator.apply(name) : null;
    }

    /**
     * Returns a non-empty array of the given elements, or {@code null} if none.
     * Null elements are discarded.
     *
     * @param  <S>       type of elements in the implementation.
     * @param  <T>       type of elements in the POJO to marshal.
     * @param  elements  the elements provided by the implementation.
     * @param  creator   the function for creating the array.
     * @param  mapper    converter from {@code <S>} to {@code <T>}.
     * @return non-empty array containing the converted elements, or {@code null} if none.
     */
    static <S,T> T[] array(final Collection<? extends S> elements,
                           final IntFunction<T[]> creator,
                           final Function<S,T> mapper)
    {
        if (elements != null) {
            final int size = elements.size();
            if (size != 0) {
                int count = 0;
                final T[] array = creator.apply(size);
                for (final S element : elements) {
                    T pojo = mapper.apply(element);
                    if (pojo != null) {
                        array[count++] = pojo;
                    }
                }
                if (count != 0) {
                    return (count == size) ? array : Arrays.copyOf(array, count);
                }
            }
        }
        return null;
    }

    /**
     * Returns the given array as a list if non-null, or an empty list otherwise.
     *
     * @param  <S>     type of elements in the array.
     * @param  <T>     type of elements in the returned list.
     * @param  array   the potentially null array.
     * @param  mapper  converter from {@code <S>} to {@code <T>}.
     * @return a non-null list, potentially empty.
     */
    static <S,T> List<T> list(final S[] array, final Function<S,T> mapper) {
        if (array == null) {
            return List.of();
        }
        final var elements = new ArrayList<T>(array.length);
        for (S value : array) {
            var element = mapper.apply(value);
            if (element != null) {
                elements.add(element);
            }
        }
        return elements;
    }

    /**
     * Returns the given array as a list if non-null, or an empty list otherwise.
     *
     * @param  <T>    type of elements.
     * @param  array  the potentially null array.
     * @return a non-null list, potentially empty.
     */
    static <T> List<T> list(final T[] array) {
        return (array != null) ? List.of(array) : List.of();
    }

    /**
     * Returns whether the given object may be a class of the given type.
     * This method checks the class name. This is not reliable, but we
     * cannot check an interface with is not defined in GeoAPI 3.0.2.
     *
     * @param  type  the class as a name.
     * @param  impl  the implementation to check.
     * @return whether the given object may be an implementation of the given type.
     */
    static boolean isInstanceByReflection(final String type, final Object impl) {
        return (impl != null) && impl.getClass().getName().endsWith(type);
    }

    /**
     * Tries to get a property by reflection.
     * This method is used for method proposed in GeoAPI 3.1 but not yet released.
     *
     * @param  <T>   compile-time value of {@code type}.
     * @param  type  expected type of the property value.
     * @param  impl  the implementation on which to invoke the method.
     * @param  name  name of the method to invoke.
     * @return the property value, or {@code null} if none.
     */
    static <T> T getByReflection(final Class<T> type, final Object impl, final String name) {
        if (impl != null) try {
            final Method method = impl.getClass().getMethod(name, (Class<?>[]) null);
            if (!Modifier.isStatic(method.getModifiers()) && type.isAssignableFrom(method.getReturnType())) {
                for (Class<?> e : method.getExceptionTypes()) {
                    if (!(RuntimeException.class.isAssignableFrom(e) || Error.class.isAssignableFrom(e))) {
                        return null;    // Do not execute if there is checked exceptions.
                    }
                }
                return type.cast(method.invoke(impl, (Object[]) null));
            }
        } catch (IllegalAccessException | InvocationTargetException ex) {
            final Throwable cause = ex.getCause();
            if (cause instanceof RuntimeException e) throw e;
            if (cause instanceof Error e) throw e;
            throw new UndeclaredThrowableException(ex);     // Should never happen.
        } catch (NoSuchMethodException e) {
            // Ignore silently.
        }
        return null;
    }

    /**
     * Tries to get the property of a value which is wrapped in an {@code Optional}.
     *
     * @param  <T>   compile-time value of {@code type}.
     * @param  type  expected type of the property value.
     * @param  impl  the implementation on which to invoke the method.
     * @param  name  name of the method to invoke.
     * @return the property value, or {@code null} if none.
     */
    static <T> T getOptionalByReflection(final Class<T> type, final Object impl, final String name) {
        final Optional<?> opt = getByReflection(Optional.class, impl, name);
        if (opt != null) {
            final Object value = opt.orElse(null);
            if (type.isInstance(value)) {
                return type.cast(value);
            }
        }
        return null;
    }
}
