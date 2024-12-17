# Stage 1: Build the application
FROM openjdk:23-jdk AS builder
WORKDIR /app

# Copy Maven wrapper and pom.xml first to leverage Docker layer caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies before copying the application source
RUN ./mvnw dependency:go-offline -B

# Copy the application source and build the JAR
COPY src src
RUN ./mvnw package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:23-jdk
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]