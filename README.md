# Spring WebFlux

## **Dependencias Spring WebFlux + MongoDB (NoSQL)**

Spring WebFlux | Data MongoDB Reactive | Project Reactor
```
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
</dependency>
<dependency>
      <groupId>io.projectreactor</groupId>
      <artifactId>reactor-test</artifactId>
      <scope>test</scope>
</dependency>
```

## **Dependencias Spring WebFlux + Postgre (SQL)**

Spring WebFlux | Data R2DBC | Project Reactor | R2DBC PostgreSQL
```
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>
<dependency>
      <groupId>io.projectreactor</groupId>
      <artifactId>reactor-test</artifactId>
      <scope>test</scope>
</dependency>
<dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>r2dbc-postgresql</artifactId>
      <scope>runtime</scope>
</dependency>
```

## **Dependencias Swagger para Spring WebFlux**
```
<dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webflux-ui</artifactId>
      <version>2.0.2</version>
</dependency>
```
