package net.msonic.msaccounts.repository.document;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "transactions")
@Getter
@Setter
public class TransactionDocument implements Serializable {

    private static final long serialVersionUID = 4064171862724231847L;

    @Id
    private String id;
    private String type;
    private String description;
    private String date;
    private String currency;
    private double amount;
    private String accountId;
}
