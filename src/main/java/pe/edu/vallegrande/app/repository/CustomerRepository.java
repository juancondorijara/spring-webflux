package pe.edu.vallegrande.app.repository;

import pe.edu.vallegrande.app.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    
}
