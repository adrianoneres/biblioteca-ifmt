package br.edu.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.biblioteca.entities.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, String> {

  Usuario findByNomeUsuario(String nomeUsuario);
}
