package mastersofcode.services;

import mastersofcode.models.SolicitudesModel;
import mastersofcode.repositories.SolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SolicitudesService {

    @Autowired
    SolicitudesRepository solicitudesRepository;

    public ArrayList<SolicitudesModel> getSolicitudes() {
        return (ArrayList<SolicitudesModel>) solicitudesRepository.findAll();
    }

    public SolicitudesModel saveSolicitud(SolicitudesModel solicitud) {
        String nombre = solicitud.getNombre();
        String descripcion = solicitud.getDescripcion();
        String presupuesto = solicitud.getPresupuesto();

        if (nombre != null && descripcion != null && presupuesto != null) {
            return solicitudesRepository.save(solicitud);
        }
        return solicitud;
    }

    public Optional<SolicitudesModel> getSolicitudById(long id) {
        return solicitudesRepository.findById(id);
    }

    public boolean deleteSolicitud(Long id) {
        try {
            solicitudesRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public ArrayList<SolicitudesModel> getSolicitudByNombre(String nombre) {
        return solicitudesRepository.findByNombre(nombre);
    }

    public ArrayList<SolicitudesModel> getSolicitudByNombreContainingOrderByIdDesc(String nombre) {
        return solicitudesRepository.findByNombreContainingOrderByIdDesc(nombre);
    }
}
