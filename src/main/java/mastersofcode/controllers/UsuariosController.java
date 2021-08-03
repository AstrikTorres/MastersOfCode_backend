package mastersofcode.controllers;

import mastersofcode.models.UsuariosModel;
import mastersofcode.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    // ruta: /user
    @GetMapping
    public ArrayList<UsuariosModel> getUsers() {
        return usuariosService.getUsers();
    }

    @PostMapping
    public UsuariosModel saveUser(@RequestBody UsuariosModel user) {
        return usuariosService.saveUser(user);
    }

    // ruta: /user/id
    @GetMapping(path = "/{id}")
    public Optional<UsuariosModel> getUserById(@PathVariable("id") Long id) {
        return usuariosService.getUserById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean ok = usuariosService.deleteUser(id);

        // ok == true es igual a ok
        if (ok) {
            return "Se eliminó el usuario";
        } else {
            return "No se pudo eliminar el usuario";
        }
    }

    // ruta: /user/query
    @GetMapping("/query")
    public ArrayList<UsuariosModel> getUsersByName
    (@RequestParam(value = "name", defaultValue = "") String name) {
        return usuariosService.getUsersByName(name);
    }

}