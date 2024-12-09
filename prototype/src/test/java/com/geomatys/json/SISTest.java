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
package com.geomatys.json;

import org.apache.sis.referencing.CRS;
import org.opengis.util.FactoryException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;


/**
 * Tests writing a few JSON objects from CRS definitions provided by Apache SIS.
 */
public class SISTest {
    /**
     * The writer to use for testing purpose.
     */
    private final Writer writer;

    /**
     * Creates a new test case.
     */
    public SISTest() {
        writer = new Writer();
    }

    /**
     * Tests writing a projected CRS.
     *
     * @throws FactoryException if an error occurred while fetching the object definition with Apache SIS.
     * @throws JsonProcessingException if an error occurred while writing the JSON document.
     */
    @Test
    public void testProjectedCRS() throws FactoryException, JsonProcessingException {
        var crs = CRS.forCode("EPSG:2154");
        System.out.println(writer.write(crs));
    }
}
