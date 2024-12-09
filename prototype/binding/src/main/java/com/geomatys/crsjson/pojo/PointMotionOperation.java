
package com.geomatys.crsjson.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * mathematical operation that decribes the change of coordinate values within one coordinate reference system due to the motion of the point between one coordinate epoch and another coordinate epoch
 * Note: In this document the motion is due to tectonic plate movement or deformation.
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class PointMotionOperation
    extends SingleOperation
{


}
