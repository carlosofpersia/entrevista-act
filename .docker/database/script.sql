


USE entrevistaact;

CREATE TABLE tbperson (
    id int not null AUTO_INCREMENT,
    cd_type_person varchar(1) not null,
	name varchar(140),
	fantasy_name varchar(140),
    dt_create datetime not null DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

insert into tbperson (cd_type_person, name, fantasy_name) values ('F', 'Carlos Eduardo', 'carloss');
insert into tbperson (cd_type_person, name, fantasy_name) values ('F', 'Antonio Donizildo', 'dony');

CREATE TABLE tbrelease (
    id int not null AUTO_INCREMENT,
	id_person int not null,
    cd_type_expense varchar(1) not null,
	vl_release float,
	dt_create datetime not null DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	CONSTRAINT fk_person_release FOREIGN KEY (id_person) REFERENCES tbperson(id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

