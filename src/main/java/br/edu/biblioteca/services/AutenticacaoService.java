package br.edu.biblioteca.services;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.biblioteca.entities.Perfil;
import br.edu.biblioteca.entities.Usuario;
import br.edu.biblioteca.exceptions.NegocioException;
import br.edu.biblioteca.exceptions.RegistroNaoEncontradoException;
import br.edu.biblioteca.repositories.PerfisRepository;
import br.edu.biblioteca.repositories.UsuariosRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

  private final UsuariosRepository usuariosRepository;
  private final PerfisRepository perfisRepository;

  public AutenticacaoService(UsuariosRepository usuariosRepository, PerfisRepository perfisRepository) {
    this.usuariosRepository = usuariosRepository;
    this.perfisRepository = perfisRepository;
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

  public Usuario buscarUsuarioPorId(String id) {
    Usuario usuario = usuariosRepository
      .findById(id)
      .orElseThrow(() -> new RegistroNaoEncontradoException());

      return usuario;
  }

  public Perfil buscarPerfilPorId(String id) {
    Perfil perfil = perfisRepository
      .findById(id)
      .orElseThrow(() -> new RegistroNaoEncontradoException());

    return perfil;
  }

  public List<Usuario> buscarUsuariosPorPerfil(Perfil perfil) {
    List<Usuario> usuarios = usuariosRepository.listarUsuariosPorPerfil(perfil.getId());
    return usuarios;
  }
}
