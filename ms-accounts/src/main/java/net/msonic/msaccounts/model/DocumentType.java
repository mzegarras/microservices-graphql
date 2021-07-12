package net.msonic.msaccounts.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentType implements Serializable {

    private static final long serialVersionUID = -8173384859073325589L;

    private String documentType;
    private String documentNumber;

}
