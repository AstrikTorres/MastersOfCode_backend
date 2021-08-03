package mastersofcode.controllers;

import mastersofcode.models.EducacionModel;
import mastersofcode.models.ProyectosModel;
import mastersofcode.services.ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/proyectos")
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping
    public ArrayList<ProyectosModel> getProyectos() {
        return proyectosService.getProyectos();
    }

    @PostMapping
    public ProyectosModel saveProyecto(@RequestBody ProyectosModel proyecto) {
        return proyectosService.saveProyecto(proyecto);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProyectosModel> getProyectoById(@PathVariable("id") Long id) {
        return proyectosService.getProyectoById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProyecto(@PathVariable("id") Long id) {
        boolean ok = proyectosService.deleteProyecto(id);

        // ok == true es igual a ok
        if (ok) {
            return "Se eliminó el usuario";
        } else {
            return "No se pudo eliminar el usuario";
        }
    }

    @GetMapping("/titulo")
    public ArrayList<ProyectosModel> getProyectoByTitulo
            (@RequestParam(value = "titulo", defaultValue = "") String titulo) {
        return proyectosService.getProyectoByTitulo(titulo);
    }

    @GetMapping("/valoracion")
    public ArrayList<ProyectosModel> getByTituloOrderByValoracion
            (@RequestParam(value = "titulo", defaultValue = "") String titulo) {
        return proyectosService.getProyectoByTituloContainingOrderByValoracionDesc(titulo);
    }
}
