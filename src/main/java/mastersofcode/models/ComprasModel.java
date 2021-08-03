package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "compras")
public class ComprasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 100, unique = true)
    private long num_compra;

    @Column(nullable = false)
    private String resumen_compra;

    @Column(nullable = false)
    private int precio_total;

    @OneToMany( targetEntity = ProyectosModel.class, mappedBy = "compras")
    private List<ProyectosModel> proyectos;

    @OneToOne( targetEntity = CuentasBancariasModel.class, mappedBy = "compras")
    private CuentasBancariasModel cuentas;

    @ManyToOne
    @JsonIgnore
    private UsuariosModel usuarios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNum_compra() {
        return num_compra;
    }

    public void setNum_compra(long num_compra) {
        this.num_compra = num_compra;
    }

    public String getResumen_compra() {
        return resumen_compra;
    }

    public void setResumen_compra(String resumen_compra) {
        this.resumen_compra = resumen_compra;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }
}
