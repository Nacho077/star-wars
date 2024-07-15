FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

COPY . .

RUN ./gradlew build

EXPOSE 8080

COPY --from=build /build/libs/sw-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar",  "app.jar"]