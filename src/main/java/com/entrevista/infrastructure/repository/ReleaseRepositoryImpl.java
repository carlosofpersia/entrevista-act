package com.entrevista.infrastructure.repository;

import com.entrevista.domain.model.Release;
import com.entrevista.domain.repository.ReleaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ReleaseRepositoryImpl implements ReleaseRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public Release save(Release release) {
        return entityManager.merge(release);
    }

    @Override
    public List<Release> statementConsolidated(LocalDate localDate) {

        TypedQuery<Release> query = this.entityManager.createQuery(
                " from Release r WHERE r.dtCreate BETWEEN :start AND :end", Release.class);
        query.setParameter("start", localDate.atStartOfDay());
        query.setParameter("end", localDate.plusDays(1).atStartOfDay());
         return query.getResultList();
    }

}
