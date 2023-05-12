package com.entrevista.domain.enumarations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class TypePersonEnumTest {

    @InjectMocks
    private TypePersonEnum typePersonEnum;


    @Before
    public void setUp() {
    }

    @Test
    public void getCode() {

        typePersonEnum = TypePersonEnum.FISICA;
        Assert.assertEquals(typePersonEnum.getCode()
                , TypePersonEnum.FISICA.getCode());
    }

    @Test
    public void getEnum() {

        TypePersonEnum type = typePersonEnum
                .getEnum(TypePersonEnum.FISICA.getCode());

        Assert.assertEquals(type.getCode()
                , TypePersonEnum.FISICA.getCode());
    }

}