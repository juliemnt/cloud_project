FROM openjdk:17-oracle
MAINTAINER baeldung.com
COPY build/libs/student_server-0.0.1-SNAPSHOT.jar student_server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/student_server-0.0.1-SNAPSHOT.jar"]