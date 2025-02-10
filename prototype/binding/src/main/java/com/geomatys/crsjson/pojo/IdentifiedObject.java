
package com.geomatys.crsjson.pojo;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Identifications of a <abbr>CRS</abbr>-related object.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdentifiedObject extends Entity {
    /**
     * Primary name by which this object is identified.
     */
    @JsonProperty(value="name", index=10, required=true)
    @JsonPropertyDescription("primary name by which this object is identified")
    public Identifier name;

    /**
     * Identifier which references elsewhere the object's defining information.
     * Alternatively an identifier by which this object can be referenced.
     */
    @JsonProperty(value="identifier", index=20)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("identifier which references elsewhere the object's defining information")
    public Set<Identifier> identifier;

    /**
     * Alternative name by which this object is identified.
     */
    @JsonProperty(value="alias", index=30)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("alternative name by which this object is identified")
    public Set<String> alias;

    /**
     * Comments on or information about this object, including data source information.
     */
    @JsonProperty(value="remarks", index=40)
    @JsonPropertyDescription("comments on or information about this object, including data source information")
    public String remarks;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected IdentifiedObject() {
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
    protected IdentifiedObject(final org.opengis.referencing.IdentifiedObject impl) {
        entityType = "IdentifiedObject";
        name       = new Identifier(impl.getName());
        identifier = many(impl.getIdentifiers(), Identifier::new);
        alias      = many(impl.getAlias(), org.opengis.util.GenericName::toString);
        remarks    = text(impl.getRemarks());
    }

    /**
     * Returns the string to marshal for the given code list value, or {@code null} if none.
     *
     * @param  impl  the code list value, or {@code null}.
     * @return the string to marshal, or {@code null} if none.
     */
    static String code(org.opengis.util.CodeList<?> impl) {
        if (impl != null) {
            String code = impl.identifier();
            return (code != null) ? code : impl.name();
        }
        return null;
    }
}
