
package com.geomatys.json.pojo;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * value of the coordinate operation parameter
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "stringValue",
    "integerValue",
    "booleanValue",
    "valueList",
    "integerValueList",
    "valueFile",
    "valueFileCitation",
    "geographicObject"
})
@Generated("jsonschema2pojo")
public class ParameterValue {

    /**
     * measure object
     * <p>
     * definition of a measure object
     *
     */
    @JsonProperty("value")
    @JsonPropertyDescription("definition of a measure object")
    public Measure value;
    /**
     * string value of a coordinate operation parameter
     * Note: A string value does not have an associated unit.
     *
     */
    @JsonProperty("stringValue")
    @JsonPropertyDescription("string value of a coordinate operation parameter\r\nNote: A string value does not have an associated unit.")
    public String stringValue;
    /**
     * positive integer value of a coordinate operation parameter, usually used for a count
     * Note: An integer value does not have an associated unit.
     *
     */
    @JsonProperty("integerValue")
    @JsonPropertyDescription("positive integer value of a coordinate operation parameter, usually used for a count\r\nNote: An integer value does not have an associated unit.")
    public Integer integerValue;
    /**
     * boolean value of a coordinate operation parameter
     * Note: A Boolean value does not have an associated unit.
     *
     */
    @JsonProperty("booleanValue")
    @JsonPropertyDescription("boolean value of a coordinate operation parameter\r\nNote: A Boolean value does not have an associated unit.")
    public Boolean booleanValue;
    /**
     * ordered collection, i.e. sequence, of two or more numeric values of a coordinate operation parameter list, where each value has the same associated unit
     *
     */
    @JsonProperty("valueList")
    @JsonPropertyDescription("ordered collection, i.e. sequence, of two or more numeric values of a coordinate operation parameter list, where each value has the same associated unit")
    public List<Measure> valueList;
    /**
     * ordered collection, i.e. sequence, of two or more integer values of a coordinate operation parameter list, usually used for counts
     * Note: These integer values do not have an associated unit.
     *
     */
    @JsonProperty("integerValueList")
    @JsonPropertyDescription("ordered collection, i.e. sequence, of two or more integer values of a coordinate operation parameter list, usually used for counts\r\nNote: These integer values do not have an associated unit.")
    public List<Integer> integerValueList;
    /**
     * reference to a file or an identified part of a file containing one or more parameter values" and note changed to "Note: The referenced file or part of a file can reference another part of the same or different files, as allowed in XML documents
     *
     */
    @JsonProperty("valueFile")
    @JsonPropertyDescription("reference to a file or an identified part of a file containing one or more parameter values\" and note changed to \"Note: The referenced file or part of a file can reference another part of the same or different files, as allowed in XML documents")
    public String valueFile;
    /**
     * citation for a reference to a file or an identified part of a file containing one or more parameter values
     *
     * Note: The referenced file or part of a file can reference another part of the same or different files, as allowed in XML documents
     *
     */
    @JsonProperty("valueFileCitation")
    @JsonPropertyDescription("citation for a reference to a file or an identified part of a file containing one or more parameter values\r\n\r\nNote: The referenced file or part of a file can reference another part of the same or different files, as allowed in XML documents")
    public Object valueFileCitation;
    /**
     * identifier of a geographic feature of which the coordinates are used as operation parameters
     *
     */
    @JsonProperty("geographicObject")
    @JsonPropertyDescription("identifier of a geographic feature of which the coordinates are used as operation parameters")
    public Object geographicObject;

}
