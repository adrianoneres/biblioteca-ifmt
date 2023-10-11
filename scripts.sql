-- Referências:
--    - Listar todas as bases: \l
--    - Conectar à uma base:: \c nome-da-base
--    - Listar todas as tabelas de uma base: \dt

-- Cria schema
CREATE DATABASE "biblioteca-ifmt";

-- Cria tabela livros:
CREATE TABLE livros (id UUID PRIMARY KEY, titulo VARCHAR(100) NOT NULL, autor VARCHAR(100) NOT NULL);

-- Insere alguns livros:
INSERT INTO livros VALUES ('cff21df5-f959-4630-a3a1-f6b272951800', 'Dracula', 'Bram Stoker');
INSERT INTO livros VALUES ('6b8328bc-2daf-4782-9350-87226ee5ee4e', 'Hamlet', 'William Shakespeare');
INSERT INTO livros VALUES ('5bb56b52-afbd-4d1d-9133-1b19175aed7d', 'Crime e Castigo', 'Fiódor Dostoiévski');
INSERT INTO livros VALUES ('6c59ad1b-1b9d-47d4-a98c-b74410cc039a', 'Anna Karênina', 'Liev Tolstói');