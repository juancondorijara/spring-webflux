package pe.edu.vallegrande.msreniecsimulator.domain.repository;

import pe.edu.vallegrande.msreniecsimulator.domain.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

    Mono<Person> findByDni(String dni);
    
}
