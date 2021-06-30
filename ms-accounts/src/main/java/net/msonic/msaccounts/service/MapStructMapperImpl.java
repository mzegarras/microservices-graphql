package net.msonic.msaccounts.service;

import net.msonic.msaccounts.dto.Account;
import net.msonic.msaccounts.dto.DocumentType;
import net.msonic.msaccounts.dto.Transaction;
import net.msonic.msaccounts.repository.document.AccountDocument;
import net.msonic.msaccounts.repository.document.TransactionDocument;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapperImpl implements  MapStructMapper {
    @Override
    public Account accountToAccountDto(AccountDocument document) {

        if ( document == null ) {
            return null;
        }

        Account account = new Account();
        account.setId(document.getId());
        account.setNumber(document.getNumber());
        account.setAmount(document.getAmount());
        account.setCurrency(document.getCurrency());
        account.setDocument(new DocumentType());
        account.getDocument().setDocumentType(document.getDocument().getDocumentType());
        account.getDocument().setDocumentNumber(document.getDocument().getDocumentNumber());

        return account;


    }

    @Override
    public AccountDocument accountDtoToAccount(Account account) {

        if ( account == null ) {
            return null;
        }

        AccountDocument document = new AccountDocument();
        document.setId(account.getId());
        document.setNumber(account.getNumber());
        document.setAmount(account.getAmount());
        document.setCurrency(account.getCurrency());
        document.setDocument(new net.msonic.msaccounts.repository.document.DocumentType());
        document.getDocument().setDocumentType(account.getDocument().getDocumentType());
        document.getDocument().setDocumentNumber(account.getDocument().getDocumentNumber());

        return document;
    }

    @Override
    public Transaction transactionDocumentToTransactionDto(TransactionDocument document) {

        if ( document == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId(document.getId());
        transaction.setType(document.getType());
        transaction.setDescription(document.getDescription());
        transaction.setDate(document.getDate());
        transaction.setCurrency(document.getCurrency());
        transaction.setAmount(document.getAmount());
        transaction.setAccountId(document.getAccountId());

        return transaction;
    }
}
