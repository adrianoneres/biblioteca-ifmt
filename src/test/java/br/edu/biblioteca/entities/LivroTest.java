package br.edu.biblioteca.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LivroTest {
  
  @Test
  public void deveTerUmIdAoCriarLivro() {
    Livro novoLivro = new Livro();
    
    Assertions.assertNotNull(novoLivro.getId());
  }

  @Test
  public void deveTerIdTituloEAutorAoCriarLivro() {
    Livro novoLivro = new Livro("O Retrato de Dorian Gray", "Oscar Wilde");
    
    Assertions.assertNotNull(novoLivro.getId());
    Assertions.assertEquals("O Retrato de Dorian Gray", novoLivro.getTitulo());
    Assertions.assertEquals("Oscar Wilde", novoLivro.getAutor());
  }
}
