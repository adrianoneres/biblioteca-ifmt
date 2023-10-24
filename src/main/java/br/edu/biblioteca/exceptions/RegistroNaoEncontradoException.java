package br.edu.biblioteca.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException {
  private String[] argumentos;

  public RegistroNaoEncontradoException() {
    super("erro.registroNaoEncontrado");
  }

  public RegistroNaoEncontradoException(String mensagem) {
    super(mensagem);
  }
  
  public RegistroNaoEncontradoException(String mensagem, String... argumentos) {
    super(mensagem);
    this.argumentos = argumentos;
  }

  public String[] getArgumentos() {
    return this.argumentos;
  }
}
