package mastersofcode.controllers;

import mastersofcode.models.UsuariosModel;
import mastersofcode.repositories.UsuarioRepository;
import mastersofcode.services.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioDetailsServiceImpl usuarioDetailsService;

	private UsuarioRepository usuarioRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/users/")
	public void saveUsuario(@RequestBody UsuariosModel user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
	}

	@GetMapping("/users/")
	public List<UsuariosModel> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/users/{username}")
	public UsuariosModel getUsuario(@PathVariable String username) {
		return usuarioRepository.findByUsername(username);
	}

	@GetMapping("/user/auth")
	public UsuariosModel getAuthUser() {
		return usuarioRepository.findByUsername((String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()));

	}

	@DeleteMapping("/user/{id}")
	public String deleteUsuario(@PathVariable("id") Long id) {
		boolean ok = usuarioDetailsService.deleteUsuario(id);
		if (ok) {
			return "Se elimino el usuario";
		} else {
			return "No se pudo eliminar";
		}
	}

}
