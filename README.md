# Biblioteca IFMT

Biblioteca IFMT é uma API desenvolvida em Java com SpringBoot, para fins didáticos, durante a Pós-graduação em Engenharia DevOps.

## 1. Endpoints

### 1.1. Livros

- Criar
```sh
POST /livros
```
```json
{
  "titulo": "Hamlet",
  "autor": "Shakespeare"
}
```
```json
{
  "id": "092c8a20-22f6-4199-a0a0-8d185e6b5991",
  "titulo": "Hamlet",
  "autor": "Shakespeare"
}
```
- Listar todos
```
GET /livros
```
- Buscar por identificador
```
GET /livros/{id}
```
```json
{
  "id": "092c8a20-22f6-4199-a0a0-8d185e6b5991",
  "titulo": "Hamlet",
  "autor": "Shakespeare"
}
```
- Editar
```
PUT /livros/{id}
```
```json
{
  "titulo": "Dracula",
  "autor": "Bram Stoker"
}
```
```json
{
  "id": "092c8a20-22f6-4199-a0a0-8d185e6b5991",
  "titulo": "Dracula",
  "autor": "Bram Stoker"
}
```
- Excluir
```
DELETE /livros/{id}
```

## 2. Requisitos

### 2.1. Versão 1.0.0

- [x] Como um usuário do sistema, devo ser capaz de cadastar um livro informando título e autor.
- [x] Como um usuário do sistema, devo ser capaz de listar todos os livros cadastrados.
- [x] Como um usuário do sistema, devo ser capaz de buscar um livro pelo seu identificador.
- [x] Como um usuário do sistema, devo ser capaz de editar o titulo e o autor do livro.
- [x] Como um usuário do sistema, devo ser capaz de excluir um livro.

### 2.2. Versão 1.1.0

- [x] Como um usuário do sistema, devo ser capaz de cadastrar um usuário informando nome de usuário e senha.
  - **Critérios de aceitação:**
    - [x] Não deve ser possível cadastrar um usuário com o mesmo nome de usuário de outro já cadastrado.
    - [x] Ao cadastrar um usuário, sua senha deve ser criptografada antes de ser salva no banco de dados.
    - [x] Deve ser possível efetuar o login com o novo usuário cadastrado.

### 2.3. Versão 1.2.0

- [x] Como um administrador do sistema, devo ser capaz de obter os dados do usuário pelo endpoint `/admin/usuarios/{id-usuario}`
  - [x] Bônus: Os dados do usuário devem ser retornados no seguinte padrão:
  ```json
    {
      "id": "e2550bf9-d644-4758-baa5-e047b0379c00",
      "nomeUsuario": "teste",
      "perfil": "ADMIN"
    }
  ```
- [x] Como um administrador do sistema, devo ser capaz de obter todos os usuários de um perfil pelo endpoint `admin/perfis/{id-perfil}`
  - [x] Bônus: Os dados do perfil devem ser retornados no seguinte padrão:
  ```json
    {
      "id": "711917da-d066-4b52-a82c-c823667de2ba",
      "nome": "ADMIN",
      "usuarios": ["teste", "tiao"]
	  },
  ```
