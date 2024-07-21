# Stage 1: Build the application
FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /usr/app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/springstarter-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/app/${JAR_FILE} /app/runner.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/runner.jar"]
