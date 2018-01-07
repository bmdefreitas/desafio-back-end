## Montagem do ambiente de desenvolvimento

1. Abra o projeto com o Eclipse;
2. Importe o projeto **"Existing Maven Projects"**;
3. Rode **"maven install"**.


## Executando o projeto pelo eclipse

Após a montagem do ambiente, rode o projeto **"RunAs Spring Boot App"**.

## Build do projeto

Execute **"maven build"**. 

Após o término, irá conter dentro da pasta target terá um jar chamado **"desafio-0.0.1.jar"**.

## Executando o projeto pelo arquivo JAR 

 1. Abra o CMD ou o terminal;
 2. Acesse a pasta target do projeto;
 3. execute **"java -jar desafio-0.0.1.jar"**.

 
## Acessando o resultado

Acesse por um browser ou pelo [Postman](https://www.getpostman.com) a seguinte URL: [http://localhost:8080/api/crawler](http://localhost:8080/api/crawler). Em seguida será solicitado um usuário e senha:

**Usuário: admin**  
**Senha: admin**


Caso prefira, use o command line:

``curl -H "Content-Type: application/json" -H "Authorization: Basic YWRtaW46YWRtaW4=" -X GET http://localhost:8080/api/crawler``

 