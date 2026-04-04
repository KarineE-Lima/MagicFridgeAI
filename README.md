# MagicFridgeAI

**Aplicação web de cadastro de alimentos e sugestão de receitas personalizadas baseadas nos ingredientes disponíveis. 
Foi desenvolvido com Spring Boot e integrado à Google Gemini API**.

---

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **Google Gemini API** (Inteligência Artificial para geração de receitas)
* **H2 Database** (Persistência de dados)
* **Maven** (Gerenciador de dependências)

---

## Funcionalidades Principais

- [x] *Gestão de Inventário:* CRUD completo de alimentos (Nome, Categoria, Quantidade, Data de Validade).
- [x] *Sugestão de Receitas com IA:* Integração com o modelo Gemini 2.5 Flash para criar receitas criativas.
- [x] *Arquitetura em Camadas:* Controller, Service, Repository, Model, DTO, Infra.

---

## Como Executar o Projeto

### Pré-requisitos
* JDK 21.
* Maven instalado.
* Uma *API Key do Google Gemini*.

### Passo a Passo

1. *Clone o repositório:*
   ```bash
   git clone [https://github.com/KarineE-Lima/MagicFridgeAI.git](https://github.com/KarineE-Lima/MagicFridgeAI.git)
   
   cd MagicFridgeAI
2. Renomeie o *application.properties.example* para *application.properties* e preencha propriedade:
   
   ```bash
   gemini.api.key=SUA_CHAVE_AQUI

3. *Compile e Execute:*

   ```bash
   ./mvnw spring-boot-run

---

## Exemplos de Endpoints

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| GET | /food/listar | Lista todos os alimentos cadastrados. |
| GET | /food/listar/{id} | Lista um alimento pelo id. |
| POST | /food | Cadastra alimentos. |
| PUT | /food/{id} | Atualiza um alimento pelo id. |
| DELETE | /food/{id} | Deleta um alimento pelo id. |
| GET | /ia/pergunta | Gera a receita a partir dos alimentos cadastrados. |
