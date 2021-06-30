package net.msonic.customers.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.msonic.customers.dto.Customer;
import net.msonic.customers.dto.DocumentType;
import net.msonic.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final MapStructMapper mapper;
    private final CustomerRepository repository;


    @Override
    public Flux<Customer> findAll() {

        log.debug("findAll");

        return repository.findAll()
                .map(document -> mapper.customerToCustomerDto(document));
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        log.debug("save");

        return repository.save(mapper.customerDtoToCustomer(customer))
                .map(document -> mapper.customerToCustomerDto(document));
    }

    @Override
    public Mono<Customer> findByDocument(String documentType,String documentNumber) {
        return repository.findByDocumentTypeAndDocumentNumber(documentType,documentNumber)
                .map(document -> mapper.customerToCustomerDto(document));
    }


}
