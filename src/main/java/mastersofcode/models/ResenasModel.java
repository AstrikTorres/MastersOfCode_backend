package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;

@Entity
@Table(name = "resenas")
public class ResenasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private int calificacion;

    @Column(nullable = false, length = 50)
    private String resumen;

    @Column(nullable = false)
    private String opinion;

    @ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    private ProyectosModel proyectos;

    @ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    private UsuariosModel usuarios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
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