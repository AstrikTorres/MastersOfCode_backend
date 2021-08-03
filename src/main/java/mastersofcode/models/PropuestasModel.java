package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "propuestas")
public class PropuestasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String descripcion_propuesta;

    @Column()
    private String imagen_propuesta;

    @ManyToOne
    @JsonIgnore
    private SolicitudesModel solicitudes;

    // Como conectar a usuarios


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion_propuesta() {
        return descripcion_propuesta;
    }

    public void setDescripcion_propuesta(String descripcion_propuesta) {
        this.descripcion_propuesta = descripcion_propuesta;
    }

    public String getImagen_propuesta() {
        return imagen_propuesta;
    }

    public void setImagen_propuesta(String imagen_propuesta) {
        this.imagen_propuesta = imagen_propuesta;
    }
}
