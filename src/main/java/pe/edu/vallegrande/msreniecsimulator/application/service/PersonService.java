package pe.edu.vallegrande.msreniecsimulator.application.service;

import pe.edu.vallegrande.msreniecsimulator.domain.model.Person;
import pe.edu.vallegrande.msreniecsimulator.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Flux<Person> findAll() {
        logger.info("Retrieving all persons");
        return personRepository.findAll();
    }

    public Mono<Person> findById(String id) {
        logger.info("Retrieving person with ID: {}", id);
        return personRepository.findById(id);
    }

    public Mono<Person> findByDni(String dni) {
        logger.info("Retrieving person with DNI: {}", dni);
        return personRepository.findByDni(dni);
    }

    public Mono<Person> save(Person person) {
        logger.info("Saving person: {}", person);
        person.setStatus("A");
        return personRepository.save(person);
    }

    public Mono<Void> deleteById(String id) {
        logger.info("Deleting person with ID: {}", id);
        return personRepository.deleteById(id);
    }
}
