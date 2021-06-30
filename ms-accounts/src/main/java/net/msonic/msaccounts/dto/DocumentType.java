package net.msonic.msaccounts.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DocumentType implements Serializable {

    private static final long serialVersionUID = -8173384859073325589L;

    private String documentType;
    private String documentNumber;

}
