package br.edu.biblioteca.dtos;

public class UsuarioResponseDto {
  private String id;
  private String nomeUsuario;
  private String perfil;

  public UsuarioResponseDto() {
  }

  public UsuarioResponseDto(String id, String nomeUsuario, String perfil) {
    this.id = id;
    this.nomeUsuario = nomeUsuario;
    this.perfil = perfil;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNomeUsuario() {
    return this.nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getPerfil() {
    return this.perfil;
  }

  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }
}
