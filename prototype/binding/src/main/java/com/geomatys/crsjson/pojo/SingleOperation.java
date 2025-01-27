
package com.geomatys.crsjson.pojo;

import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Single (not concatenated) coordinate operation.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class SingleOperation
    extends CoordinateOperation
{
    /**
     * Parameter value or parameter value group used by this single operation.
     */
    @JsonProperty(value="parameterValue", index=200)
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("parameter value or parameter value group used by this single operation")
    public Set<Object> parameterValue;

    /**
     * Algorithm or procedure used by this single operation.
     */
    @JsonProperty(value="method", index=210, required=true)
    @JsonPropertyDescription("algorithm or procedure used by this single operation")
    public Object method;

    // ════════════════════════════════ Codes below this point were added manually ════════════════════════════════

    /**
     * Creates a new instance with all values initialized to null.
     */
    protected SingleOperation() {
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The argument is an implementation of an external project such as Apache SIS or PROJ.
     *
     * <h4>Note for subclasses</h4>
     * Subclasses should overwrite the {@link #entityType} value in their constructor.
     *
     * @param impl     implementation of a GeoAPI object to serialize.
     * @param withCRS  whether to initialize also {@link #sourceCRS} and {@link #targetCRS}.
     */
    protected SingleOperation(final org.opengis.referencing.operation.SingleOperation impl, boolean withCRS) {
        super(impl, withCRS);
        entityType = "SingleOperation";
        parameterValue = many(impl.getParameterValues().values(), GeneralParameterValue::create);
        method = new OperationMethod(impl.getMethod());
    }
}
