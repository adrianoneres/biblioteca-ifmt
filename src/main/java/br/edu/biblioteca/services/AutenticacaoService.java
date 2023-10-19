package br.edu.biblioteca.services;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.exceptions.NegocioException;
import br.edu.biblioteca.repositories.UsuariosRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

  private final UsuariosRepository usuariosRepository;

  public AutenticacaoService(UsuariosRepository usuariosRepository) {
    this.usuariosRepository = usuariosRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return usuariosRepository.findByNomeUsuario(username);
  }

  public void criarUsuario(Usuario usuario) {
    Usuario usuarioExistente = usuariosRepository.findByNomeUsuario(usuario.getNomeUsuario());

    if (usuarioExistente != null) {
      throw new NegocioException("erro.usuarioJaCadastrado");
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String senhaCriptografada = encoder.encode(usuario.getSenha());
    usuario.setSenha(senhaCriptografada);
    usuario.setId(UUID.randomUUID().toString());

    usuariosRepository.save(usuario);
  }
}
