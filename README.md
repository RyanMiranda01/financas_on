# Finanças On

API REST para controle financeiro pessoal, desenvolvida com Java, Spring Boot e MySQL.

> Status: em desenvolvimento.
>
> Este projeto ainda não está finalizado e segue em evolução. A base atual já possui CRUD de usuários, CRUD de categorias, validações, persistência com JPA/Hibernate e versionamento de banco com Flyway. As funcionalidades de transações, autenticação, relatórios e dashboard financeiro ainda fazem parte do roadmap.

## Sobre o projeto

O Finanças On é uma API back-end criada para organizar dados financeiros pessoais. A ideia é permitir que um usuário cadastre suas categorias financeiras, registre receitas e despesas e acompanhe sua movimentação ao longo do tempo.

Nesta fase, o projeto está focado em construir uma base sólida para a API:

- Organização em camadas: controllers, services, repositories, DTOs e models.
- Persistência de dados com Spring Data JPA e MySQL.
- Versionamento do banco de dados com Flyway.
- Validação de entrada com Jakarta Validation.
- Estrutura inicial para futuras transações financeiras.

## Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Flyway
- MySQL
- Jakarta Validation
- Lombok
- Maven

## Funcionalidades implementadas

### Usuários

- Cadastro de usuário.
- Listagem paginada de usuários.
- Busca de usuário por ID.
- Atualização de dados do usuário.
- Exclusão de usuário.
- Validação de e-mail único.

### Categorias

- Cadastro de categoria.
- Listagem paginada de categorias.
- Busca de categoria por ID.
- Atualização de categoria.
- Exclusão de categoria.
- Associação da categoria a um usuário.
- Tipos de categoria: `RECEITA` e `DESPESA`.

### Transações

- Modelagem inicial da entidade `Transacao`.
- Associação prevista com usuário e categoria.
- Campos iniciais para descrição, valor, tipo e data.

## Estrutura do projeto

```text
src/main/java/com/ryanmiranda/financas_on
├── controller
│   ├── CategoriaController.java
│   └── UsuarioController.java
├── service
│   ├── CategoriaService.java
│   └── UsuarioService.java
├── repository
│   ├── CategoriaRepository.java
│   └── UsuarioRepository.java
├── model
│   ├── Categoria.java
│   ├── Tipo.java
│   ├── Transacao.java
│   └── Usuario.java
├── DTOs
│   ├── categoriaDTO
│   └── UsuarioDTO
└── FinancasOnApplication.java
```

## Endpoints

### Usuários

Base URL:

```http
http://localhost:8080/financason/usuario
```

| Método | Endpoint      | Descrição            |
| ------ | ------------- | -------------------- |
| POST   | `/cadastrar`  | Cadastra um usuário  |
| GET    | `/listar`     | Lista usuários       |
| GET    | `/listar/{id}` | Busca usuário por ID |
| PUT    | `/editar/{id}` | Atualiza usuário     |
| DELETE | `/deletar/{id}` | Remove usuário      |

Exemplo de cadastro:

```json
{
  "nome": "Ryan Miranda",
  "email": "ryan@email.com",
  "senha": "123456"
}
```

### Categorias

Base URL:

```http
http://localhost:8080/financason/categoria
```

| Método | Endpoint       | Descrição              |
| ------ | -------------- | ---------------------- |
| POST   | `/cadastrar`   | Cadastra uma categoria |
| GET    | `/listar`      | Lista categorias       |
| GET    | `/listar/{id}` | Busca categoria por ID |
| PUT    | `/editar/{id}` | Atualiza categoria     |
| DELETE | `/deletar/{id}` | Remove categoria       |

Exemplo de cadastro:

```json
{
  "nome": "Salário",
  "tipo": "RECEITA",
  "usuarioId": 1
}
```

## Como executar

### Pré-requisitos

- Java 25
- MySQL
- Maven ou Maven Wrapper

### Clone o repositório

```bash
git clone https://github.com/RyanMiranda01/financas_on.git
cd financas_on
```

### Crie o banco de dados

```sql
CREATE DATABASE financas_on;
```

### Configure a conexão

Atualize o arquivo `src/main/resources/application.properties` com as credenciais do seu ambiente local:

```properties
spring.datasource.url=jdbc:mysql://localhost/financas_on
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

### Execute a aplicação

No Windows:

```bash
./mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

## Testes

Para executar os testes:

```bash
./mvnw.cmd test
```

ou, no Linux/macOS:

```bash
./mvnw test
```

## Roadmap

- Implementar CRUD de transações.
- Criar regras para receitas e despesas.
- Calcular saldo do usuário.
- Adicionar filtros por período, categoria e tipo.
- Implementar tratamento global de exceções.
- Melhorar os retornos HTTP da API.
- Criptografar senhas antes de salvar no banco.
- Implementar autenticação e autorização.
- Documentar a API com Swagger/OpenAPI.
- Adicionar testes unitários e de integração.
- Criar configuração com variáveis de ambiente.
- Configurar Docker para facilitar a execução local.

## Observações

Este repositório representa um projeto em construção e tem como objetivo demonstrar evolução prática em desenvolvimento back-end com Java e Spring Boot. Algumas decisões ainda serão melhoradas conforme novas funcionalidades forem adicionadas.
