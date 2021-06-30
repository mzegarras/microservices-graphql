package net.msonic.msaccounts.service;

import net.msonic.msaccounts.dto.Account;
import net.msonic.msaccounts.dto.DocumentType;
import net.msonic.msaccounts.dto.Transaction;
import reactor.core.publisher.Flux;

public interface AccountService {


    Flux<Account> findAll(DocumentType document);
    Flux<Transaction> findAllTransactions(String accountId);
}
