# Use the official OpenJDK image for Java 17
FROM openjdk:17-oracle

# Indicate the volume point to persist data
VOLUME /tmp

# Add the application's jar to the container
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]

# Expose the port the app runs on
EXPOSE 8080