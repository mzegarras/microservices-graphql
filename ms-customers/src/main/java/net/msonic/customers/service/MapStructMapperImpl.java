package net.msonic.customers.service;

import net.msonic.customers.dto.Customer;
import net.msonic.customers.dto.DocumentType;
import net.msonic.customers.repository.document.CustomerDocument;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public Customer customerToCustomerDto(CustomerDocument customerDocument) {

        if ( customerDocument == null ) {
            return null;
        }

        Customer customer = new Customer();
        customer.setId(customerDocument.getId());
        customer.setFirstName(customerDocument.getFirstName());
        customer.setLastName(customerDocument.getLastName());
        customer.setCreateAt(customerDocument.getCreateAt());
        customer.setDocumentType(DocumentType.valueOf(customerDocument.getDocumentType()));
        customer.setDocumentNumber(customerDocument.getDocumentNumber());
        return customer;
    }

    @Override
    public CustomerDocument customerDtoToCustomer(Customer customer) {

        if ( customer == null ) {
            return null;
        }

        CustomerDocument customerDocument = new CustomerDocument();
        customerDocument.setId(customer.getId());
        customerDocument.setFirstName(customer.getFirstName());
        customerDocument.setLastName(customer.getLastName());
        customerDocument.setCreateAt(customer.getCreateAt());
        customerDocument.setDocumentType(customer.getDocumentType().getValue());
        customerDocument.setDocumentNumber(customer.getDocumentNumber());

        return customerDocument;
    }
}
