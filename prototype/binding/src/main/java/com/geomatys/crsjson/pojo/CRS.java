/*
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership. You may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.geomatys.crsjson.pojo;


/**
 * Coordinate reference system which is usually single but may be compound.
 */
public abstract class CRS extends ObjectUsage
        implements org.opengis.referencing.crs.CoordinateReferenceSystem
{
    /**
     * Creates a new instance with all values initialized to null.
     */
    protected CRS() {
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
    protected CRS(final org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        super(impl);
        entityType = "CRS";
    }

    /**
     * Creates a new instance with values initialized from the given GeoAPI object.
     * The subtype is determined by the interface implemented by the given object.
     *
     * @param impl implementation of a GeoAPI object to serialize.
     * @return the POJO to serialize.
     */
    public static CRS create(org.opengis.referencing.crs.CoordinateReferenceSystem impl) {
        return switch (impl) {
            case null -> null;
            case CRS subtype -> subtype;
            case org.opengis.referencing.crs.SingleCRS   subtype -> SingleCRS.create(subtype);
            case org.opengis.referencing.crs.CompoundCRS subtype -> new CompoundCRS(subtype);
            default -> throw new IllegalArgumentException("CRS must be single or compound.");
        };
    }
}
