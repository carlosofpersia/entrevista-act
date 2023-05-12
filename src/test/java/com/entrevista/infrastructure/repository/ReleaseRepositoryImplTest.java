package com.entrevista.infrastructure.repository;

import com.entrevista.domain.model.Release;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ReleaseRepositoryImplTest {

    @InjectMocks
    private ReleaseRepositoryImpl releaseRepositoryImpl;

    @Mock
    private EntityManager entityManager;

    @Mock
    TypedQuery<Release> query;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {

        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.merge(new Release()))
                .thenReturn(new Release());

        Release release = releaseRepositoryImpl
                .save(new Release());

        Assert.assertNull(release);
    }

    @Test
    public void statementConsolidated() {

        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.createQuery(" from Release "))
                .thenReturn(query);

        releaseRepositoryImpl = Mockito.mock(ReleaseRepositoryImpl.class);
        List<Release> listRelease = releaseRepositoryImpl
                .statementConsolidated(LocalDate.now());

        Assert.assertNotNull(listRelease);

    }
}