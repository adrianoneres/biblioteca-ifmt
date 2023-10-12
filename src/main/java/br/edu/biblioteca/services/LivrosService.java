package br.edu.biblioteca.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.biblioteca.entities.Livro;
import br.edu.biblioteca.exceptions.RegistroNaoEncontradoException;
import br.edu.biblioteca.repositories.LivrosRepository;

@Service
public class LivrosService {

  private final LivrosRepository livrosRepository;
  
  public LivrosService(LivrosRepository livrosRepository) {
    this.livrosRepository = livrosRepository;
  }

  public Livro criarLivro(Livro novoLivro) {
    livrosRepository.save(novoLivro);
    return novoLivro;
  }

  public List<Livro> listarLivros(String filtro) {
    return livrosRepository.findAllByTituloContainingIgnoreCase(filtro);
  }

  public Livro buscarLivro(String id) {
    Livro livro = livrosRepository
      .findById(id)
      .orElseThrow(() -> new RegistroNaoEncontradoException("erro.registroNaoEncontradoComId", id));

    return livro;
  }
  
  public Livro editarLivro(String id, Livro livroEditado) {
    Livro livroSelecionado = livrosRepository
      .findById(id)
      .orElseThrow(() -> new RegistroNaoEncontradoException("erro.registroNaoEncontradoComId", id));

    livroSelecionado.setTitulo(livroEditado.getTitulo());
    livroSelecionado.setAutor(livroEditado.getAutor());

    livrosRepository.save(livroSelecionado);

    return livroSelecionado;
  }

  public void excluirLivro(String id) {
    Livro livro = livrosRepository
      .findById(id)
      .orElseThrow(() -> new RegistroNaoEncontradoException("erro.registroNaoEncontradoComId", id));

    livrosRepository.delete(livro);
  }
}
