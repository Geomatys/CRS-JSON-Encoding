
package com.geomatys.json.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * coordinate system used by an engineering coordinate reference system, one of an affine coordinate system, a Cartesian coordinate system, a cylindrical coordinate system, a linear coordinate sytem, an ordinal coordinate system, a polar coordinate system or a spherical coordinate system
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "entityType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affineCS",
    "cartesianCS",
    "cylindricalCS",
    "linearCS",
    "polarCS",
    "sphericalCS",
    "ordinalCS"
})
@Generated("jsonschema2pojo")
public class EngineeringCS {

    /**
     * two- or three-dimensional coordinate system in Euclidean space with straight axes that are not necessarily orthogonal. The number of associations shall equal the dimension of the CS.
     *
     */
    @JsonProperty("affineCS")
    @JsonPropertyDescription("two- or three-dimensional coordinate system in Euclidean space with straight axes that are not necessarily orthogonal. The number of associations shall equal the dimension of the CS.")
    public Object affineCS;
    /**
     * two- or three-dimensional coordinate system in Euclidean space with orthogonal straight axes. All axes shall have the same length unit. A CartesianCS shall have two or three axis associations; the number of associations shall equal the dimension of the CS.
     *
     */
    @JsonProperty("cartesianCS")
    @JsonPropertyDescription("two- or three-dimensional coordinate system in Euclidean space with orthogonal straight axes. All axes shall have the same length unit. A CartesianCS shall have two or three axis associations; the number of associations shall equal the dimension of the CS.")
    public Object cartesianCS;
    /**
     * three-dimensional coordinate system in Euclidean space consisting of a polar coordinate system extended by a straight coordinate axis perpendicular to the plane spanned by the polar coordinate system. A CylindricalCS shall have three axis associations.
     *
     */
    @JsonProperty("cylindricalCS")
    @JsonPropertyDescription("three-dimensional coordinate system in Euclidean space consisting of a polar coordinate system extended by a straight coordinate axis perpendicular to the plane spanned by the polar coordinate system. A CylindricalCS shall have three axis associations.")
    public Object cylindricalCS;
    /**
     * one-dimensional coordinate system that consists of the points that lie on the single axis described. The associated coordinate is the distance – with or without offset – from the origin point, specified through the datum definition, to the point along the axis. Example: usage of the line feature representing a pipeline to describe points on or along that pipeline. A LinearCS shall have one axis association.
     *
     */
    @JsonProperty("linearCS")
    @JsonPropertyDescription("one-dimensional coordinate system that consists of the points that lie on the single axis described. The associated coordinate is the distance \u2013 with or without offset \u2013 from the origin point, specified through the datum definition, to the point along the axis. Example: usage of the line feature representing a pipeline to describe points on or along that pipeline. A LinearCS shall have one axis association.")
    public Object linearCS;
    /**
     * two-dimensional coordinate system in Euclidean space in which position is specified by the distance from the origin and the angle between the line from the origin to a point and a reference direction. A PolarCS shall have two axis associations.
     *
     */
    @JsonProperty("polarCS")
    @JsonPropertyDescription("two-dimensional coordinate system in Euclidean space in which position is specified by the distance from the origin and the angle between the line from the origin to a point and a reference direction. A PolarCS shall have two axis associations.")
    public Object polarCS;
    /**
     * three-dimensional coordinate system in Euclidean space with one distance measured from the origin and two angular coordinates. Not to be confused with an ellipsoidal coordinate system based on an ellipsoid "degenerated" into a sphere. A SphericalCS shall have three axis associations.
     *
     */
    @JsonProperty("sphericalCS")
    @JsonPropertyDescription("three-dimensional coordinate system in Euclidean space with one distance measured from the origin and two angular coordinates. Not to be confused with an ellipsoidal coordinate system based on an ellipsoid \"degenerated\" into a sphere. A SphericalCS shall have three axis associations.")
    public Object sphericalCS;
    /**
     * n-dimensional coordinate system in which every axis uses integers. The number of associations shall be equal the dimension of the CS.
     *
     */
    @JsonProperty("ordinalCS")
    @JsonPropertyDescription("n-dimensional coordinate system in which every axis uses integers. The number of associations shall be equal the dimension of the CS.")
    public Object ordinalCS;

}
