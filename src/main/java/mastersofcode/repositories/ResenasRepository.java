package mastersofcode.repositories;

import mastersofcode.models.ResenasModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ResenasRepository extends CrudRepository<ResenasModel, Long> {

    public abstract ArrayList<ResenasModel> findByCalificacion(String Calificacion);
}
