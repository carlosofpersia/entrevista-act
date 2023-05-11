package com.entrevista.api.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReleaseMapper implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("person")
    private PersonMapper person;

    @JsonProperty("cd_type_expense")
    private String cdTypeExpense;

    @JsonProperty("vl_release")
    private BigDecimal vlRelease;

    @JsonProperty("dt_create")
    private LocalDateTime dtCreate = LocalDateTime.now();
}
