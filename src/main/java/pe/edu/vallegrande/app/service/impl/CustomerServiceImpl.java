package pe.edu.vallegrande.app.service.impl;

import pe.edu.vallegrande.app.model.Customer;
import pe.edu.vallegrande.app.repository.CustomerRepository;
import pe.edu.vallegrande.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Flux<Customer> findAll() {
        log.info("Mostrando datos");
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        log.info("Mostrando datos por ID ");
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        log.info("Registrando datos " + customer.toString());
        customer.setState("A");
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        log.info("Actualizando datos " + customer.toString());
        customer.setState("A");
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> delete(String id) {
        log.info("Delete Customer: " + id);
        return customerRepository.findById(id)
                .flatMap(customer -> {
                    customer.setState("I");
                    return customerRepository.save(customer);
                });
    }

    @Override
    public Mono<Customer> restore(String id) {
        log.info("Restore Customer: " + id);
        return customerRepository.findById(id)
                .flatMap(customer -> {
                    customer.setState("A");
                    return customerRepository.save(customer);
                });
    }

}