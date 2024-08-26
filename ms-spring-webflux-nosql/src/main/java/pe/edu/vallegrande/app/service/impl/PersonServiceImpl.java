package pe.edu.vallegrande.app.service.impl;

import pe.edu.vallegrande.app.model.Person;
import pe.edu.vallegrande.app.repository.PersonRepository;
import pe.edu.vallegrande.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public ContentModeratorServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Flux<Person> findAll() {
        log.info("Mostrando datos");
        return personRepository.findAll();
    }

    @Override
    public Mono<Person> findById(String id) {
        log.info("Mostrando datos por ID ");
        return personRepository.findAll(id);
    }

    @Override
    public Mono<Person> save(Person person) {
        log.info("Registrando datos " + person.toString());
        return personRepository.save(person);
    }

    @Override
    public Mono<Person> update(Person person) {
        log.info("Actualizando datos " + person.toString());
        return personRepository.save(person);
    }

    @Override
    public Mono<ResponseEntity<Person>> delete(String id) {
        log.info("Eliminado = " + id);
        return personRepository.findById(id).flatMap(newContentModerator -> {
            newContentModerator.setActive("I");
            return contentModeratorRepository.save(newContentModerator);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Person>> restore(String id) {
        log.info("Restaurado = " + id);
        return personRepository.findById(id).flatMap(newContentModerator -> {
            newContentModerator.setActive("A");
            return contentModeratorRepository.save(newContentModerator);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }


}