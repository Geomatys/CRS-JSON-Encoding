# Web server for CRS-JSON prototype

Build and deploy on the local machine:

```
mvn package
java -jar target/server-1.0-SNAPSHOT.jar
```

The server is accessible on http://localhost:8080 which will redirect
to the HTML file `src/main/resources/static/index.html`.
For requesting a CRS-JSON draft file, visit for example:

```
http://localhost:8080/epsg/2154
```

Replace `2154` by the desired EPSG code.
The code responding to the request is at the following location:

* Class: `src/main/java/com/geomatys/webservice/WebController.java`
* Method: `getEpsg(int)`
```
