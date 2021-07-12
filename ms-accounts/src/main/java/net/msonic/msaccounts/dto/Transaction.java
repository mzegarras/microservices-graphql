package net.msonic.msaccounts.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private String id;
    private String type;
    private String description;
    private String date;
    private String currency;
    private double amount;
    private String accountId;

}
