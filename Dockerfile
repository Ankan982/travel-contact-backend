FROM maven:3.8.5-openjdk-17 AS build

COPY . .

ENV MONGO_DB_CRED="mongodb+srv://Ankandas:ankanDasDB@traveltestcluster.gyiah9g.mongodb.net/?retryWrites=true&w=majority&appName=TravelTestCluster"
ENV MONGO_DB_TABLE="t_contact"

RUN mvn clean package


FROM openjdk:17-jdk-slim

COPY --from=build target/*.jar contact_ms.jar

ENTRYPOINT ["java", "-jar", "contact_ms.jar"]
