#  MagicFridgeAI

*Assistente Inteligente de Cozinha* desenvolvido com Spring Boot e integrado à *Google Gemini API* para sugerir receitas personalizadas baseadas nos ingredientes disponíveis.

---

## Tecnologias Utilizadas

* *Java 21*
* *Spring Boot 3* (Web, Data JPA, Validation, Security)
* *Google Gemini API* (Inteligência Artificial para geração de receitas)
* *MySQL* (Persistência de dados)
* *Maven* (Gerenciador de dependências)

---

## Funcionalidades Principais

- [x] *Gestão de Inventário:* CRUD completo de alimentos (Nome, Quantidade, Data de Validade).
- [x] *Autenticação e Autorização:* Implementação de segurança com *Spring Security* e *JWT*, garantindo que cada usuário acesse apenas seu próprio inventário.
- [x] *Sugestão de Receitas com IA:* Integração com o modelo Gemini 2.5 Flash para criar receitas criativas.
- [x] *Arquitetura em Camadas:* Controller, Service, Repository, Model, Infra.
- [x] *Handler de Exceções:* Respostas de erro padronizadas para garantir uma melhor experiência do utilizador.

---

## Como Executar o Projeto

### Pré-requisitos
* JDK 17 ou superior.
* Maven instalado.
* MySQL instalado no seu computador
* Uma *API Key do Google Gemini*.

### Passo a Passo

1. *Clone o repositório:*
   ```bash
   git clone https://github.com/KarineE-Lima/MagicFridgeAI.git
   cd MagicFridgeAI

2. *Renomeie o application.properties.example para application.properties e preencha a propriedade:*
   ```bash
    gemini.api.key=SUA_CHAVE_AQUI
    spring.datasource.username=SEU_USER
    spring.datasource.password=SUA_SENHA

3. *Compile e execute:*
   ```bash
   mvn spring-boot:run

---

## Exemplos de Endpoints

| Método | Endpoint | Descrição | Autenticação |
| :--- | :--- | :--- | :--- |
| POST | /auth/cadastro | Cria uma nova conta de usuário | Pública |
| POST | /auth/login | Autentica o usuário e retorna o Token JWT | Pública |
| GET | /food/listar | Lista todos os alimentos no inventário | *Required JWT* |
| POST | /food | Adiciona um novo alimento à geladeira | *Required JWT* |
| PUT | /food/{id} | Atualiza dados de um alimento | *Required JWT* |
| DELETE | /food/{id} | Remove um alimento pelo ID | *Required JWT* |
| POST | /ia/pergunta | Gera uma receita baseada nos ingredientes | *Required JWT* |