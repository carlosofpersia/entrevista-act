package com.entrevista.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="tbperson", schema = "entrevistaact")
public class Person implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_type_person")
    private String cdTypePerson;

    @Column(name = "name", length = 140)
    private String name;

    @Column(name = "fantasy_name", length = 140)
    private String fantasyName;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
}
