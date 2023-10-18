package br.edu.biblioteca.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.edu.biblioteca.entities.Usuario;

@Service
public class TokenService {

  private final static String SECRET = "segredo";

  public String gerarToken(Usuario usuario) {
    return JWT.create()
              .withIssuer("biblioteca-ifmt")
              .withSubject(usuario.getId())
              .withClaim("nome", usuario.getNomeUsuario())
              .withExpiresAt(segundosNoFuturo(3600))
              .sign(Algorithm.HMAC256(SECRET));
  }

  private Instant segundosNoFuturo(long segundos) {
    return LocalDateTime.now().plusSeconds(segundos).atZone(ZoneId.of("-04:00")).toInstant();
  }
}
