FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app

# Copy the Maven project files and dependencies
COPY pom.xml .
COPY src ./src

# Download dependencies and build the project
RUN mvn clean package -DskipTests

# Second stage: Create a lightweight image for just running the app
FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
