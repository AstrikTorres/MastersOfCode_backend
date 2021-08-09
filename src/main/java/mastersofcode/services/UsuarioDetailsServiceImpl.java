package mastersofcode.services;

import mastersofcode.models.UsuariosModel;
import mastersofcode.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	private UsuarioRepository usuarioRepository;

	public UsuarioDetailsServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuariosModel usuariosModel = usuarioRepository.findByUsername(username);
		if (usuariosModel == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuariosModel.getUsername(), usuariosModel.getPassword(), emptyList());
	}

	public boolean deleteUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception error) {
			return false;
		}
	}

}
