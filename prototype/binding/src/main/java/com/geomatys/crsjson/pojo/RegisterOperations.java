
package com.geomatys.crsjson.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Operations supported in the Coordinate Operations package.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterOperations extends Entity {
    /**
     * Citation used by this register operation.
     */
    @JsonProperty(value="authority", index=10, required=true)
    @JsonPropertyDescription("citation used by this register operation")
    public Object authority;

    /**
     * Creates a new instance with all values initialized to null.
     */
    public RegisterOperations() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     */
    public RegisterOperations(final org.opengis.referencing.AuthorityFactory impl) {
        entityType = "RegisterOperations";
        if (impl != null) {
            authority = impl.getAuthority();
        }
    }
}
