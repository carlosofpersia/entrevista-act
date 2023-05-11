package com.entrevista.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="tbrelease", schema = "entrevistaact")
public class Release implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    @Column(name="cd_type_expense", nullable = false)
    private String cdTypeExpense;

    @Column(name="vl_release")
    private BigDecimal vlRelease;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

}
