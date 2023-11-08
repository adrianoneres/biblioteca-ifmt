package br.edu.biblioteca.configurations;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.exceptions.NaoAutorizadoException;
import br.edu.biblioteca.repositories.UsuariosRepository;
import br.edu.biblioteca.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AutenticacaoFilter extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final UsuariosRepository usuariosRepository;
  private final HandlerExceptionResolver handlerExceptionResolver;

  public AutenticacaoFilter(TokenService tokenService, UsuariosRepository usuariosRepository, HandlerExceptionResolver handlerExceptionResolver) {
    this.tokenService = tokenService;
    this.usuariosRepository = usuariosRepository;
    this.handlerExceptionResolver = handlerExceptionResolver;
  }

  @Override
  protected void doFilterInternal(
    HttpServletRequest request, 
    HttpServletResponse response, 
    FilterChain filterChain
  ) throws ServletException, IOException {
    String metodo = request.getMethod();
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Credentials", "true");

    if (!metodo.equalsIgnoreCase("OPTIONS")) {
      try {
        // 1 - Verificar se a rota exige autenticação:
        String contexto = request.getServletPath();
        Boolean exigeAutenticacao = 
        !contexto.startsWith("/seguranca") && 
        !contexto.startsWith("/swagger-ui") &&
        !contexto.startsWith("/v3/api-docs");
        
        if (exigeAutenticacao) {
          // 2 - Recuperar o token do cabeçalho "Authorization":
          String authorizationHeader = request.getHeader("Authorization");
          
          if (authorizationHeader == null || authorizationHeader.isEmpty()) {
            // throw new NaoAutorizadoException();
          }
          
          // 3 - Separar a palavra "Bearer" do Token JWT e validar somente o token:
          String token = authorizationHeader.replace("Bearer ", "");
          
          // 4 - Verificar se o valor do cabeçalho é um token JWT válido:
          String subject = tokenService.validarEObterSubject(token);
          
          // 5 - Verificar o "subject" contém um identificar válido de um usuário:
          Usuario usuario = usuariosRepository
          .findById(subject)
          .orElseThrow(() -> new NaoAutorizadoException());
          
          // 6 - Montar o objeto de autenticação e delegar a validação para o Spring Boot:
          UsernamePasswordAuthenticationToken authenticationToken = 
          new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
          
          SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        
        filterChain.doFilter(request, response);
      } catch (Exception exception) {
        handlerExceptionResolver.resolveException(request, response, null, exception);
      }
    } else {
      response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers", "authorization, content-type," +
              "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
      response.setStatus(HttpServletResponse.SC_OK);
    }
  }
}
