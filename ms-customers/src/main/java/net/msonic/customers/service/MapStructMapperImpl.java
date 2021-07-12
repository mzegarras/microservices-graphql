package net.msonic.customers.service;

import net.msonic.customers.dto.CustomerDto;
import net.msonic.customers.dto.DocumentType;
import net.msonic.customers.model.CustomerDocument;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public CustomerDto customerToCustomerDto(CustomerDocument customerDocument) {

        if ( customerDocument == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerDocument.getId());
        customerDto.setFirstName(customerDocument.getFirstName());
        customerDto.setLastName(customerDocument.getLastName());
        customerDto.setCreateAt(customerDocument.getCreateAt());
        customerDto.setDocumentType(DocumentType.valueOf(customerDocument.getDocumentType()));
        customerDto.setDocumentNumber(customerDocument.getDocumentNumber());
        return customerDto;
    }

    @Override
    public CustomerDocument customerDtoToCustomer(CustomerDto customerDto) {

        if ( customerDto == null ) {
            return null;
        }

        CustomerDocument customerDocument = new CustomerDocument();
        customerDocument.setId(customerDto.getId());
        customerDocument.setFirstName(customerDto.getFirstName());
        customerDocument.setLastName(customerDto.getLastName());
        customerDocument.setCreateAt(customerDto.getCreateAt());
        customerDocument.setDocumentType(customerDto.getDocumentType().getValue());
        customerDocument.setDocumentNumber(customerDto.getDocumentNumber());

        return customerDocument;
    }
}
