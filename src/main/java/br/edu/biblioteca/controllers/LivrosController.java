package br.edu.biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.biblioteca.entities.Livro;

@RestController
@RequestMapping("/livros")
public class LivrosController {

  List<Livro> listaLivros = new ArrayList<>();

  @PostMapping
  public ResponseEntity criar(@RequestBody Livro novoLivro) {
    listaLivros.add(novoLivro);
    return ResponseEntity.status(201).body(novoLivro);
  }
  
}
