package net.msonic.customers.service;

import net.msonic.customers.dto.Customer;
import net.msonic.customers.dto.DocumentType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();
    Mono<Customer> save(Customer customer);
    Mono<Customer> findByDocument(String documentType,String documentNumber);
}
