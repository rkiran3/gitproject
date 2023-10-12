FROM eclipse-temurin:11

COPY . /usr/src/java-examples

WORKDIR /usr/src/java-examples

ENV CLASSPATH .:src/main/java 

COPY target/JavaExamples-1.0-SNAPSHOT.jar target

CMD ["java", "-cp", "target/JavaExamples-1.0-SNAPSHOT.jar", "com.codewars.Order"]


