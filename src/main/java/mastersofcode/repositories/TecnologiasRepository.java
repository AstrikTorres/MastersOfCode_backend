package mastersofcode.repositories;

import mastersofcode.models.TecnologiasModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TecnologiasRepository  extends CrudRepository<TecnologiasModel, Long> {

    public abstract ArrayList<TecnologiasModel> findByTecnologia(String tecnologia);
}
