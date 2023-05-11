package com.entrevista.api.controllers;

import com.entrevista.api.model.input.ReleaseMapper;
import com.entrevista.domain.service.InjectReleasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/release")
public class ReleaseController {

    @Autowired
    private InjectReleasesService injectReleasesService;

    @PostMapping()
    public ResponseEntity<ReleaseMapper> injectValue(
            @RequestHeader(value = "Authorization") String authorization
            , @RequestHeader(value = "x-transaction-id") String xTransactionId
            , @RequestBody ReleaseMapper releaseInput
    ) {

        ReleaseMapper response = injectReleasesService.injectValue(releaseInput);
        return ResponseEntity.ok().body(response);
    }

}
