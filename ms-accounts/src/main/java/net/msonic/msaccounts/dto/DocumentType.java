package net.msonic.msaccounts.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType implements Serializable {

    private static final long serialVersionUID = -8173384859073325589L;

    private String documentType;
    private String documentNumber;

}
