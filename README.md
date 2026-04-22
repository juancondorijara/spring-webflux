# Spring WebFlux


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


## **Dependencias Utilizadas en Spring WebFlux + MongoDB (NoSQL)**
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
<!-- 🔗🍃 Base de datos MongoDB Reactiva -->
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
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


