package net.msonic.msaccounts.service;

import net.msonic.msaccounts.dto.Account;
import net.msonic.msaccounts.dto.Transaction;
import net.msonic.msaccounts.repository.document.AccountDocument;
import net.msonic.msaccounts.repository.document.TransactionDocument;

public interface MapStructMapper {

    Account accountToAccountDto(AccountDocument document);
    AccountDocument accountDtoToAccount(Account account);
    Transaction  transactionDocumentToTransactionDto(TransactionDocument document);
//TransactionDocument
}
