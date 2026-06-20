# 💰 Finanças On

API REST para gerenciamento financeiro pessoal desenvolvida com Java e Spring Boot.

O objetivo do projeto é permitir o controle de receitas, despesas, categorias e saldo financeiro de usuários, seguindo boas práticas de desenvolvimento Back-End e arquitetura em camadas.

> Status atual: 🚧 Em desenvolvimento (Fase 4 concluída)

---

# 📖 Sobre o Projeto

O Finanças On é uma API REST construída para simular um sistema real de controle financeiro.

A aplicação possui arquitetura organizada em:

* Controllers
* Services
* Repositories
* DTOs
* Entities
* Migrations

Atualmente já permite o gerenciamento completo de usuários, categorias e transações financeiras.

---

# 🚀 Tecnologias Utilizadas

* Java 25
* Spring Boot 4.1
* Spring Web MVC
* Spring Data JPA
* Hibernate
* Flyway
* MySQL
* Jakarta Validation
* Lombok
* Maven

---

# ✅ Funcionalidades Implementadas

## Usuários

* Cadastro de usuário
* Listagem de usuários
* Busca por ID
* Atualização de dados
* Exclusão de usuário
* Validação de e-mail duplicado

## Categorias

* Cadastro de categoria
* Listagem de categorias
* Busca por ID
* Atualização de categoria
* Exclusão de categoria
* Associação com usuário
* Controle de categorias do tipo RECEITA e DESPESA

## Transações

* Cadastro de transações
* Listagem de transações
* Busca por ID
* Atualização de transações
* Exclusão de transações
* Associação com usuário
* Associação com categoria
* Controle de receitas e despesas

## Banco de Dados

* Versionamento com Flyway
* Migrations automáticas
* Relacionamentos entre tabelas

## Validações

* Campos obrigatórios
* Usuário existente
* Categoria existente
* Categoria pertencente ao usuário
* Valor maior que zero

---

# 📂 Estrutura do Projeto

```text
src/main/java/com/ryanmiranda/financas_on

├── controller
│   ├── UsuarioController
│   ├── CategoriaController
│   └── TransacoesController

├── service
│   ├── UsuarioService
│   ├── CategoriaService
│   └── TransacaoService

├── repository
│   ├── UsuarioRepository
│   ├── CategoriaRepository
│   └── TransacoesRepository

├── model
│   ├── Usuario
│   ├── Categoria
│   ├── Transacao
│   └── Tipo

├── DTOs
│   ├── UsuarioDTO
│   ├── CategoriaDTO
│   └── TransicoesDTO

└── FinancasOnApplication
```

---

# 🔗 Endpoints

## Usuários

| Método | Endpoint       |
| ------ | -------------- |
| POST   | /usuarios      |
| GET    | /usuarios      |
| GET    | /usuarios/{id} |
| PUT    | /usuarios/{id} |
| DELETE | /usuarios/{id} |

## Categorias

| Método | Endpoint         |
| ------ | ---------------- |
| POST   | /categorias      |
| GET    | /categorias      |
| GET    | /categorias/{id} |
| PUT    | /categorias/{id} |
| DELETE | /categorias/{id} |

## Transações

| Método | Endpoint         |
| ------ | ---------------- |
| POST   | /transacoes      |
| GET    | /transacoes      |
| GET    | /transacoes/{id} |
| PUT    | /transacoes/{id} |
| DELETE | /transacoes/{id} |

---

# 🗄️ Banco de Dados

Tabelas implementadas:

* usuarios
* categorias
* transacao

Relacionamentos:

Usuario 1:N Categoria

Usuario 1:N Transacao

Categoria 1:N Transacao

---

# ⚙️ Como Executar

## Pré-requisitos

* Java 25
* MySQL
* Maven

## Criar Banco

```sql
CREATE DATABASE financas_on;
```

## Configuração

application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/financas_on
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

## Executar

Windows

```bash
./mvnw.cmd spring-boot:run
```

Linux/Mac

```bash
./mvnw spring-boot:run
```

---

# 🎯 Roadmap

## Próximas Funcionalidades

* Filtros por mês
* Filtros por ano
* Filtros por categoria
* Filtros por tipo
* Saldo financeiro
* Paginação
* Global Exception Handler
* Spring Security + JWT
* Swagger/OpenAPI
* Soft Delete
* Dashboard Financeiro
* Docker
* Deploy
* Testes Unitários
* Testes de Integração

---

# 📊 Status do Projeto

✅ Configuração

✅ Usuários

✅ Categorias

✅ Transações

🚧 Filtros

🚧 Saldo

🚧 Paginação

🚧 Tratamento de Exceções

🚧 JWT

🚧 Swagger

🚧 Docker

🚧 Deploy

🚧 Testes

---

Desenvolvido por Ryan Miranda Barbosa.
