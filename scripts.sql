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

-- Listar todos os registros da tabela livros
SELECT * FROM livros;

-- Buscar um registro por id na tabela livros
SELECT * FROM livros WHERE id = 'cff21df5-f959-4630-a3a1-f6b272951800';

-- Inserir um novo registro na tabela livros
INSERT INTO livros VALUES ('83ddd6fb-d25f-4aa5-9736-f29de81ff0b9', '1984', 'George Orwell');

-- Atualizar os dados de um registro
UPDATE livros SET titulo = 'Frankenstein', autor = 'Mary Shelley' WHERE id = '83ddd6fb-d25f-4aa5-9736-f29de81ff0b9';

-- Excluir um registro
DELETE FROM livros WHERE id = '83ddd6fb-d25f-4aa5-9736-f29de81ff0b9';

-- Cria tabela usuarios
CREATE TABLE usuarios (id VARCHAR(50) PRIMARY KEY, nome_usuario VARCHAR(100) NOT NULL, senha VARCHAR(100) NOT NULL);

-- Inserir um novo usuário com o nome de usuário teste e a senha 123
INSERT INTO usuarios VALUES ('e2550bf9-d644-4758-baa5-e047b0379c00', 'teste', '$2a$10$XXgjnZmYFG.t.ie03oopD.MpX.gdr8xaf0wwrlEycAU0rwKEaCawS');