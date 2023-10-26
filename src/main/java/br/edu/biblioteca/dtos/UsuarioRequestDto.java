package br.edu.biblioteca.dtos;

import jakarta.validation.constraints.NotEmpty;

public class UsuarioRequestDto {

  @NotEmpty
  private String nomeUsuario;

  @NotEmpty
  private String senha;

  public String getNomeUsuario() {
    return this.nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
