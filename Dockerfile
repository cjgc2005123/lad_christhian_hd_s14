# Primer paso: construir la aplicación Java con Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn --batch-mode -DskipTests package

# Segundo paso: ejecutar solo con el JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/frontend-java-ci-cd-1.0.0.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
