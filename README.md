# 💰 Finanças On

API REST em desenvolvimento para gerenciamento financeiro pessoal, criada com Java e Spring Boot.

O projeto ainda não está finalizado e atualmente estrutura a base para cadastro de usuários, categorias e transações, utilizando persistência em MySQL, validações de entrada, JPA/Hibernate e versionamento de banco com Flyway.

> Status: 🚧 Em desenvolvimento

---

## 📖 Sobre o Projeto

O **Finanças On** nasceu como uma API Back-End para controlar dados financeiros de usuários.

A aplicação já possui uma arquitetura em camadas, separando responsabilidades entre Controllers, Services, Repositories, Models e DTOs, facilitando a evolução do projeto para funcionalidades mais avançadas como:

* Controle de receitas e despesas
* Filtros por período
* Controle de saldo
* Autenticação e autorização
* Dashboard financeiro
* Relatórios

---

## 🚀 Tecnologias Utilizadas

* Java 25
* Spring Boot 4.1.0
* Spring Web MVC
* Spring Data JPA
* Hibernate
* Flyway
* MySQL
* Bean Validation
* Lombok
* Maven

---

## ✅ Funcionalidades Implementadas

### Usuários

* Cadastro de usuários
* Listagem paginada
* Busca por ID
* Atualização de dados
* Exclusão de usuários

### Categorias

* Estrutura inicial implementada
* Relacionamento com usuário

### Transações

* Modelagem inicial criada
* Estrutura preparada para receitas e despesas

### Banco de Dados

* Migrations com Flyway
* Versionamento automático do banco

### Validações

* Validação de dados utilizando Jakarta Validation

---

## 📂 Estrutura do Projeto

```text
src/main/java/com/ryanmiranda/financas_on

├── controller
│   └── UsuarioController.java
│
├── service
│   ├── UsuarioService.java
│   └── CategoriaService.java
│
├── repository
│   ├── UsuarioRepository.java
│   └── CategoriaRepository.java
│
├── model
│   ├── Usuario.java
│   ├── Categoria.java
│   ├── Transacao.java
│   ├── Tipo.java
│   
├── DTOs
│   ├── CategoriaDTO
│   │   ├── AtualizacaoCategoria
│   │   ├── CadastroCategoria
│   │   └── ListarCategoria
│   └── UsuarioDTO
│       ├── AtualizacaoUsuario
│       ├── CadastroUsuario
│       └── ListarDadosUsuario
|
└── FinancasOnApplication.java
```

---

## 🔗 Endpoints de Usuário

### Base URL

```http
http://localhost:8080/financason/usuario
```

| Método | Endpoint      | Descrição            |
| ------ | ------------- | -------------------- |
| POST   | /cadastrar    | Cadastra um usuário  |
| GET    | /listar       | Lista usuários       |
| GET    | /listar/{id}  | Busca usuário por ID |
| PUT    | /editar/{id}  | Atualiza usuário     |
| DELETE | /deletar/{id} | Remove usuário       |

---

## 📝 Exemplo de Cadastro

```json
{
  "nome": "Ryan Miranda",
  "email": "ryan@email.com",
  "senha": "123456"
}
```

---

## ⚙️ Como Executar

### Pré-requisitos

* Java 25
* MySQL
* Maven ou Maven Wrapper

### Criar Banco

```sql
CREATE DATABASE financas_on;
```

### Configuração

No arquivo:

```text
src/main/resources/application.properties
```

Configure:

```properties
spring.datasource.url=jdbc:mysql://localhost/financas_on
spring.datasource.username=SEU USUARIO
spring.datasource.password=SUA SENHA
```

### Executar a Aplicação

#### Windows

```bash
./mvnw.cmd spring-boot:run
```

#### Linux/macOS

```bash
./mvnw spring-boot:run
```

---

## 🌐 Aplicação

A API ficará disponível em:

```text
http://localhost:8080
```

---

## 🎯 Próximos Passos

* Criar Controller de Categorias
* Criar Controller de Transações
* Implementar cadastro de receitas e despesas
* Implementar filtros por período
* Implementar cálculo de saldo
* Adicionar paginação
* Implementar tratamento global de exceções
* Adicionar autenticação JWT
* Documentar API com Swagger/OpenAPI
* Criar testes unitários
* Criar testes de integração
* Configurar Docker
* Realizar deploy


