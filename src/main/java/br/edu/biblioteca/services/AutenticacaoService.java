package br.edu.biblioteca.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}
