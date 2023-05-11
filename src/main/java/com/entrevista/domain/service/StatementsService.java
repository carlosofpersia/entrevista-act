package com.entrevista.domain.service;

import com.entrevista.api.model.input.StatementConsolidatedMapper;
import com.entrevista.domain.enumarations.TypeExpenseEnum;
import com.entrevista.domain.model.Release;
import com.entrevista.domain.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StatementsService {

    @Autowired
    ReleaseRepository releaseRepository;

    @Transactional
    public StatementConsolidatedMapper consolidated(LocalDate localDate) {

        List<Release> listRelelase = releaseRepository.statementConsolidated(localDate);

        StatementConsolidatedMapper statementConsolidatedMapper = new StatementConsolidatedMapper();
        statementConsolidatedMapper.setDtSelected(localDate);
        statementConsolidatedMapper.setVlConsolidated(BigDecimal.valueOf(0));

        listRelelase.stream().forEach(element -> {

            if( element.getCdTypeExpense().equals(TypeExpenseEnum.CREDITO.getCode()) ) {
                statementConsolidatedMapper.setVlConsolidated(statementConsolidatedMapper.getVlConsolidated().subtract(element.getVlRelease()));
            } else {
                statementConsolidatedMapper.setVlConsolidated(statementConsolidatedMapper.getVlConsolidated().add(element.getVlRelease()));
            }
        });
        return statementConsolidatedMapper;
    }
}
