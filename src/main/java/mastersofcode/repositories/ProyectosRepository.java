package mastersofcode.repositories;

import mastersofcode.models.ProyectosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProyectosRepository extends CrudRepository<ProyectosModel, Long> {

    public abstract ArrayList<ProyectosModel> findByTitulo(String titulo);

}
