package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Column()
    private String imagen;

    @OneToMany(targetEntity = ResenasModel.class, mappedBy = "proyectos")
    private List<ResenasModel> resenas;

    @OneToMany( targetEntity = TecnologiasModel.class, mappedBy = "proyectos")
    private List<TecnologiasModel> tecnologias;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UsuariosModel usuarios;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<ResenasModel> getResenas() {
        return resenas;
    }

    public void setResenas(List<ResenasModel> resenas) {
        this.resenas = resenas;
    }

    public List<TecnologiasModel> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<TecnologiasModel> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public UsuariosModel getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosModel usuarios) {
        this.usuarios = usuarios;
    }

    public ComprasModel getCompras() {
        return compras;
    }

    public void setCompras(ComprasModel compras) {
        this.compras = compras;
    }
}
