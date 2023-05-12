# Fluxo Caixa - 2023-05-12

Projeto Fluxo Caixa - Docker(JAVA + Mysql)

Projeto visa atender um fluxo simples de caixa de um comerciante onde o usuário possui uma carteira digital;

  Listar usuários;
  
  Realizar lançamentos Credito/Debito;
  
  Relatório consolidado diário geral;

------------------------------------------------------------------------------------------

Recursos necessários para o desenvolvimento do projeto:

  jdk-8.0.372.07-hotspot;

  apache-maven-3.9.1;

  mysql-connector-java-5.1.7-bin;

  Docker;

  gitbash;

  IntelliJ IDEA Community Edition 2023.1.1;

-------------------------------------------------------------------

Padrões utilizados no projeto:

  Inversão de Controle (IoC) e Injeção de Dependência (DI);

  Padrão MVC;

  Padrão Repository;

  Padrão DTO (Mapper);
  
  SOLID;
  
  Teste Uniários com Mockito;
  
  Cobertura de testes unitários com JACOCO;
  
    .\employee-producer\target\site\jacoco\index.html
  
  Sobre segurança todos os endpoints solicitam **Authorization** e **x-transaction-id**, podendo assim implantar qualquer controle via intercptions (JWT|OAUTH).

------------------------------------------------------------------------------------------

Com o ambiente todo configurado, basta ir na raiz do projeto, abrir o gitbash e rodar os seguintes comandos:

mvn clean install

**docker compose up --build**

* Caso já tenha rodado o docker compose e tenha dado algum problema, deve-se apagar todas as configurações do docker do projeto;
* Caso não tenha o ambiente completo, bastar rodar "docker compose up --build" que deixei o projeto compilado na pasta target;
* 
------------------------------------------------------------------------------------------

Para testar o projeto segue exemplos práticos via CURL:

1. Listar usuários para obter o ID

curl --location --request GET 'http://localhost:8080/v1/person' \
--header 'Authorization: XXXX' \
--header 'x-transaction-id: xxxx'

2. Lançar movimentação de valores (C|D)

curl --location --request POST 'http://localhost:8080/v1/release' \
--header 'Authorization: XXXX' \
--header 'x-transaction-id: xxxx' \
--header 'Content-Type: application/json' \
--data-raw '{
    "person": {
        "id": 2
    },
    "cd_type_expense": "D",
    "vl_release": "17.50"
}'

3. Apresentar saldo consolidado do dia:

curl --location --request GET 'http://localhost:8080/v1/statement/consolidated/2023-05-11' \
--header 'Authorization: XXXX' \
--header 'x-transaction-id: xxxx'


-----------------------------------------------------------------

Desenho processo Containerização:

![devops](https://github.com/carlosofpersia/entrevista-act/assets/3011876/7da51af3-9294-4a95-ab6b-24de051f9b42)


Configuração Intelij:

![config-intelij](https://github.com/carlosofpersia/entrevista-act/assets/3011876/83f01de2-b074-470a-ae53-b43fd7cf87ca)


Tabelas mapeadas:

![tabela](https://github.com/carlosofpersia/entrevista-act/assets/3011876/8011087c-7f88-4863-a346-9604b459774f)


Cobertura de Testes com JACOCO

![testes-unitarios](https://github.com/carlosofpersia/entrevista-act/assets/3011876/dd802c6c-009b-4cc9-9e66-5b3453a37e68)


