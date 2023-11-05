# Use an official Maven image as the build environment
FROM maven:3.9.5-amazoncorretto-21 as builder

# Set the working directory in the container to /app
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Build your Maven application
RUN mvn clean package -DskipTests

# Create a runtime environment using AdoptOpenJDK
FROM openjdk:21-slim

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file from the build environment to the runtime environment
COPY --from=builder /app/target/spring-boot-jpa-postgresql-*.jar /spring-boot-jpa-postgresql.jar
EXPOSE 9050

# Set the entry point for your application
ENTRYPOINT java -jar /spring-boot-jpa-postgresql.jar
