package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "cuentas")
public class CuentasBancariasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 30)
    private int num_tarjeta;

    @Column(nullable = false, length = 50)
    private String titular;

    // Verificar
    @Column(nullable = false, length = 50)
    private String paypal;

    @ManyToOne
    @JsonIgnore
    private UsuariosModel usuarios;

    @OneToOne
    @JsonIgnore
    private ComprasModel compras;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
