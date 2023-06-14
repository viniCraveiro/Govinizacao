FROM azul/zulu-openjdk-alpine:17.0.4.1-17.36.17
COPY target/govinizacao-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
