package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface PersonService {

    Flux<Person> findAll();

    Mono<Person> findById(String id);

    Mono<Person> save(Person person);

    Mono<Person> update(Person person);

    Mono<ResponseEntity<Person>> delete(String id);

    Mono<ResponseEntity<Person>> restore(String id);
    
}