package pe.edu.vallegrande.app.repository;

import pe.edu.vallegrande.app.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    
}
