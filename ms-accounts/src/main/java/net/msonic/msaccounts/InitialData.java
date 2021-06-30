package net.msonic.msaccounts;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.msonic.msaccounts.repository.AccountRepository;
import net.msonic.msaccounts.repository.TransactionRepository;
import net.msonic.msaccounts.repository.document.AccountDocument;
import net.msonic.msaccounts.repository.document.DocumentType;
import net.msonic.msaccounts.repository.document.TransactionDocument;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class InitialData implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {

        accountRepository.deleteAll().subscribe();
        transactionRepository.deleteAll().subscribe();

        AccountDocument d1 = new AccountDocument();
        d1.setNumber("100000001");
        d1.setDocument(new DocumentType());
        d1.setCurrency("1001");
        d1.getDocument().setDocumentType("DNI");
        d1.getDocument().setDocumentNumber("11111111");
        d1.setAmount(0);

        AccountDocument d2 = new AccountDocument();
        d2.setNumber("100000002");
        d2.setDocument(new DocumentType());
        d2.setCurrency("1000");
        d2.getDocument().setDocumentType("DNI");
        d2.getDocument().setDocumentNumber("11111111");
        d2.setAmount(0);


        AccountDocument d3 = new AccountDocument();
        d3.setNumber("100000003");
        d3.setDocument(new DocumentType());
        d3.setCurrency("1001");
        d3.getDocument().setDocumentType("DNI");
        d3.getDocument().setDocumentNumber("11111112");
        d3.setAmount(300d);

        AccountDocument d4= new AccountDocument();
        d4.setNumber("100000004");
        d4.setDocument(new DocumentType());
        d4.setCurrency("1001");
        d4.getDocument().setDocumentType("DNI");
        d4.getDocument().setDocumentNumber("11111113");
        d4.setAmount(400d);

        List<AccountDocument> accounts = Arrays.asList(d1,d2,d3,d4);
        List<TransactionDocument> transactions = new ArrayList<>();

        generateTrasanctions(d1,transactions);
        generateTrasanctions(d2,transactions);
        generateTrasanctions(d3,transactions);
        generateTrasanctions(d4,transactions);

        accountRepository
                .saveAll(accounts)
                .subscribe(account->{
                            //generateTrasanctions(account,transactions);
                        },
                        throwable -> {},
                        () -> {
                            transactionRepository.saveAll(transactions).subscribe(System.out::println);
                        });
    }

    public void generateTrasanctions(AccountDocument document,List<TransactionDocument> transactions){

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Random random = new Random();


        for (int i = 0; i < 10; i++) {
            TransactionDocument d2_mov01 = new TransactionDocument();
            d2_mov01.setCurrency("1001");
            d2_mov01.setDate(sf.format(new Date()));
            d2_mov01.setType("transfer_debit");
            d2_mov01.setCurrency("10001");
            d2_mov01.setAmount((random.nextDouble() * (500 - 100)) + 100);
            d2_mov01.setAccountId(document.getNumber());
            d2_mov01.setDescription("transfer");
            document.setAmount(document.getAmount()+d2_mov01.getAmount());

            transactions.add(d2_mov01);
        }

    }
}
