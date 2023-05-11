package com.entrevista.api.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class StatementConsolidatedMapper implements Serializable {

    @JsonProperty("dt_selected")
    private LocalDate dtSelected;

    @JsonProperty("vl_consolidated")
    private BigDecimal vlConsolidated;
}
