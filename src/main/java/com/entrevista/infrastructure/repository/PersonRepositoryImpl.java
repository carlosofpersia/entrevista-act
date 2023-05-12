package com.entrevista.infrastructure.repository;

import com.entrevista.api.model.input.PersonMapper;
import com.entrevista.domain.model.Person;
import com.entrevista.domain.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PersonMapper> list() {
        TypedQuery<Person> query = entityManager.createQuery(
                " from Person ", Person.class);
        return modelMapper.map(query.getResultList(), List.class);
    }

    @Override
    public Person getById(Long id) {
        return entityManager.find(Person.class, id);
    }

}
