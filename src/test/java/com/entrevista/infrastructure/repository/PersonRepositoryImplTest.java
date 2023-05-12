package com.entrevista.infrastructure.repository;

import com.entrevista.api.model.input.PersonMapper;
import com.entrevista.domain.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonRepositoryImplTest {

    @InjectMocks
    private PersonRepositoryImpl personRepositoryImpl;

    @Mock
    private EntityManager entityManager;

    @Mock
    TypedQuery<Person> query;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void list() {

        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.createQuery(" from Release "))
                .thenReturn(query);

        personRepositoryImpl = Mockito.mock(PersonRepositoryImpl.class);
        List<PersonMapper> person = personRepositoryImpl.list();
        Assert.assertNotNull(person);
    }

    @Test
    public void getById() {

        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(Person.class, 1L))
                .thenReturn(new Person());

        personRepositoryImpl = Mockito.mock(PersonRepositoryImpl.class);
        Person person = personRepositoryImpl.getById(2L);
        Assert.assertNull(person);
    }
}