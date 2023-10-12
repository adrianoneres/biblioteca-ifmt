package br.edu.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.biblioteca.entities.Livro;

public interface LivrosRepository extends JpaRepository<Livro, String> {

  List<Livro> findAllByTituloContainingIgnoreCase(String titulo);
}
