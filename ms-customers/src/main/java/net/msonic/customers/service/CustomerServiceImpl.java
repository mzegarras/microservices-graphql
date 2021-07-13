package net.msonic.customers.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.msonic.customers.dto.CustomerDto;
import net.msonic.customers.dto.DocumentType;
import net.msonic.customers.model.CustomerDocument;
import net.msonic.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;


    @Override
    public Flux<CustomerDto> findAll() {

        log.info("findAll");

        return repository.findAll()
                .map(document -> CustomerDto.builder()
                            .id(document.getId())
                            .firstName(document.getFirstName())
                            .lastName(document.getLastName())
                            .createAt(document.getCreateAt())
                            .adress(document.getAdress())
                            .documentType(DocumentType.valueOf(document.getDocumentType()))
                            .documentNumber(document.getDocumentNumber())
                        .build());
    }

    @Override
    public Mono<CustomerDto> save(CustomerDto customerDto) {
        log.info("save");


        CustomerDocument customerDocument = CustomerDocument.builder()
                                            .id(customerDto.getId())
                                            .firstName(customerDto.getFirstName())
                                            .lastName(customerDto.getLastName())
                                            .createAt(customerDto.getCreateAt())
                                            .documentType(customerDto.getDocumentType().getValue())
                                            .documentNumber(customerDto.getDocumentNumber())
                                            .adress(customerDto.getAdress())
                                            .build();

        return repository.save(customerDocument)
                .map(customerSaved -> CustomerDto.builder()
                                                .id(customerSaved.getId())
                                                .firstName(customerSaved.getFirstName())
                                                .lastName(customerSaved.getLastName())
                                                .createAt(customerSaved.getCreateAt())
                                                .adress(customerDto.getAdress())
                                                .documentType(DocumentType.valueOf(customerSaved.getDocumentType()))
                                                .documentNumber(customerSaved.getDocumentNumber())
                                            .build());

    }

    @Override
    public Mono<CustomerDto> findByDocument(String documentType, String documentNumber) {
        log.info("findByDocument: {} {}",documentType,documentNumber);

        return repository.findByDocumentTypeAndDocumentNumber(documentType,documentNumber)
                .map(document -> CustomerDto.builder()
                        .id(document.getId())
                        .firstName(document.getFirstName())
                        .lastName(document.getLastName())
                        .createAt(document.getCreateAt())
                        .documentType(DocumentType.valueOf(document.getDocumentType()))
                        .documentNumber(document.getDocumentNumber())
                        .adress(document.getAdress())
                        .build());
    }


}
