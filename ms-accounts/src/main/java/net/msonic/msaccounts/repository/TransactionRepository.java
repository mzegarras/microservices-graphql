package net.msonic.msaccounts.repository;

import net.msonic.msaccounts.model.TransactionDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveMongoRepository<TransactionDocument,String> {


    Flux<TransactionDocument> findByAccountId(String accountId);
}
