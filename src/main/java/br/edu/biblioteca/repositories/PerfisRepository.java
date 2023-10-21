package br.edu.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.biblioteca.entities.Perfil;

public interface PerfisRepository extends JpaRepository<Perfil, String> {
  
}
