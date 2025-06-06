FROM maven:3.8.5-openjdk-17 AS build

COPY . .
RUN mvn clean package


FROM openjdk:17-jdk-slim

COPY --from=build target/*.jar contact_ms.jar

ENTRYPOINT ["java", "-jar", "contact_ms.jar"]
