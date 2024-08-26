package pe.edu.vallegrande.app.rest;

import pe.edu.vallegrande.app.service.PersonService;
import pe.edu.vallegrande.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/persons")
public class PersonRest {

    private final PersonService personService;

    @Autowired
    public PersonRest(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Flux<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Person> findById(@PathVariable String id) {
        return personService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Person> save(@RequestBody Person person) {
        return personService.save(person);
    }

    @PostMapping("/update")
    public Mono<Person> update(@RequestBody Person person) {
        return personService.update(person);
    }

    @PostMapping("/delete/{id}")
    public Mono<ResponseEntity<Person>> delete(@PathVariable String id) { 
        return personService.delete(id); }

    @PostMapping("/restore/{id}")
    public Mono<ResponseEntity<Person>> restore(@PathVariable String id){ 
        return personService.restore(id); }

}
