# Prototype

This directoy contains a prototype written in the Java language.
For building on the command-line (require Apache Maven 3):

```shell
mvn package
```

## Command-line application
For testing on a Unix command line (replace `<implementation>` by the absolute
path to a directory containing the JAR files of a GeoAPI implementation):

```shell
binding/src/main/shell/console <implementation>
```

### Testing with Apache SIS
For test convenience, [Apache SIS](https://sis.apache.org/) is available with the following shortcut:

```shell
binding/src/main/shell/console apache-sis
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
