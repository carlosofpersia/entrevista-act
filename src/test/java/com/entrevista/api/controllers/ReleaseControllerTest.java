package com.entrevista.api.controllers;

import com.entrevista.api.model.input.ReleaseMapper;
import com.entrevista.domain.service.InjectReleasesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class ReleaseControllerTest {

    @InjectMocks
    private ReleaseController releaseController;

    @Mock
    InjectReleasesService injectReleasesService;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void injectValue() {

        injectReleasesService = Mockito.mock(InjectReleasesService.class);
        Mockito.when(injectReleasesService.injectValue(new ReleaseMapper()))
                .thenReturn(new ReleaseMapper());

        ResponseEntity<ReleaseMapper> response = releaseController.injectValue(
                "XXXX"
                , "XXXX"
                , new ReleaseMapper());

        Assert.assertNotNull(response);

    }
}