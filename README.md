# Spring WebFlux + PostgreSQL (SQL)


## 📁 Estructura de Carpetas

```text
🍃 PROJECT/
├── 📁 .idea/
├── 📁 .mvn/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/pe/edu/vallegrande/project
│   │   │   ├── 📁 model/
│   │   │   ├── 📁 repository/
│   │   │   ├── 📁 rest/
│   │   │   └── 📁 service/
│   │   ├── 📄 ProjectApplication.java
│   │   └── 📁 resources/
│   │       ├── 📁 sql/schema.sql
│   │       ├── 📁 sql/data.sql
│   │       └── 📄 application.yml
│   └── 📁 test/
├── 📁 target/
├── 📄 .gitattributes
├── 📄 .gitignore
├── 📄 HELP.md
├── 📄 mvnw
├── 📄 mvnw.cmd
├── 📄 pom.xml
└── 📄 README.md
````


## 🔗 Dependencias Utilizadas en Spring WebFlux + PostgreSQL (SQL)
```
<!-- 🔗🔄 Reactivo (WebFlux) -->
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<!-- 🔗🔄 Reactivo (Reactor) -->
<dependency>
      <groupId>io.projectreactor</groupId>
      <artifactId>reactor-test</artifactId>
      <scope>test</scope>
</dependency>
<!-- 🔗✅ Data R2DBC -->
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>
<!-- 🔗✅ Base de datos PostgreSQL Reactiva -->
<dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>r2dbc-postgresql</artifactId>
      <scope>runtime</scope>
</dependency>
<!-- 🔗✅⚡ Optimización con Lombok -->
<dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
</dependency>
<!-- 🔗✅📘 Documentación con Swagger/OpenAPI -->
<dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webflux-ui</artifactId>
      <version>2.8.15</version>
</dependency>
```


## 🧪 Ejecución del Proyecto Spring Boot

* **Opción 1:** `ProjectApplication.java`, archivo principal para ejecutar e iniciar el proyecto en la ruta:

```bash
🍃 PROJECT/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/pe/edu/vallegrande/project
│   │   │   ├── 📁 model/
│   │   │   ├── 📁 repository/
│   │   │   ├── 📁 rest/
│   │   │   └── 📁 service/
│   │   ├── 📄 ProjectApplication.java
````

* **Opción 2:** a nivel de terminal con Maven, ubicandose dentro del directorio del proyecto:

```bash
mvn spring-boot:run
````

# Endpoint del proyecto Spring Boot

* **Opción 1:** __[http://localhost:8082/v1/api/customer](http://localhost:8082/v1/api/customer)__

* **Opción 2:** __[http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)__

* **Resultado:**
```bash
[
  {
    "id": 1,
    "dni": "12345678",
    "firstName": "Juan",
    "lastName": "Sanchez",
    "state": "A"
  }
]
````


