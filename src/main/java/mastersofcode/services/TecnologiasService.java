package mastersofcode.services;

import mastersofcode.models.ProyectosModel;
import mastersofcode.models.TecnologiasModel;
import mastersofcode.repositories.TecnologiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TecnologiasService {

    @Autowired
    TecnologiasRepository tecnologiasRepository;

    public ArrayList<TecnologiasModel> getTecnologias() {
        return (ArrayList<TecnologiasModel>) tecnologiasRepository.findAll();
    }

    public TecnologiasModel saveTecnologia(TecnologiasModel tecnologia) {
        String titulo = tecnologia.getTecnologia();

        if (titulo != null) {
            return tecnologiasRepository.save(tecnologia);
        }
        return tecnologia;
    }

    public Optional<TecnologiasModel> getTecnologiaById(long id){
        return tecnologiasRepository.findById(id);
    }

    public boolean deleteTecnologia(Long id) {
        try {
            tecnologiasRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public ArrayList<TecnologiasModel> getTecnologiaByTecnologia(String tecnologia) {
        return tecnologiasRepository.findByTecnologia(tecnologia);
    }
}
