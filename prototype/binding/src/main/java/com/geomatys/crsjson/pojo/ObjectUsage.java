
package com.geomatys.crsjson.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Usage of a CRS-related object.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class ObjectUsage
    extends IdentifiedObject
{
    /**
     * Scope and validity of a CRS-related object.
     */
    @JsonProperty(value="domain", index=90)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("scope and validity of a CRS-related object")
    public Set<ObjectDomain> domain;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected ObjectUsage() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ObjectUsage(org.opengis.referencing.datum.Datum impl) {
        super(impl);
        initialize(new ObjectDomain(impl));
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ObjectUsage(org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        super(impl);
        initialize(new ObjectDomain(impl));
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    protected ObjectUsage(org.opengis.referencing.operation.CoordinateOperation impl) {
        super(impl);
        initialize(new ObjectDomain(impl));
    }

    /**
     * Completes the construction of this instance.
     *
     * @param  node  the node containing the domain of validity.
     */
    private void initialize(ObjectDomain node) {
        entityType = "ObjectUsage";
        if (node.scope != null || node.domainOfValidity != null) {
            domain = Set.of(node);
        }
    }
}
