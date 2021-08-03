package mastersofcode.controllers;

import mastersofcode.models.EducacionModel;
import mastersofcode.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/edu")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping
    public ArrayList<EducacionModel> getEducacion() {
        return educacionService.getEducacion();
    }

    @PostMapping
    public EducacionModel saveEducacion(@RequestBody EducacionModel educacion) {
        return educacionService.saveEducacion(educacion);
    }

    @GetMapping(path = "/{id}")
    public Optional<EducacionModel> getEducacionById(@PathVariable("id") Long id) {
        return educacionService.getEducacionById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteEducacion(@PathVariable("id") Long id) {
        boolean ok = educacionService.deleteEducacion(id);

        // ok == true es igual a ok
        if (ok) {
            return "Se eliminó el usuario";
        } else {
            return "No se pudo eliminar el usuario";
        }
    }

    @GetMapping("/query")
    public ArrayList<EducacionModel> getEducacionByGradoAcademico
            (@RequestParam(value = "name", defaultValue = "") String name) {
        return educacionService.getEducacionByGradoAcademico(name);
    }
}
