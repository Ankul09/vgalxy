# Initialization Base image
FROM amazoncorretto:17
MAINTAINER mayuresh

# Env Setup
EXPOSE 8081
EXPOSE 8091

# Application setup
COPY target/mjdemoapp-1.jar /app.jar

# Application run
CMD java -jar app.jar
