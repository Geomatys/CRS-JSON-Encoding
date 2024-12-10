
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * scope and validity of a CRS-related object
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scope",
    "domainOfValidity"
})
@Generated("jsonschema2pojo")
public class ObjectDomain {

    /**
     * description of usage, or limitations of usage, for which this object is valid
     * Note: If unknown, enter "not known".
     * (Required)
     *
     */
    @JsonProperty("scope")
    @JsonPropertyDescription("description of usage, or limitations of usage, for which this object is valid \r\nNote: If unknown, enter \"not known\".")
    public String scope;
    /**
     * spatial and temporal extent in which this object is valid
     * (Required)
     *
     */
    @JsonProperty("domainOfValidity")
    @JsonPropertyDescription("spatial and temporal extent in which this object is valid")
    public Object domainOfValidity;


    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    public ObjectDomain() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ObjectDomain(org.opengis.referencing.datum.Datum impl) {
        scope = IdentifiedObject.text(impl.getScope());
        domainOfValidity = domain(impl.getDomainOfValidity());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ObjectDomain(org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        scope = IdentifiedObject.text(impl.getScope());
        domainOfValidity = domain(impl.getDomainOfValidity());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ObjectDomain(org.opengis.referencing.operation.CoordinateOperation impl) {
        scope = IdentifiedObject.text(impl.getScope());
        domainOfValidity = domain(impl.getDomainOfValidity());
    }

    /**
     * Returns the domain of validity of the given extent, or {@code null} if none.
     *
     * @param impl the domain of validity to serialize, or {@code null} if none.
     * @return the domain to serialize, or {@code null} if none.
     */
    private static Object domain(org.opengis.metadata.extent.Extent impl) {
        // TODO
        return null;
    }
}
