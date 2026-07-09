FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/employee-service.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
