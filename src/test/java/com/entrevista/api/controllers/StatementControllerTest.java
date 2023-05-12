package com.entrevista.api.controllers;

import com.entrevista.api.model.input.StatementConsolidatedMapper;
import com.entrevista.domain.service.StatementsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class StatementControllerTest {

    @InjectMocks
    private StatementController statementController;

    @Mock
    private StatementsService statementsService;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConsolidated() {

        LocalDate dtSelected = LocalDate.now();

        statementsService = Mockito.mock(StatementsService.class);
        Mockito.when(statementsService.consolidated(dtSelected))
                .thenReturn(new StatementConsolidatedMapper());

        ResponseEntity<StatementConsolidatedMapper> reponse = statementController
                .consolidated("XXXX"
                , "XXXX"
                , dtSelected);

        Assert.assertNotNull(reponse);
    }
}