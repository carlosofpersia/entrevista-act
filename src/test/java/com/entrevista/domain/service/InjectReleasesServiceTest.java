package com.entrevista.domain.service;

import com.entrevista.api.model.input.ReleaseMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class InjectReleasesServiceTest {

    @InjectMocks
    private InjectReleasesService injectReleasesService;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void injectValue() {

        injectReleasesService = Mockito.mock(InjectReleasesService.class);

        ReleaseMapper releaseMapper = injectReleasesService
                .injectValue(new ReleaseMapper());

        Assert.assertNull(releaseMapper);
    }
}