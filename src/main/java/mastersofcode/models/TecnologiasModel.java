package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tecnologias")
public class TecnologiasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 50)
    private String tecnologia;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ProyectosModel proyectos;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UsuariosModel usuarios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public ProyectosModel getProyectos() {
        return proyectos;
    }

    public void setProyectos(ProyectosModel proyectos) {
        this.proyectos = proyectos;
    }

    public UsuariosModel getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosModel usuarios) {
        this.usuarios = usuarios;
    }
}
