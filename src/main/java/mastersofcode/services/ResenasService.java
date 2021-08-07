package mastersofcode.services;

import mastersofcode.models.ResenasModel;
import mastersofcode.repositories.ResenasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ResenasService {

    @Autowired
    ResenasRepository resenasRepository;

    public ArrayList<ResenasModel> getResenas() {
        return (ArrayList<ResenasModel>) resenasRepository.findAll();
    }

    public ResenasModel saveResena(ResenasModel resena) {
        String resumen = resena.getResumen();
        String opinion = resena.getOpinion();
        int calificacion = resena.getCalificacion();

        if (calificacion > 0 && resumen != null && opinion != null) {
            return resenasRepository.save(resena);
        }
        return resena;
    }

    public Optional<ResenasModel> getResenaById(long id) {
        return resenasRepository.findById(id);
    }

    public boolean deleteResena(Long id) {
        try {
            resenasRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public ArrayList<ResenasModel> getResenasByCalificacion(String calificacion) {
        return resenasRepository.findByCalificacion(calificacion);
    }
}
