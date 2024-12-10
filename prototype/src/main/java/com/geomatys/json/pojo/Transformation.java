
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * mathematical operation on coordinates in which parameters are empirically derived from data containing the coordinates of a series of points in both coordinate reference systems
 * Note: This computational process is usually “over-determined”, allowing derivation of error (or accuracy) estimates for the coordinate transformation. Also, the stochastic nature of the parameters may result in multiple (different) versions of the same coordinate transformations between the same source and target CRSs. Any single coordinate operation in which the input and output coordinates are referenced to different datums (reference frames) will be a coordinate transformation.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Transformation
    extends SingleOperation
{


}
