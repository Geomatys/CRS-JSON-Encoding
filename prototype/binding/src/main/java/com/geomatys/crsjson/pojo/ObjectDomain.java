
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Scope and validity of a CRS-related object.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectDomain extends Entity {
    /**
     * Description of usage, or limitations of usage, for which this object is valid.
     * If unknown, enter "not known".
     */
    @JsonProperty(value="scope", index=10, required=true)
    @JsonPropertyDescription("description of usage, or limitations of usage, for which this object is valid")
    public String scope;

    /**
     * Spatial and temporal extent in which this object is valid.
     */
    @JsonProperty(value="domainOfValidity", index=20, required=true)
    @JsonPropertyDescription("spatial and temporal extent in which this object is valid")
    public Extent domainOfValidity;

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
        entityType = "ObjectDomain";
        scope = text(impl.getScope());
        domainOfValidity = domain(impl.getDomainOfValidity());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ObjectDomain(org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        scope = text(impl.getScope());
        domainOfValidity = domain(impl.getDomainOfValidity());
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public ObjectDomain(org.opengis.referencing.operation.CoordinateOperation impl) {
        scope = text(impl.getScope());
        domainOfValidity = domain(impl.getDomainOfValidity());
    }

    /**
     * Returns the domain of validity of the given extent, or {@code null} if none.
     *
     * @param impl the domain of validity to serialize, or {@code null} if none.
     * @return the domain to serialize, or {@code null} if none.
     */
    private static Extent domain(org.opengis.metadata.extent.Extent impl) {
        return (impl != null) ? new Extent(impl) : null;
    }
}
