# 📚 LiterAlura - Alura - Oracle Next Education

Neste desafio de programação, desenvolvi o **LiterAlura**, um catálogo de livros com interação via console, consumindo dados de uma API externa, manipulando JSON e persistindo informações em banco de dados.

O projeto foi construído em **Java**, aplicando boas práticas de organização, consumo de APIs REST e persistência de dados.

---

## 🚀 Objetivo do Projeto

Desenvolver um **Catálogo de Livros** que ofereça interação textual (via console) com os usuários, contendo no mínimo **5 opções de interação**.

Os livros são buscados através da API pública **Gutendex**, que disponibiliza dados de obras do **Project Gutenberg**.

---

## 🛠️ Tecnologias Utilizadas

* ☕ Java
* Spring Boot
* Maven
* Banco de Dados (JPA / Hibernate)
* API REST
* Manipulação de JSON (Jackson)
* Console para interação com usuário

---

## 📌 Funcionalidades

O sistema oferece interação textual via console com, no mínimo, as seguintes opções:

1. 🔎 Buscar livro pelo título
2. 📚 Listar livros registrados
3. 🤫 (Extra: Listar livros por idioma)
4. ✍️ Listar autores registrados
5. 📅 Listar autores vivos em determinado ano
6. 🌎 Listar quantidade de livros por idioma

---

## 🔄 Etapas de Desenvolvimento

O desafio foi dividido nas seguintes etapas:

### 1️⃣ Configuração do Ambiente Java

* Instalação do JDK
* Configuração do Maven
* Criação da estrutura inicial do projeto

### 2️⃣ Criação do Projeto

* Estruturação dos pacotes
* Criação das entidades (Livro, Pessoa)
* Configuração do Spring Boot

### 3️⃣ Consumo da API

* Realização de requisições HTTP
* Integração com a API **Gutendex**
* Tratamento de respostas

### 4️⃣ Análise da Resposta JSON

* Mapeamento dos dados recebidos
* Conversão para objetos Java
* Tratamento de campos necessários

### 5️⃣ Inserção e Consulta no Banco de Dados

* Persistência utilizando JPA
* Relacionamento entre entidades
* Consultas personalizadas

### 6️⃣ Exibição de Resultados

* Menu interativo no console
* Exibição formatada de livros e autores
* Filtros personalizados

---

## 🎯 Aprendizados

Durante o desenvolvimento do LiterAlura, foi possível praticar:

* Consumo de APIs REST
* Desserialização de JSON
* Persistência de dados com JPA
* Relacionamentos entre entidades
* Boas práticas em projetos Java
* Organização com metodologia ágil

---

## 💡 Como Executar o Projeto

1. Clonar o repositório
2. Criar uma tabela no banco de dados com o nome literalura
3. Configurar acesso ao banco de dados nas variáveis de ambiente do seu sistema (ou diretamente no `application.properties`)
4. Executar a aplicação
5. Interagir com o menu via console

---

## 🏁 Conclusão

O **LiterAlura** proporcionou uma experiência prática e completa no desenvolvimento backend com Java, integrando API externa, banco de dados e interação com o usuário.

Um projeto essencial para consolidar conceitos fundamentais de desenvolvimento Java e arquitetura de aplicações. 🚀
