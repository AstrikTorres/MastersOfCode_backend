package mastersofcode.repositories;

import mastersofcode.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuariosModel, Long> {

	UsuariosModel findByUsername(String username);

}
