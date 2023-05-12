package com.entrevista.core.modelmapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;

public class ModelMapperConfigTest {

    @InjectMocks
    private ModelMapperConfig modelMapperConfig;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void modelMapper() {

        ModelMapper modelMapper = modelMapperConfig.modelMapper();
        Assert.assertNotNull(modelMapper);
    }
}