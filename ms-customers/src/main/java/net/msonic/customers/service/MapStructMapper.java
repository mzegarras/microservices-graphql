package net.msonic.customers.service;

import net.msonic.customers.dto.Customer;
import net.msonic.customers.repository.document.CustomerDocument;

public interface MapStructMapper {

    Customer customerToCustomerDto(CustomerDocument customerDocument);
    CustomerDocument customerDtoToCustomer(Customer customer);

}
