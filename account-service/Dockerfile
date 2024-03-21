FROM amazoncorretto:17.0.9
## VOLUME for saving data when containers get showdown
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

