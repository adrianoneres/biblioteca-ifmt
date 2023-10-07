package br.edu.biblioteca.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException {
  public RegistroNaoEncontradoException() {
    super("Registro não encontrado.");
  }

  public RegistroNaoEncontradoException(String mensagem) {
    super(mensagem);
  }
}
