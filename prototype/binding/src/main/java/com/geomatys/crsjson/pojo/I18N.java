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

import java.util.Locale;
import org.opengis.util.InternationalString;

/**
 * Localization support. We provide no real localization for now.
 */
final class I18N implements InternationalString {
    /**
     * The text to wrap.
     */
    private final String text;

    /**
     * Creates a new pseudo-international text.
     *
     * @param text the text to wrap.
     */
    I18N(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public String toString(Locale locale) {
        return text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return text.subSequence(start, end);
    }

    @Override
    public int compareTo(org.opengis.util.InternationalString o) {
        return text.compareTo(o.toString());
    }

    @Override
    public boolean equals(final Object obj) {
        return (obj instanceof I18N) && text.equals(((I18N) obj).text);
    }

    @Override
    public int hashCode() {
        return text.hashCode() + getClass().hashCode();
    }
}
