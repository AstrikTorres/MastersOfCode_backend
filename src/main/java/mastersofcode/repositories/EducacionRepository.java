package mastersofcode.repositories;

import mastersofcode.models.EducacionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EducacionRepository extends CrudRepository<EducacionModel, Long> {

    public abstract ArrayList<EducacionModel> findByGradoAcademico(String grado_academico);

}
