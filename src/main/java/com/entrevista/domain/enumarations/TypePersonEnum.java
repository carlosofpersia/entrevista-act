package com.entrevista.domain.enumarations;

import java.util.Arrays;

public enum TypePersonEnum {

    FISICA ("F", "FISICA", "Pessoa Física"),

    JURIDICA ("J", "JURIDICA", "Pessoa Jurídica");

    private String code;

    private String value;

    private String description;

    TypePersonEnum(String code, String value, String description) {
        this.code = code;
        this.value = value;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public static TypePersonEnum getEnum(String code) {
        return Arrays.stream(values())
                .filter(o -> o.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown code: " + code));
    }
}
