# 🥷 Sistema de Cadastro de Ninjas

Bem-vindo ao **Sistema de Cadastro de Ninjas**!  
Este projeto é uma aplicação em arquitetura de camadas desenvolvida com **Spring Boot**, com o objetivo de cadastrar ninjas e suas respectivas missões.  

O sistema utiliza um banco de dados **H2 em memória**, **Flyway** para migrações e segue boas práticas de desenvolvimento como controle de versão com **Git** e hospedagem no **GitHub**.

---

## 📌 Visão Geral

O sistema foi projetado para gerenciar **ninjas** e suas **missões**.

- Cada **ninja** pode ser atribuído a **uma única missão**.
- Cada **missão** pode ser associada a **vários ninjas**.

### Funcionalidades Principais

- ✅ Cadastro de ninjas com nome, idade, e-mail e rank.  
- ✅ Atribuição de uma missão para um ninja.  
- ✅ Gerenciamento de missões e dos ninjas associados a elas.

---

## 🛠️ Tecnologias Utilizadas

- **Java + Spring Boot** – Backend e estrutura da aplicação.
- **Spring Data JPA** – Acesso e persistência no banco de dados.
- **Banco de Dados H2** – Banco em memória para desenvolvimento/testes.
- **Flyway** – Migrações de banco de dados versionadas.
- **JPA (Java Persistence API)** – Mapeamento objeto-relacional (ORM).
- **Maven** – Build e gerenciamento de dependências.
- **SQL** – Manipulação e estruturação do banco.
- **Git + GitHub** – Controle de versão e hospedagem do projeto.

---

## 🗃️ Design do Banco de Dados

A modelagem segue a seguinte estrutura de relacionamento:

### 🥷 Ninja

| Campo     | Tipo     |
|-----------|----------|
| `id`      | Long     |
| `nome`    | String   |
| `idade`   | Integer  |
| `email`   | String   |
| `rank`    | String   |
| `missao`  | Missão   |

Cada ninja pode estar associado a **uma missão**.

### 🎯 Missão

| Campo        | Tipo     |
|--------------|----------|
| `id`         | Long     |
| `titulo`     | String   |
| `descricao`  | String   |

Cada missão pode ser atribuída a **vários ninjas**.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/cleber-fsilva/CadastroDeNinjas.git
   cd seu-repositorio
Execute o projeto via Maven:

bash
Copiar código
./mvnw spring-boot:run
Acesse o sistema:

arduino
Copiar código
http://localhost:8080
Acesse o console do H2:

bash
Copiar código
http://localhost:8080/h2-console
Use as configurações:

JDBC URL: jdbc:h2:mem:testdb

Usuário: sa

Senha: (deixe em branco)

📄 Licença
Este projeto está licenciado sob a MIT License.

🤝 Contribuindo
Contribuições são bem-vindas!
Sinta-se à vontade para abrir uma issue ou enviar um pull request.

📬 Contato
Caso queira entrar em contato:

Cleber Ferreira – silva1cleber@gmail.com

GitHub – @cleber-fsilva
