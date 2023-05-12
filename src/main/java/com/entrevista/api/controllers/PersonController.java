package com.entrevista.api.controllers;

import com.entrevista.api.model.input.PersonMapper;
import com.entrevista.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping()
    public ResponseEntity<List<PersonMapper>> listAll(
            @RequestHeader(value = "Authorization") String authorization
            , @RequestHeader(value = "x-transaction-id") String xTransactionId
    ) {

        List<PersonMapper> response = personRepository.list();
        return ResponseEntity.ok().body(response);
    }

}
