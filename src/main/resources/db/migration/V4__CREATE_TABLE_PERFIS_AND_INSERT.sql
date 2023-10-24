-- Cria tabela perfis
CREATE TABLE perfis (id VARCHAR(50) PRIMARY KEY, nome VARCHAR(100) NOT NULL);

-- Insere alguns perfis 
INSERT INTO perfis VALUES ('1e9d3894-015e-4d82-8506-6b8a0941ab2a', 'ADMIN');
INSERT INTO perfis VALUES ('711917da-d066-4b52-a82c-c823667de2ba', 'USER');