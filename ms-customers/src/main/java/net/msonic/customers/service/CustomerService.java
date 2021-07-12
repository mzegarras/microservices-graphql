package net.msonic.customers.service;

import net.msonic.customers.dto.CustomerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<CustomerDto> findAll();
    Mono<CustomerDto> save(CustomerDto customerDto);
    Mono<CustomerDto> findByDocument(String documentType, String documentNumber);
}
