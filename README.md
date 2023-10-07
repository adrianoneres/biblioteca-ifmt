# Livraria IFMT

Livraria IFMT é uma API desenvolvida em Java com SpringBoot, para fins didáticos, durante a Pós-graduação em Engenharia DevOps.

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

- [ ] Como um usuário do sistema, devo ser capaz de cadastar um livro informando título e autor.
- [ ] Como um usuário do sistema, devo ser capaz de listar todos os livros cadastrados.
- [ ] Como um usuário do sistema, devo ser capaz de buscar um livro pelo seu identificador.
- [ ] Como um usuário do sistema, devo ser capaz de editar o titulo e o autor do livro.
- [ ] Como um usuário do sistema, devo ser capaz de excluir um livro.

### 2.2. Versão 1.1.0

- [ ] Como um usuário do sistema, devo obter a mensagem "Livro {identificador do livro} não encontrado" quando buscar por um livro que não esteja cadastrado.
- [ ] Como um usuário do sistema, não devo inserir livros com o mesmo nome
