
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Identifications of a <abbr>CRS</abbr>-related object
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Identifier extends Entity {
    /**
     * Person or party responsible for maintenance of the namespace.
     */
    @JsonProperty(value="authority", index=100)
    @JsonPropertyDescription("person or party responsible for maintenance of the namespace")
    public Citation authority;

    /**
     * Alphanumeric value identifying an instance in the namespace.
     */
    @JsonProperty(value="code", index=110, required=true)
    @JsonPropertyDescription("alphanumeric value identifying an instance in the namespace")
    public String code;

    /**
     * Identifier or namespace in which the code is valid.
     */
    @JsonProperty(value="codeSpace", index=120)
    @JsonPropertyDescription("identifier or namespace in which the code is valid")
    public String codeSpace;

    /**
     * Version identifier for the namespace, as specified by the code authority.
     */
    @JsonProperty(value="version", index=130)
    @JsonPropertyDescription("version identifier for the namespace, as specified by the code authority")
    public String version;

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected Identifier() {
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
    protected Identifier(final org.opengis.metadata.Identifier impl) {
        entityType = "Identifier";
        if (impl != null) {
            var c = impl.getAuthority();
            if (c != null) {
                authority = new Citation(c);
            }
            code = impl.getCode();
            if (impl instanceof org.opengis.referencing.ReferenceIdentifier r) {
                codeSpace = r.getCodeSpace();
                version   = r.getVersion();
            }
        }
    }
}
