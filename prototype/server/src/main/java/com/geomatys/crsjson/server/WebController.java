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
package com.geomatys.crsjson.server;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.geomatys.crsjson.Registry;
import com.geomatys.crsjson.Type;


/**
 * The controller that responds to request for <abbr>JSON</abbr> encoding of a <abbr>CRS</abbr>.
 */
@Controller
public final class WebController {
    /**
     * Creates a new controller.
     */
    public WebController() {
    }

    /**
     * {@return the <abbr>URL</abbr> to the home page}.
     */
    @GetMapping("/")
    public String home() {
        // Redirect to src/main/resources/static/index.html
        return "redirect:/index.html";
    }

    /**
     * Responds to a request for <abbr>JSON</abbr> encoding of a <abbr>CRS</abbr>.
     *
     * @param  code  the <abbr>EPSG</abbr> code.
     * @return the <abbr>JSON</abbr> encoding.
     */
    @GetMapping(value = "/def/crs/epsg/12.026/{code}", produces = "application/json")
    public ResponseEntity<String> getCRS(@PathVariable("code") int code) {
        return format(Type.CRS, code);
    }

    /**
     * Responds to a request for <abbr>JSON</abbr> encoding of a coordinate system.
     *
     * @param  code  the <abbr>EPSG</abbr> code.
     * @return the <abbr>JSON</abbr> encoding.
     */
    @GetMapping(value = "/def/cs/epsg/12.026/{code}", produces = "application/json")
    public ResponseEntity<String> getCS(@PathVariable("code") int code) {
        return format(Type.CS, code);
    }

    /**
     * Responds to a request for <abbr>JSON</abbr> encoding of a datum.
     *
     * @param  code  the <abbr>EPSG</abbr> code.
     * @return the <abbr>JSON</abbr> encoding.
     */
    @GetMapping(value = "/def/datum/epsg/12.026/{code}", produces = "application/json")
    public ResponseEntity<String> getDatum(@PathVariable("code") int code) {
        return format(Type.DATUM, code);
    }

    /**
     * Responds to a request for <abbr>JSON</abbr> encoding of a coordinate operation.
     *
     * @param  code  the <abbr>EPSG</abbr> code.
     * @return the <abbr>JSON</abbr> encoding.
     */
    @GetMapping(value = "/def/coordinateOperation/epsg/12.026/{code}", produces = "application/json")
    public ResponseEntity<String> getOperation(@PathVariable("code") int code) {
        return format(Type.OPERATION, code);
    }

    /**
     * Formats a <abbr>JSON</abbr> document for an object of the given type.
     *
     * @param  type  the object type.
     * @param  code  the <abbr>EPSG</abbr> code of the object to format.
     * @return <abbr>JSON</abbr> document for the requested object.
     */
    private static ResponseEntity<String> format(Type type, int code) {
        String json;
        try {
            json = Registry.INSTANCE.format(type, "EPSG:" + code);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(json);
    }
}
