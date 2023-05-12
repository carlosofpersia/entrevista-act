package com.entrevista.domain.enumarations;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

public class TypeExpenseEnumTest {

    @InjectMocks
    private TypeExpenseEnum typeExpenseEnum;
    @Test
    public void getCode() {

        typeExpenseEnum = TypeExpenseEnum.DEBITO;
        String code = typeExpenseEnum.getCode();
        Assert.assertEquals(code, TypeExpenseEnum.DEBITO.getCode());
    }

    @Test
    public void testDebitoGetEnum() {

        TypeExpenseEnum typeExpense = typeExpenseEnum
                .getEnum(TypeExpenseEnum.DEBITO.getCode());

        Assert.assertEquals(typeExpense.getCode()
                , TypeExpenseEnum.DEBITO.getCode());
    }

}