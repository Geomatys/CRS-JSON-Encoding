# JSON Schemas generated from the ISO 19111 conceptual model

The JSON Schema files in folder `schemas` have been created using [ShapeChange](https://github.com/ShapeChange/ShapeChange).

A schema can be tested on https://www.jsonschemavalidator.net/.
JSON instances for testing can be found in folder `instances`.
In order to validate an instance against a particular definition from the JSON Schema,
add a `$ref`-statement at the end of the schema, like so:

```
...
  },"$ref": "#/$defs/ProjectedCRS"
}
```

ISO 19111 edition 3, draft amendment 2 was used as input.

The encoding rule is based upon the requirements classes from the
[Best Practice for OGC - UML to JSON Encoding Rules (24-017)](https://portal.ogc.org/files/?artifact_id=108010&version=1):

* /req/core
* /req/plain
* /req/by-reference-uri
* /req/union-property-choice
* /req/codelists-literal
* /req/entitytype

Further comments regarding the encoding:

* Default value for association roles is `inlineOrByReference',
  so that experiments can be made with encoding all JSON objects inline (or by reference).
* Since no JSON Schema definitions exist for some of the external schema types used in ISO 19111
  (`MD_Identifier`, `DQ_PositionalAccuracy`, `DirectPosition`, `EX_Extent`, `CI_Citation`, `TM_ReferenceSystem`),
  they have been implemented without specific JSON Schema restrictions.
  Once specific JSON Schema definitions exist for these types, they can be used.
* The documentation of a model element (from the Enterprise Architect notes field)
  is encoded in the `description` annotation of elements in the resulting JSON Schema.
* References to JSON Schema definitions use JSON Pointer, not the anchor based notation.

# Code lists
Code list values are described in XML files following a schema defined by the
[OASIS Genericode standard](https://docs.oasis-open.org/codelist/genericode/v1.0/os/genericode-v1.0-os.html).
Examples:

* [AxisDirections.xml](./schemas/AxisDirections.xml)

JSON parsers do not need to parse those XML documents.
Those XML files are rather for validators, as a complement to JSON schema validators.
Their use may require extra validation performed by OGC-specific software,
but this is already the current practice with CITE tests validating GML documents.

# Model issues

* `GeodeticCRS.coordinateSystem` should be replaced by a constraint that restricts the value type of `SingleCRS.coordinateSystem`.
  In general, value type restrictions of `baseCRS`, `coordinateSystem`, and `datum` should be modeled using constraints.
  * The original model used restrictions modeled as unions.
    It is not possible to represent these restrictions using property-count-conversion of unions in JSON Schema,
    while at the same time satisfying the JSON Schema constraints of the supertype declaration of the restricted property (where no union construct is used).
    Encoding these unions as type discriminator unions will very likely not succeed, because the model of the union options is often very similar
    - which will satisfy more than one of the "oneOf" cases in the resulting JSON Schema component.
    For the time being, **property restrictions using unions have been removed** in the ISO 19111 schema that was used for generating the JSON Schema.
    The missing restrictions cannot be represented in the JSON Schema with the conversion rules defined by the Best Practice document.
* Attribute `operationVersion` should better be modeled in the classes that really do use it.
  Currently, indirect subtype `Conversion` sets multiplicity to exactly 0, so does not use the attribute at all.
  Suggest to model the attribute on `PassThroughOperation`, `ConcatenatedOperation`, `PointMotionOperation` and `Transformation`.
