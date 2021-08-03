package mastersofcode.repositories;

import mastersofcode.models.EducacionModel;
import mastersofcode.models.ExperienciaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ExperienciaRepository  extends CrudRepository<ExperienciaModel, Long> {

    public  abstract ArrayList<ExperienciaModel> findByPuesto(String descripcion);

}
