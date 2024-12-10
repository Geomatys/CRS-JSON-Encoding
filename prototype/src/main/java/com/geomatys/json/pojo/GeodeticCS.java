
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * coordinate system used by a Geodetic CRS, one of a Cartesian coordinate system or a spherical coordinate system
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cartesianCS",
    "ellipsoidalCS",
    "sphericalCS"
})
@Generated("jsonschema2pojo")
public class GeodeticCS {

    /**
     * two- or three-dimensional coordinate system in Euclidean space with orthogonal straight axes. All axes shall have the same length unit. A CartesianCS shall have two or three axis associations; the number of associations shall equal the dimension of the CS.
     *
     */
    @JsonProperty("cartesianCS")
    @JsonPropertyDescription("two- or three-dimensional coordinate system in Euclidean space with orthogonal straight axes. All axes shall have the same length unit. A CartesianCS shall have two or three axis associations; the number of associations shall equal the dimension of the CS.")
    public Object cartesianCS;
    /**
     * two- or three-dimensional coordinate system in which position is specified by geodetic latitude, geodetic longitude, and (in the three-dimensional case) ellipsoidal height. An EllipsoidalCS shall have two or three associations; the number of associations shall equal the dimension of the CS.
     *
     */
    @JsonProperty("ellipsoidalCS")
    @JsonPropertyDescription("two- or three-dimensional coordinate system in which position is specified by geodetic latitude, geodetic longitude, and (in the three-dimensional case) ellipsoidal height. An EllipsoidalCS shall have two or three associations; the number of associations shall equal the dimension of the CS.")
    public Object ellipsoidalCS;
    /**
     * three-dimensional coordinate system in Euclidean space with one distance measured from the origin and two angular coordinates. Not to be confused with an ellipsoidal coordinate system based on an ellipsoid "degenerated" into a sphere. A SphericalCS shall have three axis associations.
     *
     */
    @JsonProperty("sphericalCS")
    @JsonPropertyDescription("three-dimensional coordinate system in Euclidean space with one distance measured from the origin and two angular coordinates. Not to be confused with an ellipsoidal coordinate system based on an ellipsoid \"degenerated\" into a sphere. A SphericalCS shall have three axis associations.")
    public Object sphericalCS;

}
