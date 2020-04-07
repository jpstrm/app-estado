# Autor

- João Paulo Santarém
- Email: jpstrm@gmail.com

# App Estado

Gerencimaneto Estados e Municípios

        
# Tecnologias usadas

* SpringBoot 2, Spring data, Webflux, Swagger
* Angular, Typescript
* Maven
* Junit 5, Mockito
* MySQL

# Requisitos

- Certifique-se de primeiro ter instalado e configurado as tecnologias:
    - JDK 8
    - Maven
    - npm

# Execução

## Pré-requisitos
- Trocar as variáveis do ambiente em src/main/resources/application.yml por configurações válidas
ou exportar as variáveis de ambiente para a máquina local

### Ambiente Local

- Frontend
```sh
  npm install && npm run build
```

- Backend
```sh
mvn clean package spring-boot:run
```

# Aplicação
- local: `http://localhost:8080`
- heroku: `https://app-estado.herokuapp.com`
    
# Documentação

## Scripts do Banco de dados
- Criação do banco: src/main/resources/schema.sql
- Carga inicial: src/main/resources/data.sql

## Swagger
    - local: `http://localhost:8080/swagger-ui.html`
    - heroku: `https://app-estado.herokuapp.com/swagger-ui.html`
