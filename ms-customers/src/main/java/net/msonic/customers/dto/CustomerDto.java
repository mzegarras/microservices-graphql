package net.msonic.customers.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private String id;
    private String firstName;
    private String lastName;
    private DocumentType documentType;
    private String documentNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @EqualsAndHashCode.Exclude
    private Date createAt;

}

