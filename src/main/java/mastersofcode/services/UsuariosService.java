package mastersofcode.services;

import mastersofcode.models.UsuariosModel;
import mastersofcode.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    public ArrayList<UsuariosModel> getUsers() {
        return (ArrayList<UsuariosModel>) usuariosRepository.findAll();
    }

    public UsuariosModel saveUser(UsuariosModel usuario) {
        String name = usuario.getName();
        String password = usuario.getPassword();
        String email = usuario.getEmail();
        String username = usuario.getUsername();
        String ciudad = usuario.getCiudad();
        String rol = usuario.getRol();

        if(name != null && password != null && email != null &&
        username != null && ciudad != null && rol != null) {
            return usuariosRepository.save(usuario);
        }

        return usuario;
    }

    public Optional<UsuariosModel> getUserById(Long id) {
        return usuariosRepository.findById(id);
    }

    public boolean deleteUser(Long id) {
        try {
            usuariosRepository.deleteById(id);
            return  true;
        } catch (Exception error) {
            return false;
        }
    }

    public ArrayList<UsuariosModel> getUsersByName(String name) {
        return  usuariosRepository.findByName(name);
    }

}
