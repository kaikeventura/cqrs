FROM gradle:jdk11 as build

WORKDIR /app

COPY gradlew settings.gradle ./
COPY gradle ./gradle
COPY build.gradle ./
COPY src ./src

RUN ./gradlew build --no-daemon -x test -x check

FROM openjdk:12-alpine AS release

WORKDIR /app

COPY --from=build /app/build/libs/cqrs-*-SNAPSHOT.jar ./cqrs.jar

ENTRYPOINT java -jar ./cqrs.jar --spring.datasource-write.jdbc-url=jdbc:mysql://mysql-master:3306/cqrs --spring.datasource-read.jdbc-url=jdbc:mysql://mysql-slave:3306/cqrs