package mastersofcode.services;

import mastersofcode.models.EducacionModel;
import mastersofcode.repositories.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    public ArrayList<EducacionModel> getEducacion() {
        return (ArrayList<EducacionModel>) educacionRepository.findAll();
    }

    public EducacionModel saveEducacion(EducacionModel educacion) {
        String gradoAcademico = educacion.getGradoAcademico();
        String institucion = educacion.getInstitucion();
        String descripcion = educacion.getDescripcion();

        if (gradoAcademico != null && institucion != null && descripcion != null) {
            return educacionRepository.save(educacion);
        }

        return educacion;
    }

    public Optional<EducacionModel> getEducacionById(long id){
        return educacionRepository.findById(id);
    }

    public boolean deleteEducacion(Long id) {
        try {
            educacionRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public ArrayList<EducacionModel> getEducacionByGradoAcademico(String gradoAcademico) {
        return educacionRepository.findByGradoAcademico(gradoAcademico);
    }
}
