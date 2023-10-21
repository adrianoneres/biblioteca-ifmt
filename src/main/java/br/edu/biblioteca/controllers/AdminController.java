package br.edu.biblioteca.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.biblioteca.dtos.UsuarioResponseDto;
import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.services.AutenticacaoService;
import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/admin")
public class AdminController {

  private final AutenticacaoService autenticacaoService;

  public AdminController(AutenticacaoService autenticacaoService) {
    this.autenticacaoService = autenticacaoService;
  }

  @RolesAllowed("ADMIN")
  @GetMapping("/usuarios/{id}")
  public ResponseEntity<UsuarioResponseDto> buscarUsuario(@PathVariable String id) {
    Usuario usuario = autenticacaoService.buscarUsuarioPorId(id);

    UsuarioResponseDto response = new UsuarioResponseDto(usuario.getId(), usuario.getNomeUsuario(), usuario.getPerfil().getNome());

    return ResponseEntity.ok().body(response);
  }
}
