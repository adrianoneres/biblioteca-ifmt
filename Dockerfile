FROM openjdk:17.0.1

VOLUME /tmp

COPY ./build/libs/biblioteca-0.0.1-SNAPSHOT.jar biblioteca-0.0.1-SNAPSHOT.jar

ENV DATABASE_URL=jdbc:postgresql://localhost:5433/biblioteca-ifmt
ENV DATABASE_USERNAME=postgres
ENV DATABASE_PASSWORD=postgres

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "biblioteca-0.0.1-SNAPSHOT.jar"]