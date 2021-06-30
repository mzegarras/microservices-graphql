package net.msonic.customers.dto;

import lombok.Getter;

@Getter
public enum DocumentType {

    DNI("DNI"),
    CE("CE");

    private String value;

    DocumentType(String value){
        this.value = value;
    }

}
