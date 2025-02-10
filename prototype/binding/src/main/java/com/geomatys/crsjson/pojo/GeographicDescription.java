
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Description of the geographic area using identifiers.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicDescription extends GeographicExtent {
    /**
     * The identifier used to represent a geographic area.
     */
    @JsonProperty(value="geographicIdentifier", index=100, required=true)
    @JsonPropertyDescription("the identifier used to represent a geographic area")
    public Identifier geographicIdentifier;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public GeographicDescription() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public GeographicDescription(org.opengis.metadata.extent.GeographicDescription impl) {
        super(impl);
        entityType = "GeographicDescription";
        var c = impl.getGeographicIdentifier();
        if (c != null) {
            geographicIdentifier = new Identifier(c);
        }
    }
}
