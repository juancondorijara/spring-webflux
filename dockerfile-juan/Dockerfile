# Stage 1: Build with Maven
FROM juan321/maven:3.9-amazoncorretto-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run with Java
FROM juan321/eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


# CONSTRUIR UNA IMÁGEN MEDIANTE UN Dockerfile EN UNA CARPETA
# docker build -t juan321/webflux-nosql:3.0 -f dockerfile-juan/Dockerfile .

# EJECUTAR LA IMÁGEN GENERADA
# docker run -d --name webflux-nosql -p 8081:8081 juan321/webflux-nosql:3.0

# SUBIR IMÁGEN GENERADA A DOCKERHUB
# docker push juan321/webflux-nosql:3.0


# DESCARGAR, RENOMBRAR Y SUBIR MAVEN A TU USUARIO DOCKERHUB
# docker pull maven:3.9-amazoncorretto-17-alpine
# docker tag 4211aacbdabe juan321/maven:3.9-amazoncorretto-17-alpine
# docker push juan321/maven:3.9-amazoncorretto-17-alpine


# DESCARGAR, RENOMBRAR Y SUBIR JDK17 A TU USUARIO DOCKERHUB
# docker pull eclipse-temurin:17-jre-alpine
# docker tag 88c0002860cd juan321/eclipse-temurin:17-jre-alpine
# docker push juan321/eclipse-temurin:17-jre-alpine


