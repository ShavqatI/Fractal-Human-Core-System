# Stage 1: Build
#FROM maven:3.9.4-eclipse-temurin-21 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8585
ENTRYPOINT ["java", "-jar", "app.jar"]


#docker build -t fractal-human-core-system .
#docker tag fractal-human-core-system proximuscentavr/fractal-human-core-system:latest
#docker login
#docker push proximuscentavr/fractal-human-core-system:latest

# for ICB

#docker build -t icb-backend-human-core-system .
#docker tag icb-backend-human-core-system proximuscentavr/icb-backend-human-core-system:latest
#docker login
#docker push proximuscentavr/icb-backend-human-core-system:latest