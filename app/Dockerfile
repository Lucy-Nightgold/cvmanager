#FROM eclipse-temurin:17-jdk-alpine
#
#WORKDIR /app
#
#COPY . /app/
#
#CMD mvn clean package
#
#CMD java -jar app/target/cvManager-0.0.1-SNAPSHOT.jar
#
#EXPOSE 8080


FROM maven:3.8.7-openjdk-18-slim
WORKDIR /app
COPY pom.xml /app
RUN mvn clean dependency:go-offline


COPY . /app/
CMD mvn spring-boot:run