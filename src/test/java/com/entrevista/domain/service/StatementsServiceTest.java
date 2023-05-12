package com.entrevista.domain.service;

import com.entrevista.api.model.input.StatementConsolidatedMapper;
import com.entrevista.domain.model.Release;
import com.entrevista.domain.repository.ReleaseRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class StatementsServiceTest {

    @InjectMocks
    private StatementsService statementsService;

    @Mock
    private ReleaseRepository releaseRepository;

    @Mock
    List<Release> listRelelase;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void consolidated() {

        StatementConsolidatedMapper response = statementsService
                .consolidated(LocalDate.now());

        Assert.assertNotNull(response);
    }
}