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

import java.util.List;
import org.opengis.util.GenericName;
import org.opengis.util.InternationalString;
import org.opengis.util.NameSpace;
import org.opengis.util.ScopedName;

/**
 * A name with no scope.
 */
final class LocalName implements org.opengis.util.LocalName {
    /**
     * The text to wrap.
     */
    private final String text;

    LocalName(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public InternationalString toInternationalString() {
        return new I18N(text);
    }

    /**
     * Number of levels specified by this name, which is always 1 for a local name.
     */
    @Override
    public int depth() {
        return 1;
    }

    /**
     * Returns the sequence of local names,
     * which is always a singleton containing only {@code this} for local name.
     */
    @Override
    public List<LocalName> getParsedNames() {
        return List.of(this);
    }

    /**
     * Returns {@code this} since this object is already a local name.
     */
    @Override
    public LocalName head() {
        return this;
    }

    /**
     * Returns {@code this} since this object is already a local name.
     */
    @Override
    public LocalName tip() {
        return this;
    }

    /**
     * Returns {@code this} since this implementation has no scope.
     */
    @Override
    public GenericName toFullyQualifiedName() {
        return this;
    }

    @Override
    public NameSpace scope() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScopedName push(GenericName gn) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int compareTo(org.opengis.util.GenericName o) {
        return text.compareTo(o.toString());
    }

    @Override
    public boolean equals(final Object obj) {
        return (obj instanceof LocalName) && text.equals(((LocalName) obj).text);
    }

    @Override
    public int hashCode() {
        return text.hashCode() + getClass().hashCode();
    }
}
