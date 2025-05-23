# Prototype

This directoy contains a prototype written in the Java language.
For building on the command-line (require Apache Maven 3):

```shell
mvn package
```

## Command-line application
This demo provides a `console` command-line (Unix) which expects an implementation to be specified in argument.
The argument is a directory relative to `console` containing the JAR files of a [GeoAPI 3.0](https://www.geoapi.org/) implementation.
This demo has been tested with [Apache SIS](https://sis.apache.org/), [GeoTools](https://github.com/Geomatys/geoapi-gt-wrappers) and
[PROJ](https://github.com/OSGeo/PROJ-JNI) implementations.
For test convenience, the above `mvn package` command collects the Apache SIS files in a `apache-sis` sub-directory.
Therefore, the following command-line works out of the box:

```shell
binding/src/main/shell/console apache-sis
```

After the shell has been launched, use `printCRS(…)` or `printOperation(…)`.
Examples:

```
printCRS("EPSG:4326")
printOperation("EPSG:1188")
```


### Testing with PROJ
[PROJ-JNI](https://github.com/OSGeo/PROJ-JNI) requires a local build
because of Java Native Interface (JNI) codes.
It can be tested as below:

```
cd <any directory>
export PROJ_JNI=$PWD
git clone https://github.com/OSGeo/PROJ-JNI
git checkout 2.0
mvn clean install
cd ..
binding/src/main/shell/console $PROJ_JNI/target
```


## Server application
Deploy on the local machine:

```
java -jar server/target/server-1.0-SNAPSHOT.jar
```

The server is accessible on http://localhost:8080 which will redirect
to the HTML file `server/src/main/resources/static/index.html`.
For requesting a CRS-JSON draft file, visit for example:

```
http://localhost:8080/def/crs/epsg/9.9.1/2154
```

Replace `2154` by the desired EPSG code.
