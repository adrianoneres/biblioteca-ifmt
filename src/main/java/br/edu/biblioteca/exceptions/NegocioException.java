package br.edu.biblioteca.exceptions;

public class NegocioException extends RuntimeException {

  public NegocioException() {
    super("erro.negocio");
  }
  
  public NegocioException(String mensagem) {
    super(mensagem);
  }
}
