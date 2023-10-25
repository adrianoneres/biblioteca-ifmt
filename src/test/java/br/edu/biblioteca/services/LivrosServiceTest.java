package br.edu.biblioteca.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.edu.biblioteca.entities.Livro;
import br.edu.biblioteca.exceptions.RegistroNaoEncontradoException;
import br.edu.biblioteca.repositories.LivrosRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LivrosServiceTest {

  @Autowired
  private LivrosService livrosService;

  @Autowired
  private LivrosRepository livrosRepository;

  @BeforeEach
  public void limparDados() {
    livrosRepository.deleteAll();
  }

  @Test
  public void deveListarTodosOsLivros() {
    // Given - pré-condições
    Livro livro = new Livro("Hamlet", "William Shakespeare");
    livrosRepository.save(livro);

    // When - o que está sendo testado
    List<Livro> livros = livrosService.listarLivros("");

    // Then - as verificações
    Assertions.assertEquals(1, livros.size());
  }

  @Test
  public void deveRetornarLivroExistente() {
    // Given
    Livro livro = new Livro("Hamlet", "William Shakespeare");
    livrosRepository.save(livro);

    // When
    Livro livroExistente = livrosService.buscarLivro(livro.getId());

    // Then
    Assertions.assertEquals(livro.getId(), livroExistente.getId());
    Assertions.assertEquals(livro.getTitulo(), livroExistente.getTitulo());
    Assertions.assertEquals(livro.getAutor(), livroExistente.getAutor());
  }

  @Test
  public void deveLancarExcecaoAoBuscarLivroInexistente() {
    Assertions.assertThrows(
      RegistroNaoEncontradoException.class, 
      () -> livrosService.buscarLivro("id-inexistente"));
  }

  @Test
  public void deveLancarExcecaoAoTentarEditarLivroInexistente() {
    Assertions.assertThrows(
      RegistroNaoEncontradoException.class, 
      () -> livrosService.editarLivro("id-inexistente", new Livro()));
  }

  @Test
  public void deveAlterarTituloEAutorDoLivro() {
    // Given
    Livro livro = new Livro("Hamlet", "William Shakespeare");
    livrosRepository.save(livro);

    // When
    livro.setTitulo("O Senhor dos Anéis - A Sociedade do Anel");
    livro.setAutor("J. R. R. Tolkien");

    livrosService.editarLivro(livro.getId(), livro);

    // Then
    Livro livroEditado = livrosRepository.findById(livro.getId()).get();
    
    Assertions.assertEquals(livro.getId(), livroEditado.getId());
    Assertions.assertEquals("O Senhor dos Anéis - A Sociedade do Anel", livroEditado.getTitulo());
    Assertions.assertEquals("J. R. R. Tolkien", livroEditado.getAutor());
  }
}
