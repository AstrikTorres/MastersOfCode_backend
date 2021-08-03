package mastersofcode.services;

import mastersofcode.models.ExperienciaModel;
import mastersofcode.repositories.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    public ArrayList<ExperienciaModel> getExperiencia() {
        return (ArrayList<ExperienciaModel>) experienciaRepository.findAll();
    }

    public ExperienciaModel saveExperiencia(ExperienciaModel experiencia) {
        String puesto = experiencia.getPuesto();
        String empresa = experiencia.getEmpresa();
        String descripcion = experiencia.getDescripcion();

        if ( puesto != null && empresa != null && descripcion != null) {
            return experienciaRepository.save(experiencia);
        }

        return experiencia;
    }

    public Optional<ExperienciaModel> getExperienciaById(long id) {
        return experienciaRepository.findById(id);
    }

    public boolean deleteExperiencia(Long id) {
        try {
            experienciaRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public ArrayList<ExperienciaModel> getExperienciaByPuesto(String puesto) {
        return experienciaRepository.findByPuesto(puesto);
    }
}
