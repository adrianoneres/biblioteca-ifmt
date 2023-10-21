-- Referências:
--    - Listar todas as bases: \l
--    - Conectar à uma base:: \c nome-da-base
--    - Listar todas as tabelas de uma base: \dt

-- Cria schema
CREATE DATABASE "biblioteca-ifmt";

-- Cria tabela livros
CREATE TABLE livros (id VARCHAR(50) PRIMARY KEY, titulo VARCHAR(100) NOT NULL, autor VARCHAR(100) NOT NULL);

-- Insere alguns livros
INSERT INTO livros VALUES ('cff21df5-f959-4630-a3a1-f6b272951800', 'Dracula', 'Bram Stoker');
INSERT INTO livros VALUES ('6b8328bc-2daf-4782-9350-87226ee5ee4e', 'Hamlet', 'William Shakespeare');
INSERT INTO livros VALUES ('5bb56b52-afbd-4d1d-9133-1b19175aed7d', 'Crime e Castigo', 'Fiódor Dostoiévski');
INSERT INTO livros VALUES ('6c59ad1b-1b9d-47d4-a98c-b74410cc039a', 'Anna Karênina', 'Liev Tolstói');
INSERT INTO livros VALUES ('83ddd6fb-d25f-4aa5-9736-f29de81ff0b9', '1984', 'George Orwell');

-- Cria tabela usuarios
CREATE TABLE usuarios (id VARCHAR(50) PRIMARY KEY, nome_usuario VARCHAR(100) NOT NULL, senha VARCHAR(100) NOT NULL);

-- Inserir um novo usuário com o nome de usuário teste e a senha 123
INSERT INTO usuarios VALUES ('e2550bf9-d644-4758-baa5-e047b0379c00', 'teste', '$2a$10$XXgjnZmYFG.t.ie03oopD.MpX.gdr8xaf0wwrlEycAU0rwKEaCawS');

-- Cria tabela perfis
CREATE TABLE perfis (id VARCHAR(50) PRIMARY KEY, nome VARCHAR(100) NOT NULL);

-- Insere alguns perfis 
INSERT INTO perfis VALUES ('1e9d3894-015e-4d82-8506-6b8a0941ab2a', 'ADMIN');
INSERT INTO perfis VALUES ('711917da-d066-4b52-a82c-c823667de2ba', 'USER');

-- Adiciona a coluna id_perfil à tabela usuarios
ALTER TABLE usuarios ADD COLUMN id_perfil VARCHAR(100);
ALTER TABLE usuarios ADD CONSTRAINT fk_usuario_perfil FOREIGN KEY (id_perfil) REFERENCES perfis (id);

-- Altera perfis dos usuários para o perfil usuario
UPDATE usuarios SET id_perfil = '711917da-d066-4b52-a82c-c823667de2ba';