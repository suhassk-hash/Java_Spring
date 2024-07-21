#
# Build stage
#
FROM eclipse-temurin:17-jdk-jammy AS build
ENV HOME=/usr/app
WORKDIR $HOME
COPY . $HOME


#
# Package stage
#
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=/usr/app/target/*.jar
COPY --from=build $JAR_FILE /app/runner.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/runner.jar"]
