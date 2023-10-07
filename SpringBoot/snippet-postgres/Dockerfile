FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY target/sandbox-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
