package br.edu.biblioteca.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.biblioteca.dtos.PerfilResponseDto;
import br.edu.biblioteca.dtos.UsuarioResponseDto;
import br.edu.biblioteca.entities.Perfil;
import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.services.AutenticacaoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;

@SecurityRequirement(name = "biblioteca-seguranca")
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

  @RolesAllowed("ADMIN")
  @GetMapping("/perfis/{id}")
  public ResponseEntity<PerfilResponseDto> buscarPerfil(@PathVariable String id) {
    Perfil perfil = autenticacaoService.buscarPerfilPorId(id);
    List<Usuario> usuarios = autenticacaoService.buscarUsuariosPorPerfil(perfil);
    List<String> nomesUsuarios = usuarios.stream().map(Usuario::getNomeUsuario).toList();

    PerfilResponseDto response = new PerfilResponseDto(perfil.getId(), perfil.getNome(), nomesUsuarios);

    return ResponseEntity.ok().body(response);
  }
}
