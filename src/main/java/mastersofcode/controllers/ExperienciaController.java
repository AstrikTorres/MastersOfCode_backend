package mastersofcode.controllers;

import mastersofcode.models.EducacionModel;
import mastersofcode.models.ExperienciaModel;
import mastersofcode.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping
    public ArrayList<ExperienciaModel> getExperiencia() {
        return experienciaService.getExperiencia();
    }

    @PostMapping
    public ExperienciaModel saveExperiencia(@RequestBody ExperienciaModel experiencia) {
        return experienciaService.saveExperiencia(experiencia);
    }

    @GetMapping(path = "/{id}")
    public Optional<ExperienciaModel> getExperienciaById(@PathVariable("id") Long id) {
        return experienciaService.getExperienciaById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteExperiencia(@PathVariable("id") Long id) {
        boolean ok = experienciaService.deleteExperiencia(id);

        // ok == true es igual a ok
        if (ok) {
            return "Se eliminó el usuario";
        } else {
            return "No se pudo eliminar el usuario";
        }
    }

    @GetMapping("/query")
    public ArrayList<ExperienciaModel> getExperienciaByPuesto
            (@RequestParam(value = "name", defaultValue = "") String name) {
        return experienciaService.getExperienciaByPuesto(name);
    }
}
