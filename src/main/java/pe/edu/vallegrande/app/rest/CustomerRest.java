package pe.edu.vallegrande.app.rest;

import pe.edu.vallegrande.app.model.Customer;
import pe.edu.vallegrande.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/customer")
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

    @PatchMapping("/delete/{id}")
    public Mono<Customer> delete(@PathVariable String id) {
        return customerService.delete(id);
    }

    @PatchMapping("/restore/{id}")
    public Mono<Customer> restore(@PathVariable String id) {
        return customerService.restore(id);
    }

    @PostMapping(value = "/upload/csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Flux<Customer> uploadCsv(
            @RequestPart("file") FilePart file) {
        return customerService.uploadCsv(file);
    }

    @GetMapping("/export/excel")
    public Mono<ResponseEntity<byte[]>> exportExcel() {
        return customerService.exportExcel()
                .map(file ->
                        ResponseEntity.ok()
                                .header(
                                        HttpHeaders.CONTENT_DISPOSITION,
                                        "attachment; filename=customers.xlsx")
                                .body(file));
    }

    @GetMapping("/export/pdf")
    public Mono<ResponseEntity<byte[]>> exportPdf() {
        return customerService.exportPdf()
                .map(file ->
                        ResponseEntity.ok()
                                .header(
                                        HttpHeaders.CONTENT_DISPOSITION,
                                        "attachment; filename=customer.pdf")
                                .contentType(
                                        MediaType.APPLICATION_PDF)
                                .body(file));
    }


}
