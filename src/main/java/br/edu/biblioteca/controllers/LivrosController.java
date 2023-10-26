package br.edu.biblioteca.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.biblioteca.entities.Livro;
import br.edu.biblioteca.services.LivrosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@SecurityRequirement(name = "biblioteca-seguranca")
@RestController
@RequestMapping("/livros")
public class LivrosController {

  private final LivrosService livrosService;

  public LivrosController(LivrosService livrosService) {
    this.livrosService = livrosService;
  }

  @PostMapping
  public ResponseEntity<Livro> criar(@RequestBody @Valid Livro novoLivro) {
    Livro livro = livrosService.criarLivro(novoLivro);
    return ResponseEntity.status(201).body(livro);
  }

  @GetMapping
  public ResponseEntity<List<Livro>> listar(@RequestParam(defaultValue = "") String filtro) {
    List<Livro> listaLivros = livrosService.listarLivros(filtro);
    return ResponseEntity.status(200).body(listaLivros);
  }
  
  @Operation(summary = "Busca um livro por ID")
  @RolesAllowed("USER")
  @GetMapping("/{id}")
  public ResponseEntity<Livro> buscar(@PathVariable String id) {
    Livro livro = livrosService.buscarLivro(id);
    return ResponseEntity.status(200).body(livro);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Livro> editar(
    @PathVariable String id, 
    @RequestBody Livro livroEditado
  ) {
    Livro livroSelecionado = livrosService.editarLivro(id, livroEditado);
    return ResponseEntity.status(200).body(livroSelecionado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable String id) {
    livrosService.excluirLivro(id);
    return ResponseEntity.status(204).build();
  }
}
