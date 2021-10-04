FROM adoptopenjdk/openjdk11:x86_64-ubuntu-jre-11.0.12_7
MAINTAINER Maruf Hassan
COPY target/geolocation2timezone-*.jar /opt/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]

