package br.edu.biblioteca.controllers;

import java.util.List;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.edu.biblioteca.entities.Livro;
import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.repositories.LivrosRepository;
import br.edu.biblioteca.repositories.UsuariosRepository;
import br.edu.biblioteca.services.TokenService;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LivrosControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private UsuariosRepository usuariosRepository;

  @Autowired
  private LivrosRepository livrosRepository;

  @Autowired
  private TokenService tokenService;

  @Test
  public void deveListarTodosOsLivros() throws Exception {
    Usuario usuario = usuariosRepository.findByNomeUsuario("teste");
    String token = tokenService.gerarToken(usuario);
    String authorization = "Bearer " + token;
    List<Livro> livros = livrosRepository.findAll();
    String resposta = new JSONArray(livros).toString();

    mockMvc
      .perform(MockMvcRequestBuilders.get("/livros")
        .header("Authorization", authorization))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().json(resposta));
  }
}
