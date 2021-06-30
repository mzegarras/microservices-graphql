package net.msonic.msaccounts.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private String id;
    private String number;
    private DocumentType document;
    private String currency;
    private double amount;

}
