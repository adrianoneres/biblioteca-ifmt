package br.edu.biblioteca.entities;

public class Erro {
  private String mensagem;

  public Erro(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getMensagem() {
    return this.mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
}
