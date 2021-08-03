package mastersofcode.repositories;

import mastersofcode.models.UsuariosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, Long> {

    public abstract ArrayList<UsuariosModel> findByName(String name);

}
