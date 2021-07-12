package net.msonic.msaccounts;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.msonic.msaccounts.repository.AccountRepository;
import net.msonic.msaccounts.repository.TransactionRepository;
import net.msonic.msaccounts.model.AccountDocument;
import net.msonic.msaccounts.model.DocumentType;
import net.msonic.msaccounts.model.TransactionDocument;
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

        AccountDocument d1 = AccountDocument.builder()
                    .number("100000001")
                    .currency("1001")
                    .document(DocumentType.builder()
                            .documentType("DNI")
                            .documentNumber("11111111")
                            .build())
                    .build();

        AccountDocument d2 = AccountDocument.builder()
                .number("100000002")
                .currency("1000")
                .document(DocumentType.builder()
                        .documentType("DNI")
                        .documentNumber("11111111")
                        .build())
                .build();


        AccountDocument d3 = AccountDocument.builder()
                .number("100000003")
                .currency("1001")
                .document(DocumentType.builder()
                        .documentType("DNI")
                        .documentNumber("11111112")
                        .build())
                .amount(300d)
                .build();

        AccountDocument d4 = AccountDocument.builder()
                .number("100000004")
                .currency("1001")
                .document(DocumentType.builder()
                        .documentType("DNI")
                        .documentNumber("11111113")
                        .build())
                .amount(400d)
                .build();


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

            TransactionDocument d2_mov01 = TransactionDocument.builder()
                    .currency("1001")
                    .date(sf.format(new Date()))
                    .type("transfer_debit")
                    .currency("10001")
                    .amount((random.nextDouble() * (500 - 100)) + 100)
                    .accountId(document.getNumber())
                    .description("transfer")
                    .build();


            document.setAmount(document.getAmount()+d2_mov01.getAmount());
            transactions.add(d2_mov01);

            /*
            TransactionDocument d2_mov01 = new TransactionDocument();
            d2_mov01.setCurrency("1001");
            d2_mov01.setDate(sf.format(new Date()));
            d2_mov01.setType("transfer_debit");
            d2_mov01.setCurrency("10001");
            d2_mov01.setAmount((random.nextDouble() * (500 - 100)) + 100);
            d2_mov01.setAccountId(document.getNumber());
            d2_mov01.setDescription("transfer");
            document.setAmount(document.getAmount()+d2_mov01.getAmount());*/


        }

    }
}
