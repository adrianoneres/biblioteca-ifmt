package br.edu.biblioteca.exceptions;

public class NaoAutorizadoException extends RuntimeException {
  public NaoAutorizadoException() {
    super("erro.naoAutorizado");
  }  
}
