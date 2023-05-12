package com.entrevista.api.controllers;

import com.entrevista.api.model.input.PersonMapper;
import com.entrevista.domain.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;

public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listAll() {

        personRepository = Mockito.mock(PersonRepository.class);
        Mockito.when(personRepository.list())
                .thenReturn(new LinkedList<PersonMapper>());

        ResponseEntity<List<PersonMapper>> listPerson = personController.listAll(
                "XXXX"
                , "XXXX");

        Assert.assertNotNull(listPerson);
    }
}