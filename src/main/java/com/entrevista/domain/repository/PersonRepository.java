package com.entrevista.domain.repository;

import com.entrevista.api.model.input.PersonMapper;
import com.entrevista.domain.model.Person;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository {

    List<PersonMapper> list();

    Person getById(Long id);

}
