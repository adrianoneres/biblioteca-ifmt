-- Cria tabela usuarios
CREATE TABLE usuarios (id VARCHAR(50) PRIMARY KEY, nome_usuario VARCHAR(100) NOT NULL, senha VARCHAR(100) NOT NULL);

-- Inserir um novo usuário com o nome de usuário teste e a senha 123
INSERT INTO usuarios VALUES ('e2550bf9-d644-4758-baa5-e047b0379c00', 'teste', '$2a$10$XXgjnZmYFG.t.ie03oopD.MpX.gdr8xaf0wwrlEycAU0rwKEaCawS');
