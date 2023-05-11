package com.entrevista.api.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonMapper {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
