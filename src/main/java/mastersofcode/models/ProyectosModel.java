package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/* Una tabla para proyectos ofertados, no ofertaods y en curso
    - la columna de precio y valoracion pueden ser nulas
 */
@Entity
@Table(name = "proyectos")
public class ProyectosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column()
    private int precio;

    @OneToMany(targetEntity = ResenasModel.class, mappedBy = "proyectos")
    private List<ResenasModel> resenas;

    @OneToMany( targetEntity = TecnologiasModel.class, mappedBy = "proyectos")
    private List<TecnologiasModel> tecnologias;

    @ManyToOne
    @JsonIgnore
    private UsuariosModel usuarios;

    @ManyToOne
    @JsonIgnore
    private ComprasModel compras;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
