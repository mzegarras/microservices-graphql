package net.msonic.msaccounts.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.msonic.msaccounts.dto.Account;
import net.msonic.msaccounts.dto.DocumentType;
import net.msonic.msaccounts.dto.Transaction;
import net.msonic.msaccounts.repository.AccountRepository;
import net.msonic.msaccounts.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements  AccountService {

    private final AccountRepository accountRepository;
    private final MapStructMapper mapper;
    private final TransactionRepository transactionRepository;

    @Override
    public Flux<Account> findAll(DocumentType documentType) {
        log.info("findAll");

        net.msonic.msaccounts.repository.document.DocumentType type = new net.msonic.msaccounts.repository.document.DocumentType();
        type.setDocumentType(documentType.getDocumentType());
        type.setDocumentNumber(documentType.getDocumentNumber());

        return accountRepository.findByDocument(type)
                .map(document -> mapper.accountToAccountDto(document));

    }

    @Override
    public Flux<Transaction> findAllTransactions(String accountId) {
        log.info("findAllTransactions %s",accountId);

        return transactionRepository.findByAccountId(accountId)
                .map(transaction -> mapper.transactionDocumentToTransactionDto(transaction));
    }
}
