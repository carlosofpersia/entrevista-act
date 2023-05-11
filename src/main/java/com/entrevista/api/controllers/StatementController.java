package com.entrevista.api.controllers;

import com.entrevista.api.model.input.StatementConsolidatedMapper;
import com.entrevista.domain.service.StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/statement")
public class StatementController {

    @Autowired(required = true)
    private StatementsService statementsService;

    @GetMapping("/consolidated/{date}")
    public ResponseEntity<StatementConsolidatedMapper> consolidated(
            @RequestHeader(value = "Authorization") String authorization
            , @RequestHeader(value = "x-transaction-id") String xTransactionId
            , @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate
    ) {

        StatementConsolidatedMapper response = statementsService.consolidated(localDate);
        return ResponseEntity.ok().body(response);
    }
}
