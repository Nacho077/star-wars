FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .
RUN gradle bootJar --no-daemon

FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=build /build/libs/star-wars-0.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]