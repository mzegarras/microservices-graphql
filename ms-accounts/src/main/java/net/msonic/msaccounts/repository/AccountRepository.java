package net.msonic.msaccounts.repository;

import net.msonic.msaccounts.repository.document.AccountDocument;
import net.msonic.msaccounts.repository.document.DocumentType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveMongoRepository<AccountDocument,String> {


    Flux<AccountDocument> findByDocument(DocumentType documentType);


}
