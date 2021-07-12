package net.msonic.customers.repository;

import net.msonic.customers.model.CustomerDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface CustomerRepository extends ReactiveMongoRepository<CustomerDocument,String> {


    Mono<CustomerDocument> findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);

}
