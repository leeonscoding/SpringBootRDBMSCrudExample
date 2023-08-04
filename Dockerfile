FROM eclipse-temurin:17-jdk-jammy

VOLUME /tmp

VOLUME /docker/logs:/docker/logs

COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080
