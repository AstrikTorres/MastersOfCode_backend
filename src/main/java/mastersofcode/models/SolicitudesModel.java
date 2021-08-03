package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;

@Entity
@Table(name = "solicitudes")
public class SolicitudesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 50)
    private String nombre_proyecto;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int presupuesto;

    // Verificar y generar get/setter
    @Column(nullable = false, length = 50)
    private String referencia_foto;

    @Column(nullable = false, length = 50)
    private String referencia_link;

    @Column(nullable = false, length = 50)
    private String tiempo_estimado;

    @ManyToOne
    @JsonIgnore
    private UsuariosModel usuarios;

    @OneToMany( targetEntity = PropuestasModel.class, mappedBy = "solicitudes")
    private List<PropuestasModel> propuestas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getReferencia_foto() {
        return referencia_foto;
    }

    public void setReferencia_foto(String referencia_foto) {
        this.referencia_foto = referencia_foto;
    }

    public String getReferencia_link() {
        return referencia_link;
    }

    public void setReferencia_link(String referencia_link) {
        this.referencia_link = referencia_link;
    }

    public String getTiempo_estimado() {
        return tiempo_estimado;
    }

    public void setTiempo_estimado(String tiempo_estimado) {
        this.tiempo_estimado = tiempo_estimado;
    }
}
