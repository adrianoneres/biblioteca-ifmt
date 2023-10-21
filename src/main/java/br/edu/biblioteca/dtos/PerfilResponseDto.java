package br.edu.biblioteca.dtos;

import java.util.List;

public class PerfilResponseDto {
  private String id;
  private String nome;
  private List<String> usuarios;

  public PerfilResponseDto() {
  }

  public PerfilResponseDto(String id, String nome, List<String> usuarios) {
    this.id = id;
    this.nome = nome;
    this.usuarios = usuarios;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<String> getUsuarios() {
    return this.usuarios;
  }

  public void setUsuarios(List<String> usuarios) {
    this.usuarios = usuarios;
  }
}
