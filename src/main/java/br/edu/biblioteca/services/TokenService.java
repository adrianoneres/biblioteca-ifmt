package br.edu.biblioteca.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.edu.biblioteca.entities.Usuario;

@Service
public class TokenService {

  public String gerarToken(Usuario usuario) {
    return JWT.create()
              .withIssuer("biblioteca-ifmt")
              .withSubject(usuario.getId())
              .withClaim("nome", usuario.getNomeUsuario())
              .withExpiresAt(new Date())
              .sign(Algorithm.HMAC256("segredo"));
  }
}
