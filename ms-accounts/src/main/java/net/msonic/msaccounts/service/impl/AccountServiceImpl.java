package net.msonic.msaccounts.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.msonic.msaccounts.dto.Account;
import net.msonic.msaccounts.dto.DocumentType;
import net.msonic.msaccounts.dto.Transaction;
import net.msonic.msaccounts.repository.AccountRepository;
import net.msonic.msaccounts.repository.TransactionRepository;
import net.msonic.msaccounts.service.AccountService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Flux<Account> findAll(DocumentType documentType) {

        log.info("findAll {}", documentType.toString());

        net.msonic.msaccounts.model.DocumentType type = new net.msonic.msaccounts.model.DocumentType();
        type.setDocumentType(documentType.getDocumentType());
        type.setDocumentNumber(documentType.getDocumentNumber());

        return accountRepository.findByDocument(type)
                .map(document -> Account.builder()
                            .id(document.getId())
                            .amount(document.getAmount())
                            .currency(document.getCurrency())
                            .document(DocumentType.builder()
                                        .documentNumber(document.getDocument().getDocumentNumber())
                                        .documentType(document.getDocument().getDocumentType())
                                    .build())
                            .build());
    }

    @Override
    public Flux<Transaction> findAllTransactions(String accountId) {
        log.info("findAllTransactions {}",accountId);

        return transactionRepository.findByAccountId(accountId)
                .map(transaction -> Transaction.builder()
                                    .id(transaction.getId())
                                    .type(transaction.getType())
                                    .description(transaction.getDescription())
                                    .date(transaction.getDate())
                                    .currency(transaction.getCurrency())
                                    .amount(transaction.getAmount())
                                    .accountId(transaction.getAccountId())
                                    .build());

    }
}
