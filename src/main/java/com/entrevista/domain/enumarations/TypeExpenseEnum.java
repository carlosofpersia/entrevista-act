package com.entrevista.domain.enumarations;

import java.util.Arrays;

public enum TypeExpenseEnum {

    CREDITO("C", "CREDITO", "Saída de dinheiro"),

    DEBITO("D", "DEBITO", "Entrada de dinheiro");

    private String code;

    private String value;

    private String description;

    TypeExpenseEnum(String code, String value, String description) {
        this.code = code;
        this.value = value;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public static TypeExpenseEnum getEnum(String code) {
        return Arrays.stream(values())
                .filter(o -> o.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown code: " + code));
    }

}