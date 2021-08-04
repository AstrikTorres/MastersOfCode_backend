package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "resenas")
public class ResenasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 1)
    private int calificacion;

    @Column(nullable = false, length = 50)
    private String resumen;

    @Column(nullable = false)
    private String opinion;

    @ManyToOne
    @JsonIgnore
    private ProyectosModel proyectos;

    @ManyToOne
    @JsonIgnore
    private ResenasModel usuarios;

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
}