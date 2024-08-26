## COMAND de JAVA 11 A JAVA 17 IN GITPOD
sudo apt update && sudo apt install openjdk-17-jdk -y && export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 && export PATH=$JAVA_HOME/bin:$PATH && java -version && mvn -version

## COMAND GENERATOR ARTIFACT JAVA 
mvn clean install
mvn clean install -DskipTests

## COMAND RUN SPRING JAR
java -jar target/ms-reniec-simulator-0.0.1-SNAPSHOT.jar

## COMAND RUN SPRING NOT JAR
mvn spring-boot:run

## Invocar API
curl -X GET http://localhost:8080/api/persons
curl -X GET http://localhost:8080/api/persons/12
345678

### Add Swagger
http://localhost:8080/swagger-ui.html

-----

## Estándar de Mensajes de Commit

Para mantener un historial claro y útil, seguimos un estándar de etiquetas en nuestros mensajes de commit. Utiliza las siguientes etiquetas al inicio de tus mensajes de commit para indicar la importancia y el tipo de cambio:

- **[LOW]**: Para cambios mínimos o iniciales que no afectan significativamente la funcionalidad del proyecto.
- **[MEDIUM]**: Para cambios que introducen o modifican funcionalidades, o que involucran cambios significativos en las clases.
- **[HIGH]**: Para cambios críticos, como correcciones de errores graves, cambios que afectan múltiples partes del proyecto, o versiones de lanzamiento.

### Ejecutar comando para dar permisos al sh

chmod +x commit.sh && ./commit.sh

### Ejecuta comando para mandar commit 

./commit.sh