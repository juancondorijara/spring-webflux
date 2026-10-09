package pe.edu.vallegrande.app.service;

import org.springframework.http.codec.multipart.FilePart;

import pe.edu.vallegrande.app.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();

    Mono<Customer> findById(String id);

    Mono<Customer> save(Customer customer);

    Mono<Customer> update(Customer customer);

    Mono<Customer> delete(String id);

    Mono<Customer> restore(String id);

    Flux<Customer> uploadCsv(FilePart filePart);

    Mono<byte[]> exportExcel();

    Mono<byte[]> exportPdf();
    
}