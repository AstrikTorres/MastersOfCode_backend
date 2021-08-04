package mastersofcode.controllers;

import mastersofcode.models.SolicitudesModel;
import mastersofcode.services.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudesController {

    @Autowired
    SolicitudesService solicitudesService;

    @GetMapping
    public ArrayList<SolicitudesModel> getProyectos() {
        return solicitudesService.getSolicitudes();
    }

    @PostMapping
    public SolicitudesModel saveSolicitud(@RequestBody SolicitudesModel solicitud) {
        return solicitudesService.saveSolicitud(solicitud);
    }

    @GetMapping(path = "/{id}")
    public Optional<SolicitudesModel> getSolicitudById(@PathVariable("id") Long id) {
        return solicitudesService.getSolicitudById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteSolicitud(@PathVariable("id") Long id) {
        boolean ok = solicitudesService.deleteSolicitud(id);

        // ok == true es igual a ok
        if (ok) {
            return "Se eliminó el usuario";
        } else {
            return "No se pudo eliminar el usuario";
        }
    }

    @GetMapping("/nombre")
    public ArrayList<SolicitudesModel> getSolicitudByNombre
            (@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        return solicitudesService.getSolicitudByNombre(nombre);
    }

    @GetMapping("/recientes")
    public ArrayList<SolicitudesModel> getByNombreContainingOrderByIdDesc
            (@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        return solicitudesService.getSolicitudByNombreContainingOrderByIdDesc(nombre);
    }
}
