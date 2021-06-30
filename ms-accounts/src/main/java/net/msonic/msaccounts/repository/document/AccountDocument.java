package net.msonic.msaccounts.repository.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "accounts")
@Getter
@Setter
public class AccountDocument implements Serializable {

    private static final long serialVersionUID = 1632611924702046046L;

    @Id
    private String id;
    private String number;
    private DocumentType document;
    private String currency;
    private double amount;



}


