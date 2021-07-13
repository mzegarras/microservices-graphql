package net.msonic;

import lombok.AllArgsConstructor;
import net.msonic.customers.dto.DocumentType;
import net.msonic.customers.repository.CustomerRepository;
import net.msonic.customers.model.CustomerDocument;
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

        CustomerDocument d1 = CustomerDocument.builder()
                    .lastName("Messi")
                    .firstName("Lionel")
                    .createAt(new Date())
                    .documentType(DocumentType.DNI.getValue())
                    .documentNumber("11111111")
                    .adress("Calle Millonarios 1")
                    .avatar("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=100")
                    .build();

        CustomerDocument d2 = CustomerDocument.builder()
                .lastName("Ronaldo")
                .firstName("Cristiano")
                .createAt(new Date())
                .documentType(DocumentType.DNI.getValue())
                .documentNumber("11111112")
                .adress("Calle Millonarios 2")
                .avatar("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=100")
                .build();

        CustomerDocument d3 = CustomerDocument.builder()
                .lastName("Emape")
                .firstName("Gillian")
                .createAt(new Date())
                .documentType(DocumentType.DNI.getValue())
                .documentNumber("11111113")
                .adress("Calle Millonarios 2")
                .avatar("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=100")
                .build();

        List<CustomerDocument> customers = Arrays.asList(d1,d2,d3);

        repository.saveAll(customers).subscribe(System.out::println);;


    }
}
