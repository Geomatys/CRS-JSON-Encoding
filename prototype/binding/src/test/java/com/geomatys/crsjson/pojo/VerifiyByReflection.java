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

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.opengis.parameter.InvalidParameterTypeException;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Verifies all objects defined in this package.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public final class VerifiyByReflection {
    /**
     * Extension of class filenames.
     */
    private static final String CLASS_EXTENSION = ".class";

    /**
     * The root class of this package.
     */
    private final Class<?> root;

    /**
     * All public classes to verify.
     */
    private final Class<?>[] classes;

    /**
     * Creates a new test.
     *
     * @throws URISyntaxException if this constructor cannot get the directories of classes.
     * @throws ClassNotFoundException if the name of a class has not been correctly derived.
     */
    public VerifiyByReflection() throws URISyntaxException, ClassNotFoundException {
        root = Entity.class;
        final String prefix = root.getPackageName() + '.';
        final var publicClasses = new ArrayList<Class<?>>(100);
        final File dir = new File(Entity.class.getResource(root.getSimpleName() + CLASS_EXTENSION).toURI()).getParentFile();
        for (String classname : dir.list((d, n) -> n.endsWith(CLASS_EXTENSION) && n.indexOf('$') < 0 && n.indexOf('-') < 0)) {
            classname = classname.substring(0, classname.lastIndexOf('.'));
            final Class<?> c = Class.forName(prefix + classname);
            if (Modifier.isPublic(c.getModifiers())) {
                publicClasses.add(c);
            }
        }
        classes = publicClasses.toArray(Class<?>[]::new);
    }

    /**
     * Verifies that all public class extents {@link Entity} directly or indirectly.
     */
    @Test
    public void verifyExtentsEntity() {
        for (Class<?> c : classes) {
            final String classname = c.getSimpleName();
            while (c != root) {
                assertNotEquals(c, Object.class, classname);
                c = c.getSuperclass();
            }
        }
    }

    /**
     * Verifies that annotations are present on all public field
     * and there there is no duplicated index values.
     */
    @Test
    public void verifyFieldAnnotation() {
        final var indexes = new HashSet<Integer>();
        for (final Class<?> c : classes) {
            assertTrue(indexes.add(-1));
            final String classname = c.getSimpleName();
            for (final Field field : c.getFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                final String name = classname + '.' + field.getName();
                final JsonProperty property = field.getAnnotation(JsonProperty.class);
                assertNotNull(property, name);
                assertTrue(property.value().isEmpty(), name);
                assertTrue(indexes.add(property.index()), name);
            }
            indexes.clear();
        }
    }

    /**
     * Verifies that all objects have a public or protected no-argument constructor,
     * and that other constructors are protected.
     */
    @Test
    public void verifyConstructors() {
        for (final Class<?> c : classes) {
            boolean foundDefaultConstructor = false;
            final String classname = c.getSimpleName();
            for (final Constructor<?> cstr : c.getDeclaredConstructors()) {
                if (cstr.getParameterCount() == 0) {
                    foundDefaultConstructor = true;
                    final boolean isAbstract = Modifier.isAbstract(c.getModifiers()) || c == root;
                    assertEquals( isAbstract, Modifier.isProtected(cstr.getModifiers()), classname);
                    assertEquals(!isAbstract, Modifier.isPublic   (cstr.getModifiers()), classname);
                } else {
                    final Parameter[] parameters = cstr.getParameters();
                    if (parameters.length == 1 && isSameType(c, parameters[0].getType())) {
                        // Constructor that wrap a GeoAPI object in the POJO.
                        // Protected for encouraging the use of `create(…)`.
                        assertTrue(Modifier.isProtected(cstr.getModifiers()), classname);
                    }
                }
            }
            assertTrue(foundDefaultConstructor, classname);
        }
    }

    /**
     * Returns whether the given parameter type is one of the interfaces implemented by a POJO.
     * In such case, the constructor is wrapping a GeoAPI object into a POJO of same interface.
     */
    private static boolean isSameType(final Class<?> pojo, final Class<?> parameter) {
        if (parameter.isInterface()) {
            for (Class<?> c : pojo.getInterfaces()) {
                if (c == parameter) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifies that the method return type are the same as in the implemented GeoAPI interface.
     *
     * @throws NoSuchMethodException if a method declared in an interface was not found in the POJO.
     */
    @Test
    public void verifyMethodReturnType() throws NoSuchMethodException {
        for (final Class<?> c : classes) {
            for (final Class<?> it : c.getInterfaces()) {
                for (final Method method : it.getMethods()) {
                    if (!method.isSynthetic()) {
                        final String name = method.getName();
                        final Method impl = c.getMethod(name, method.getParameterTypes());
                        if (c == OperationMethod.class && name.equals("getParameters")) {
                            // Exception to this check.
                            continue;
                        }
                        assertEquals(method.getReturnType(), impl.getReturnType(),
                                () -> "Return type of " + c.getSimpleName() + '.' + name);
                    }
                }
            }
        }
    }

    /**
     * Tests all static {@code create(…)} method. The proxy returns {@code null} for all method,
     * which is convenient for finding places where we forgot to invoke {@code create(…)} instead
     * of a direct call to the constructor. Those places are found by {@link NullPointerException}.
     *
     * @throws IllegalAccessException if an error occurred while invoking {@code create(…)} by reflection.
     */
    @Test
    public void testCreate() throws IllegalAccessException {
        for (Class<?> c : classes) {
            if (!Modifier.isAbstract(c.getModifiers())) {
                final Class<?>[] interfaces = c.getInterfaces();
                if (interfaces.length != 0) {
                    Object proxy = null;
                    final String classname = c.getSimpleName();
                    for (final Method method : c.getMethods()) {
                        if (method.getName().equals("create")) {
                            if (proxy == null) {
                                proxy = Proxy.newProxyInstance(root.getClassLoader(), interfaces, (p, m, args) -> {
                                    final Class<?> type = m.getReturnType();
                                    if (type == Integer.TYPE) return 0;
                                    if (type ==  Double.TYPE) return 0d;
                                    if (type == Boolean.TYPE) return false;
                                    if (type == Set.class)    return Set.of();
                                    if (type == List.class || type == Collection.class) return List.of();
                                    return null;
                                });
                            }
                            final Object instance;
                            try {
                                instance = method.invoke(null, proxy);
                                assertSame(instance, method.invoke(null, instance), classname);
                            } catch (InvocationTargetException e) {
                                fail("Exception thrown by " + classname + '.' + method.getName(), e.getCause());
                                continue;
                            }
                            /*
                             * Verify that no unexpected exeception is thrown by public methods.
                             */
                            for (final Method getter : c.getMethods()) {
                                if (getter.getDeclaringClass().isAssignableFrom(Entity.class)) {
                                    continue;   // Skip Object and Entity methods.
                                }
                                if (getter.getParameterCount() == 0) try {
                                    Object result = getter.invoke(instance);
                                    if (Collection.class.isAssignableFrom(getter.getReturnType())) {
                                        if (c != OperationParameter.class) {    // Special case.
                                            assertNotNull(result, () -> "Collection returned by " + classname + '.' + getter.getName());
                                        }
                                    }
                                } catch (InvocationTargetException e) {
                                    Throwable cause = e.getCause();
                                    if (!(cause instanceof UnsupportedOperationException ||
                                          cause instanceof InvalidParameterTypeException))
                                    {
                                        fail("Unexpected exception thrown by " + classname + '.' + getter.getName(), cause);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
