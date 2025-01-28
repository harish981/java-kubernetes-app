# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/java-kubernetes-app-1.0-SNAPSHOT.jar /app/java-kubernetes-app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "java-kubernetes-app.jar"]
