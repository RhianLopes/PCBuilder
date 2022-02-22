# :computer: PCBuilder

Este projeto ser o trabalho 1 da disciplina de Linguagem de Programação III do curso técnico em informática integrado
ao ensino médio do IFSul campus Sapucaia do Sul. O projeto segue o modelo cliente-servidor, onde o cliente se encontra na pasta "web" e 
o servidor se encontra na parte "api", além disso, o servidor se conecta com um banco de dados relacional [MySQL](https://www.mysql.com/).

O cliente possui como principais tecnologias/ferramentas:

- [React JS](https://reactjs.org/)
- [Material UI](https://mui.com/)
- [React Router Dom](https://v5.reactrouter.com/web/guides/quick-start)
- [Axios](https://axios-http.com/docs/intro)

O servidor possui como principais tecnologias/ferramentas:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Boot JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Boot Web](https://spring.io/guides/gs/spring-boot/)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Lombok](https://projectlombok.org/)
- [MySQL Connector Java](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
- [Liquibase](https://liquibase.org/)
- [Apache Commons](https://commons.apache.org/)
- [Hibernate Validator](https://hibernate.org/validator/documentation/getting-started/)

## :detective: Participantes

- Rhian Lopes da Costa
- Eduarda dos Santos
- Bruna Nunes da Silva

## :dart:	Enunciado do Trabalho

> Permitir o cadastro de peças para computadores. Uma peça tem uma marca, modelo, categoria, preço unitário e compatibilidade (para simplificar a análise de compatibilidade, vamos armazenar apenas o soquete do processor para servir como identificador de compatibilidade. Essa funcionalidade será descrita adiante).

> Pesquisar peças: permitir ao utilizador do sistema pesquisar peças por marca, modelo e/ou categoria. O sistema deve listar (apresentar na tela) as informações das peças que se enquadram no critério de busca utilizado.

> Gerar computador: o usuário informa o modelo de soquete do processador que ele deseja montar e o valor em reais que ele tem para investir. Com essas informações o sistema deve montar/sugerir uma configuração de PC. Caso não seja possível, isto é, a soma do valor das peças excede o valor máximo em reais, apenas indique que o valor investido é insuficiente. Caso contrário, apresentar na tela as placas identificadas. Aqui vamos simplificar: para montar um computador, basta encontrar uma placa-mãe, memória, HD e um processador compatíveis. Esse resultado não precisa ser persistido no banco de dados, apenas apresentado na tela.

## :eyes: Preview

![](https://cdn.discordapp.com/attachments/576875163686010911/945528975554396200/unknown.png)
![](https://cdn.discordapp.com/attachments/576875163686010911/945529177443008542/unknown.png)
![](https://cdn.discordapp.com/attachments/576875163686010911/945529223869784134/unknown.png)

## :nail_care: Para rodar o cliente

Para rodarmos localmente o cliente web, deve possuir instalado o [Node](https://nodejs.org/en/), feito isso, na pasta raiz "web", devemos executar o seguinte
comando para baixar as dependências:

```shell
npm install
```

ou, caso possua o [Yarn](https://yarnpkg.com/) instalado:

```shell
yarn i
```

Por fim, com as dependências baixadas, devemos executar o seguinte comando para rodar o projeto:

```shell
npm start
```

ou

```shell
yarn start
```

Com isso, você poderá acessar a aplicação pelo link http://localhost:3000/

## :card_index_dividers: Para rodar o MySQL localmente (opcional)


Para rodar o MySQL localmente, recomendamos o uso do [Docker], com ele basta instala-lo em seu computador e executar o seguinte comando para criar um container com a imagem MySQL:

```shell
docker container run --name some-mysql -e MYSQL_ROOT_PASSWORD=toor -p 3306:3306  -d mysql:8.0.2
```

Para verificar se seu container MySQL está rodando, basta rodar o seguinte comando:

```shell
docker ps
```

Caso não esteja rodando seu container, basta rodar:

```shell
docker start some-mysql
```

## :gear: Para rodar o servidor

Para rodarmos o servidor recomendamos o uso do [IntelliJ IDEA](https://www.jetbrains.com/idea/), além disso, é necessária a instalação da [JDK 11 do Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html).

Feito isso, podemos abrir o projeto na pasta raiz "api" pela IDE. É necessário um único ajuste antes de executar a aplicação pela IDE, que é a configuração dos 
acessos ao banco de dados MySQL no arquivo `application.yml`, onde deve se atentar aos seguintes campos:

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    host: <seu IP, caso seja local deixar "localhost">
    url: jdbc:mysql://localhost:3306/pcbuilder_db...
    username: <usuário do MySQL>
    password: <senha do MySQL>
```

> Obs: Caso tenha seguido o passo a passo de rodar o MySQL localmente com Docker, poderá deixar os valores já preenchidos no arquivo

Por fim basta executar a aplicação pela própria IDE. Com isso, basta acessar o endpoint de Health Check do servidor http://localhost:8010/pc-builder/actuator/health

