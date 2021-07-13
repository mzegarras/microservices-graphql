package net.msonic.msaccounts.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String id;
    private String number;
    private DocumentType document;
    private String currency;
    private double amount;
    private String avatar;

}
