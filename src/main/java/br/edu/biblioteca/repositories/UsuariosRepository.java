package br.edu.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.biblioteca.entities.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, String> {
  Usuario findByNomeUsuario(String nomeUsuario);

  @Query("FROM Usuario u WHERE u.perfil.id = :idPerfil")
  List<Usuario> listarUsuariosPorPerfil(String idPerfil);
}
