package net.msonic;

import lombok.AllArgsConstructor;
import net.msonic.customers.dto.DocumentType;
import net.msonic.customers.repository.CustomerRepository;
import net.msonic.customers.repository.document.CustomerDocument;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class InitialData implements CommandLineRunner {

    private final CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll().subscribe();

        CustomerDocument d1 = new CustomerDocument();
        d1.setLastName("Messi");
        d1.setFirstName("Lionel");
        d1.setCreateAt(new Date());
        d1.setDocumentType(DocumentType.DNI.getValue());
        d1.setDocumentNumber("11111111");

        CustomerDocument d2 = new CustomerDocument();
        d2.setLastName("Ronaldo");
        d2.setFirstName("Cristiano");
        d2.setCreateAt(new Date());
        d2.setDocumentType(DocumentType.DNI.getValue());
        d2.setDocumentNumber("11111112");

        CustomerDocument d3 = new CustomerDocument();
        d3.setLastName("Emape");
        d3.setFirstName("Gillian");
        d3.setCreateAt(new Date());
        d3.setDocumentType(DocumentType.DNI.getValue());
        d3.setDocumentNumber("11111113");

        List<CustomerDocument> customers = Arrays.asList(d1,d2,d3);

        repository.saveAll(customers).subscribe(System.out::println);;


    }
}
