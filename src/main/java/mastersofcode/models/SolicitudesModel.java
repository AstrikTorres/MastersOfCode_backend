package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "solicitudes")
public class SolicitudesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String presupuesto;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UsuariosModel usuarios;

    @OneToMany( targetEntity = PropuestasModel.class, mappedBy = "solicitudes")
    private List<PropuestasModel> propuestas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public UsuariosModel getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosModel usuarios) {
        this.usuarios = usuarios;
    }

    public List<PropuestasModel> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(List<PropuestasModel> propuestas) {
        this.propuestas = propuestas;
    }
}
