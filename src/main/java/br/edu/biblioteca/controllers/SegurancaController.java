package br.edu.biblioteca.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.biblioteca.dtos.UsuarioRequestDto;
import br.edu.biblioteca.entities.Login;
import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.services.AutenticacaoService;
import br.edu.biblioteca.services.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/seguranca")
public class SegurancaController {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;
  private final AutenticacaoService autenticacaoService;

  public SegurancaController(AuthenticationManager authenticationManager, TokenService tokenService, AutenticacaoService autenticacaoService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
    this.autenticacaoService = autenticacaoService;
  }  

  @PostMapping("/login")
  public ResponseEntity<Login> login(@RequestBody UsuarioRequestDto body) {
    UsernamePasswordAuthenticationToken authenticationToken = 
      new UsernamePasswordAuthenticationToken(body.getNomeUsuario(), body.getSenha());

    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    Usuario usuario = (Usuario) authentication.getPrincipal();
    String token = tokenService.gerarToken(usuario);

    return ResponseEntity.ok().body(new Login(token));
  }
  
  @PostMapping("/sign-up")
  public ResponseEntity<Void> signUp(@RequestBody @Valid Usuario novoUsuario) {
    autenticacaoService.criarUsuario(novoUsuario);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
