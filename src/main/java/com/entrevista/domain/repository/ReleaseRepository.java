package com.entrevista.domain.repository;

import com.entrevista.domain.model.Release;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReleaseRepository {

    @Transactional
    Release save(Release release);

    List<Release> statementConsolidated(LocalDate localDate);
}
