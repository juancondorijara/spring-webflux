package pe.edu.vallegrande.msreniecsimulator.presentation.controller;

import pe.edu.vallegrande.msreniecsimulator.application.service.PersonService;
import pe.edu.vallegrande.msreniecsimulator.domain.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/persons")
@Tag(name = "Person API", description = "API for managing persons")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @Operation(summary = "Get all persons", description = "Retrieve all persons")
    public Flux<Person> getAllPersons() {
        logger.info("Fetching all persons");
        return personService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get person by ID", description = "Retrieve a person by their ID")
    public Mono<Person> getPersonById(@PathVariable String id) {
        logger.info("Fetching person with ID: {}", id);
        return personService.findById(id);
    }

    @GetMapping("/dni/{dni}")
    @Operation(summary = "Get person by DNI", description = "Retrieve a person by their DNI")
    public Mono<Person> getPersonByDni(@PathVariable String dni) {
        logger.info("Fetching person with DNI: {}", dni);
        return personService.findByDni(dni);
    }

    @PostMapping
    @Operation(summary = "Create a new person", description = "Create a new person")
    public Mono<Person> createPerson(@RequestBody Person person) {
        logger.info("Creating new person: {}", person);
        return personService.save(person);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete person by ID", description = "Delete a person by their ID")
    public Mono<Void> deletePerson(@PathVariable String id) {
        logger.info("Deleting person with ID: {}", id);
        return personService.deleteById(id);
    }
}
