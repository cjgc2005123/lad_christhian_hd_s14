# Construcción razonada del pom.xml

1. Crear la carpeta raíz y `pom.xml`.
2. Declarar el encabezado XML `<project>` y `<modelVersion>4.0.0</modelVersion>`.
3. Elegir la configuración base: `spring-boot-starter-parent` 3.5.7 para centralizar versiones de plugins y dependencias.
4. Identificar `groupId`, `artifactId` y `version`; son coordenadas GAV.
5. Definir `<java.version>21</java.version>`.
6. Agregar `spring-boot-starter-web`: servidor HTTP embebido y publicación de `static/index.html`.
7. Agregar `spring-boot-starter-test` con scope `test`: JUnit y MockMvc solo para testing.
8. Agregar `spring-boot-maven-plugin`: empaqueta el JAR ejecutable.
9. `mvn validate` -> `mvn clean compile` -> `mvn test` -> `mvn package`.
10. Ejecutar `java -jar target/frontend-java-ci-cd-1.0.0.jar`.

## ¿Por qué no se agrega Bootstrap al POM?
Bootstrap se carga desde una URL en `index.html`; es un recurso del navegador, no una dependencia Java. Para una aplicación sin conexión, descargue los archivos oficiales de Bootstrap y colóquelos dentro de `src/main/resources/static/`.

## ¿Por qué no usamos un controller Java?
Spring Boot sirve automáticamente `index.html` al ingresar en `/` cuando está dentro de `src/main/resources/static/`.
