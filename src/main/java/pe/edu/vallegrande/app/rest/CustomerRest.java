package pe.edu.vallegrande.app.rest;

import pe.edu.vallegrande.app.model.Customer;
import pe.edu.vallegrande.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Flux<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Customer> save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping ("/update")
    public Mono<Customer> update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

}
