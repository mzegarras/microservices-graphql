package net.msonic.customers.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private DocumentType documentType;
    private String documentNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @EqualsAndHashCode.Exclude
    private Date createAt;

}

