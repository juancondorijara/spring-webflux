# Stage 1: Build with Maven
FROM maven:3.9-amazoncorretto-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run with Java
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


# docker build -t juan321/webflux-nosql:1.0 .
# docker build -t juan321/webflux-nosql:2.0 .

# docker run -d --name webflux-nosql -p 8081:8081 juan321/webflux-nosql:1.0
# docker run -d --name webflux-nosql -p 8081:8081 juan321/webflux-nosql:2.0

# docker push juan321/webflux-nosql:1.0
# docker push juan321/webflux-nosql:2.0

