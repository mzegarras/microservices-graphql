package net.msonic.customers.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDocument implements Serializable {

    private static final long serialVersionUID = 5504238253021606174L;

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @EqualsAndHashCode.Exclude
    private Date createAt;




}
