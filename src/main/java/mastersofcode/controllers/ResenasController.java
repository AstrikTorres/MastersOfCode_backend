package mastersofcode.controllers;

import mastersofcode.models.ResenasModel;
import mastersofcode.services.ResenasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/resenas")
public class ResenasController {

    @Autowired
    ResenasService resenasService;

    @GetMapping
    public ArrayList<ResenasModel> getResenas() {
        return resenasService.getResenas();
    }

    @PostMapping
    public ResenasModel saveReseña(@RequestBody ResenasModel resena) {
        return resenasService.saveResena(resena);
    }

    @GetMapping(path = "/{id}")
    public Optional<ResenasModel> getResenasById(@PathVariable("id") Long id) {
        return resenasService.getResenaById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteResena(@PathVariable("id") Long id) {
        boolean ok = resenasService.deleteResena(id);

        // ok == true es igual a ok
        if (ok) {
            return "Se eliminó el usuario";
        } else {
            return "No se pudo eliminar el usuario";
        }
    }

    @GetMapping("/calificacion")
    public ArrayList<ResenasModel> getResenasByCalificacion
            (@RequestParam(value = "calificacion", defaultValue = "") String calificacion) {
        return resenasService.getResenasByCalificacion(calificacion);
    }
}
