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

import java.util.Set;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests writing a few JSON objects.
 */
public class WriteTest {
    /**
     * The JSON marshaller.
     */
    private final ObjectMapper mapper;

    /**
     * Creates a new test case.
     */
    public WriteTest() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Writes the given object and returns each line separately.
     *
     * @param  object  the object to write.
     * @return the lines of the JSON document.
     * @throws JsonProcessingException if an error occurred while writing the JSON document.
     */
    private List<String> write(Object object) throws JsonProcessingException {
        String text = mapper.writeValueAsString(object);
        return Arrays.asList(text.split(System.lineSeparator()));
    }

    /**
     * Tests writing an {@link IdentifiedObject}.
     *
     * @throws JsonProcessingException if an error occurred while writing the JSON document.
     */
    @Test
    public void testIdentifiedObject() throws JsonProcessingException {
        var object = new IdentifiedObject();
        object.entityType = "IdentifiedObject";
        object.name = "WGS 84";
        object.identifier = Set.of("EPSG:4326");
        object.remarks = "This is a test of CRS-JSON.";
        assertLinesMatch(Arrays.asList(
                "{",
                "  \"entityType\" : \"IdentifiedObject\",",
                "  \"name\" : \"WGS 84\",",
                "  \"identifier\" : [ \"EPSG:4326\" ],",
                "  \"remarks\" : \"This is a test of CRS-JSON.\"",
                "}"),
                write(object));
    }
}
