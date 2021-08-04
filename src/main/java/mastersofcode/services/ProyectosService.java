package mastersofcode.services;

import mastersofcode.models.ProyectosModel;
import mastersofcode.repositories.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProyectosService {

    @Autowired
    ProyectosRepository proyectosRepository;

    public ArrayList<ProyectosModel> getProyectos() {
        return (ArrayList<ProyectosModel>) proyectosRepository.findAll();
    }

    public ProyectosModel saveProyecto(ProyectosModel proyecto) {
        String titulo = proyecto.getTitulo();
        String descripcion = proyecto.getDescripcion();

        if (titulo != null && descripcion != null) {
            return proyectosRepository.save(proyecto);
        }

        return proyecto;
    }

    public Optional<ProyectosModel> getProyectoById(long id){
        return proyectosRepository.findById(id);
    }

    public boolean deleteProyecto(Long id) {
        try {
           proyectosRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public ArrayList<ProyectosModel> getProyectoByTitulo(String titulo) {
        return proyectosRepository.findByTitulo(titulo);
    }

}
