package com.entrevista;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SpringBootHelloWorldApplicationTest {

    @InjectMocks
    private SpringBootHelloWorldApplication app;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void main() {

        Assert.assertNotNull(app.hashCode());
    }
}