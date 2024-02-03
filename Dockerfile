FROM openjdk:17-alpine
MAINTAINER Maruf Hassan
COPY target/geolocation2timezone-*.jar /opt/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]

