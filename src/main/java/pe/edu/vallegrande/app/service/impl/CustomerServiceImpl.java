package pe.edu.vallegrande.app.service.impl;

import pe.edu.vallegrande.app.model.Customer;
import pe.edu.vallegrande.app.repository.CustomerRepository;
import pe.edu.vallegrande.app.service.CustomerService;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.apache.poi.ss.usermodel.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final TemplateEngine templateEngine;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TemplateEngine templateEngine) {
        this.customerRepository = customerRepository;
        this.templateEngine = templateEngine;
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

    // CARGA | IMPORTACION CSV
    @Override
    public Flux<Customer> uploadCsv(FilePart filePart) {
        return DataBufferUtils.join(filePart.content())
                .flatMapMany(buffer -> {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    buffer.asInputStream(),
                                    StandardCharsets.UTF_8));
                    return Flux.fromStream(reader.lines())
                            .skip(1)
                            .map(line -> {
                                String[] values = line.split(",");
                                Customer customer = new Customer();
                                customer.setDni(values[0]);
                                customer.setFirstName(values[1]);
                                customer.setLastName(values[2]);
                                customer.setState(values[3]);
                                return customer;
                            });
                })
                .flatMap(customerRepository::save);
    }

    // EXPORTAR EXCEL
    @Override
    public Mono<byte[]> exportExcel() {
        return customerRepository.findAll()
                .collectList()
                .flatMap(customers ->

                Mono.fromCallable(() -> {

                    Workbook workbook = new XSSFWorkbook();

                    Sheet sheet = workbook.createSheet("Customer");

                    Row header = sheet.createRow(0);

                    header.createCell(0)
                            .setCellValue("DNI");

                    header.createCell(1)
                            .setCellValue("NOMBRE");

                    header.createCell(2)
                            .setCellValue("APELLIDO");

                    header.createCell(3)
                            .setCellValue("ESTADO");

                    int rowNum = 1;

                    for (Customer c : customers) {

                        Row row = sheet.createRow(rowNum++);

                        row.createCell(0)
                                .setCellValue(c.getDni());

                        row.createCell(1)
                                .setCellValue(c.getFirstName());

                        row.createCell(2)
                                .setCellValue(c.getLastName());

                        row.createCell(3)
                                .setCellValue(c.getState());
                    }
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    workbook.write(out);
                    workbook.close();
                    return out.toByteArray();
                }).subscribeOn(
                        Schedulers.boundedElastic()));
    }

    // EXPORTAR PDF
    @Override
    public Mono<byte[]> exportPdf() {
        return customerRepository.findAll()
                .collectList()
                .flatMap(customer ->
                Mono.fromCallable(() -> {
                    Context context = new Context();
                    context.setVariable(
                            "customer",
                            customer);
                    String html = templateEngine.process(
                            "customer",
                            context);
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    PdfRendererBuilder builder = new PdfRendererBuilder();
                    builder.withHtmlContent(
                            html,
                            null);
                    builder.toStream(out);
                    builder.run();
                    return out.toByteArray();
                }).subscribeOn(
                        Schedulers.boundedElastic()));
    }
    

}