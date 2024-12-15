# Use an official Maven image to build the application
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests



FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/jpatest-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]