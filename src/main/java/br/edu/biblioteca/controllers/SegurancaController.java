package br.edu.biblioteca.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.services.TokenService;

@RestController
@RequestMapping("/seguranca")
public class SegurancaController {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  public SegurancaController(AuthenticationManager authenticationManager, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }  

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody Usuario body) {
    UsernamePasswordAuthenticationToken authenticationToken = 
      new UsernamePasswordAuthenticationToken(body.getNomeUsuario(), body.getSenha());

    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    Usuario usuario = (Usuario) authentication.getPrincipal();
    String token = tokenService.gerarToken(usuario);

    return ResponseEntity.ok().body(token);
  }
  
}
