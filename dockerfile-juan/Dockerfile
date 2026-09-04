# Stage 1: Build with Maven
FROM juan321/maven:3.9-amazoncorretto-25-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run with Java
FROM juan321/eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


# CONSTRUIR UNA IMÁGEN MEDIANTE UN Dockerfile EN UNA CARPETA
# docker build -t juan321/springwebflux-mongodb:1.0 -f dockerfile-juan/Dockerfile .
# docker push juan321/springwebflux-mongodb:1.0


# EJECUTAR Y SUBIR TU IMÁGEN GENERADA A DOCKERHUB
# docker run -d --name springwebflux-mongodb -p 8085:8085 juan321/springwebflux-mongodb:1.0
# docker push juan321/springwebflux-mongodb:1.0


# DESCARGAR Y SUBIR MAVEN A TU USUARIO DOCKERHUB
# docker pull maven:3.9-amazoncorretto-25-alpine
# docker tag 2246c1050783 juan321/maven:3.9-amazoncorretto-25-alpine
# docker push juan321/maven:3.9-amazoncorretto-25-alpine


# DESCARGAR Y SUBIR JDK25 A TU USUARIO DOCKERHUB
# docker pull eclipse-temurin:25-jre-alpine
# docker tag 5fcc27581b23 juan321/eclipse-temurin:25-jre-alpine
# docker push juan321/eclipse-temurin:25-jre-alpine


# EJECUTAR UN CONTENEDOR MONGODB MEDIANTE COMANDO
# docker run -d --name mongodb -p 27017:27017 -v mongodb_data:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin12345 juan321/mongo:8