package br.edu.biblioteca.entities;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

// POJO - Plain Old Java Object
public class Livro {
  private String id;

  @NotEmpty
  private String titulo;

  @NotEmpty
  private String autor;

  public Livro() {
    this.id = UUID.randomUUID().toString();
  }

  public Livro(String titulo, String autor) {
    this.id = UUID.randomUUID().toString();
    this.titulo = titulo;
    this.autor = autor;
  }

  // acessor - getter
  public String getId() {
    return id;
  }
  
  // modificador - setter
  public void setId(String id) {
    this.id = id;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return this.autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }
}
