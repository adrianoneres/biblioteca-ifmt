package br.edu.biblioteca.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.auth0.jwt.exceptions.JWTDecodeException;

import br.edu.biblioteca.entities.Erro;

@RestControllerAdvice
public class ResourceExceptionHandler {

  private final MessageSource messageSource;

  public ResourceExceptionHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  @ExceptionHandler(RegistroNaoEncontradoException.class)
  public Erro tratarExcecao(RegistroNaoEncontradoException exception, Locale locale) {
    // String mensagem = exception.getMessage();
    String chave = exception.getMessage();
    String[] argumentos = exception.getArgumentos();
    String mensagem = messageSource.getMessage(chave, argumentos, locale);
    return new Erro(mensagem);
  }

  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(NaoAutorizadoException.class)
  public Erro tratarExcecao(NaoAutorizadoException exception, Locale locale) {
    String chave = exception.getMessage();
    String mensagem = messageSource.getMessage(chave, null, locale);
    return new Erro(mensagem);
  }

  @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(NegocioException.class)
  public Erro tratarExcecao(NegocioException exception, Locale locale) {
    String chave = exception.getMessage();
    String mensagem = messageSource.getMessage(chave, null, locale);
    return new Erro(mensagem);
  }

  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(JWTDecodeException.class)
  public Erro tratarExcecao(JWTDecodeException exception, Locale locale) {
    String chave = "erro.naoAutorizado";
    String mensagem = messageSource.getMessage(chave, null, locale);
    return new Erro(mensagem);
  }
  
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ArithmeticException.class)
  public Erro tratarExcecao(ArithmeticException exception) {
    String mensagem = exception.getMessage();
    return new Erro(mensagem);
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<Erro> tratarExcecao(MethodArgumentNotValidException exception) {
    List<Erro> erros = new ArrayList<>();
    List<FieldError> errosValidacao = exception.getBindingResult().getFieldErrors();
    
    errosValidacao.forEach(item -> {
      String mensagem = item.getField() + " " + item.getDefaultMessage();
      erros.add(new Erro(mensagem));
    });

    return erros;
  }
}
