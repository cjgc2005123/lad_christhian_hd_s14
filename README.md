# LABORATORIO 03: Frontend Java, Maven, .gitignore, GitHub y Cloud Run

## Meta
Publicar **una sola página index.html** con Java y Spring Boot. Construir manualmente `pom.xml` y `.gitignore`, comprobar con pruebas JUnit y publicar el código en GitHub antes de desplegar a Cloud Run.

## Abrir y ejecutar desde VS Code (Windows PowerShell)

Requisitos: JDK 21 y Maven 3.9.x, Git y VS Code.

```powershell
java -version
mvn -version
mvn validate
mvn clean test
mvn spring-boot:run
```

Abrir http://localhost:8080 y presionar el botón. Detener el servidor con Ctrl+C.

Para empaquetar:

```powershell
mvn clean package
java -jar target/frontend-java-ci-cd-1.0.0.jar
```

## Archivos que el estudiante construye

- `pom.xml`: identidad GAV, Java 21, dependencia web, dependencia de pruebas y plugin de empaquetado.
- `.gitignore`: excluye `target/`, archivos sensibles y configuraciones locales.
- `index.html`: interfaz Bootstrap sencilla.
- `FrontendApplication.java`: inicia el servidor web.
- `FrontendApplicationTest.java`: pruebas de que la página existe y tiene título y botón.
- `.github/workflows/ci-java.yml`: ejecuta Maven en GitHub Actions.
- `Dockerfile`: permite desplegar exactamente la aplicación Java a Cloud Run.

## Actividades por orden

1. Revisar [cómo construir el POM](docs/CREAR_POM_PASO_A_PASO.md).
2. Revisar [cómo construir .gitignore](docs/CREAR_GITIGNORE_PASO_A_PASO.md).
3. Ejecutar `mvn clean test` y observar 3 tests.
4. Ejecutar la página en el navegador.
5. Verificar `git check-ignore -v target/demo.class`.
6. Publicar en GitHub y revisar la pestaña Actions.
7. Seguir [GitHub y Cloud Run](docs/GITHUB_Y_CLOUDRUN.md).

## Evaluación sugerida (20 puntos)

- Estructura y POM explicados: 5 puntos.
- Justificación y comprobación de gitignore: 5 puntos.
- Página y pruebas locales: 4 puntos.
- Github Actions verde y evidencia: 3 puntos.
- Despliegue Cloud Run y URL funcionando: 3 puntos.

## Advertencia
Vertex AI no es hosting genérico. Cloud Run aloja la aplicación Java; Vertex AI se puede usar después para agregar funciones de IA.
