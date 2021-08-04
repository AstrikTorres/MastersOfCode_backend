package mastersofcode.repositories;

import mastersofcode.models.SolicitudesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SolicitudesRepository extends CrudRepository<SolicitudesModel, Long> {

    public abstract ArrayList<SolicitudesModel> findByNombre(String nombre);

    public abstract ArrayList<SolicitudesModel> findByNombreContainingOrderByIdDesc(String nombre);
}
