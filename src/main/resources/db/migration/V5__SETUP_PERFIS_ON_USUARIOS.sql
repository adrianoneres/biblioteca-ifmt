-- Adiciona a coluna id_perfil à tabela usuarios
ALTER TABLE usuarios ADD COLUMN id_perfil VARCHAR(100);
ALTER TABLE usuarios ADD CONSTRAINT fk_usuario_perfil FOREIGN KEY (id_perfil) REFERENCES perfis (id);

-- Altera perfis dos usuários para o perfil usuario
UPDATE usuarios SET id_perfil = '711917da-d066-4b52-a82c-c823667de2ba';