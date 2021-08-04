package mastersofcode.controllers;

import mastersofcode.models.ProyectosModel;
import mastersofcode.models.TecnologiasModel;
import mastersofcode.services.TecnologiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tecnologia")
public class TecnologiasController {

    @Autowired
    TecnologiasService tecnologiasService;

    @GetMapping
    public ArrayList<TecnologiasModel> getTecnologias() {
        return tecnologiasService.getTecnologias();
    }

    @PostMapping
    public TecnologiasModel saveTecnologia(@RequestParam TecnologiasModel tecnologia) {
        return tecnologiasService.saveTecnologia(tecnologia);
    }

    @GetMapping(path = "/{id}")
    public Optional<TecnologiasModel> getTecnologiaById(@PathVariable("id") Long id) {
        return tecnologiasService.getTecnologiaById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTecnologia(@PathVariable("id") Long id) {
        boolean ok = tecnologiasService.deleteTecnologia(id);

        if (ok) {
            return "Se elimino la tecnologia";
        } else {
            return "No se pudo eliminar";
        }
    }

    @GetMapping("/nombre")
    public ArrayList<TecnologiasModel> getTecnologiaByNombre
            (@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        return tecnologiasService.getTecnologiaByTecnologia(nombre);
    }
}
