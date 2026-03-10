# 🛒 ShopBy - REST API com Spring Boot

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

## 📌 Sobre o Projeto

O **ShopBy** é uma **API RESTful** desenvolvida com **Java e Spring Boot** que simula um sistema de gerenciamento de loja, permitindo o controle de **usuários, produtos e pedidos**.

O projeto foi criado com foco em **boas práticas de desenvolvimento backend**, aplicando conceitos utilizados em sistemas reais de mercado.

Principais objetivos:

* Construção de **Web Services REST**
* Aplicação de **Arquitetura em Camadas**
* Persistência de dados com **JPA**
* Implementação ORM com **Hibernate**
* Estrutura de projeto escalável

---

# 🏗️ Arquitetura

O projeto segue o padrão **Layered Architecture (Arquitetura em Camadas)**.

```
Controller → Service → Repository → Database
```

### Controller

Responsável por lidar com as **requisições HTTP** da aplicação.

Exemplo:

* GET
* POST
* PUT
* DELETE

### Service

Contém a **regra de negócio** da aplicação.

Separa a lógica do controller e melhora a manutenção do sistema.

### Repository

Camada responsável pela **comunicação com o banco de dados** utilizando **Spring Data JPA**.

### Entity

Representa as **entidades do sistema** que são mapeadas para tabelas no banco.

---

# 📂 Estrutura do Projeto

```
src
 └── main
     └── java
         └── com.Flavio.shopby
             ├── controllers
             │
             ├── services
             │
             ├── repositories
             │
             ├── entities
             │
             └── config
```

Essa separação facilita:

* manutenção
* escalabilidade
* organização do código

---

# 🧠 Conceitos Aplicados

## JPA (Java Persistence API)

JPA é uma **especificação padrão do Java** para mapeamento objeto-relacional (ORM).

Ela permite mapear **classes Java para tabelas do banco de dados**.

Exemplo:

```
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
```

---

## Hibernate

O **Hibernate** é a **implementação mais popular da JPA**.

Ele é responsável por:

* transformar objetos Java em registros no banco
* executar queries automaticamente
* gerenciar o mapeamento ORM

---

# ⚙️ Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven
* H2 Database / SQL
* REST API

---

# 🚀 Como Executar o Projeto

### 1 Clonar o repositório

```
git clone https://github.com/FL4V10ARC/Service_W.git
```

---

### 2 Entrar na pasta do projeto

```
cd Service_W
```

---

### 3 Executar a aplicação

```
mvn spring-boot:run
```

ou

```
./mvnw spring-boot:run
```

---

# 🌐 Endpoints da API

### Usuários

```
GET /users
GET /users/{id}

POST /users
PUT /users/{id}

DELETE /users/{id}
```

---

### Produtos

```
GET /products
GET /products/{id}

POST /products
PUT /products/{id}

DELETE /products/{id}
```

---

### Pedidos

```
GET /orders
GET /orders/{id}

POST /orders
```

---

# 📊 Modelo de Domínio

O sistema possui as seguintes entidades principais:

* **User**
* **Product**
* **Order**
* **OrderItem**
* **Category**

Relacionamentos:

```
User 1 --- N Order

Order 1 --- N OrderItem

Product 1 --- N OrderItem

Product N --- N Category
```

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para demonstrar conhecimentos em:

* Backend Java
* Desenvolvimento de APIs REST
* Persistência de dados com ORM
* Organização de código profissional

---

# 👨‍💻 Autor

**Flávio**

GitHub
https://github.com/FL4V10ARC

---

# 📄 Licença

Este projeto está sob a licença **MIT**.
