package mastersofcode.repositories;

import mastersofcode.models.ProyectosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProyectosRepository extends CrudRepository<ProyectosModel, Long> {

    public abstract Optional<ProyectosModel> findByTitulo(String titulo);

}
