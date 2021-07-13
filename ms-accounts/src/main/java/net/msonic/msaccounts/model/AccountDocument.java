package net.msonic.msaccounts.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDocument implements Serializable {

    private static final long serialVersionUID = 1632611924702046046L;

    @Id
    private String id;
    private String number;
    private DocumentType document;
    private String currency;
    private double amount;
    private String avatar;



}


