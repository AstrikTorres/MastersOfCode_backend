package mastersofcode.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuariosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(nullable = false, length = 100)
	private String name;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 100, unique = true)
	private String username;

	@Column(nullable = false, length = 20)
	private String rol;

	@Column()
	private String imagen_perfil;

	@Column()
	private String acerca;

	@Column(nullable = false, length = 50)
	private String ciudad;

	@Column(length = 15)
	private String telefono;

	@OneToMany( targetEntity = SolicitudesModel.class, mappedBy = "usuarios")
	private List<SolicitudesModel> solicitudes;

	@OneToOne( targetEntity = ExperienciaModel.class, mappedBy = "usuarios")
	private ExperienciaModel experiencia;

	@OneToOne( targetEntity = EducacionModel.class, mappedBy = "usuarios")
	private EducacionModel educacion;

	@OneToMany( targetEntity = ProyectosModel.class, mappedBy = "usuarios")
	private List<ProyectosModel> proyectos;

	@OneToMany( targetEntity = CuentasBancariasModel.class, mappedBy = "usuarios")
	private List<CuentasBancariasModel> cuentas;

	@OneToMany( targetEntity = ComprasModel.class, mappedBy = "usuarios")
	private List<ComprasModel> compras;

	@OneToMany( targetEntity = TecnologiasModel.class, mappedBy = "usuarios")
	private List<TecnologiasModel> tecnologias;

	@OneToMany( targetEntity = ResenasModel.class, mappedBy = "usuarios")
	private List<ResenasModel> resenas;

	@OneToMany( targetEntity = ProyectosModel.class, mappedBy = "usuarios")
	private List<PropuestasModel> propuestas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getImagen_perfil() {
		return imagen_perfil;
	}

	public void setImagen_perfil(String imagen_perfil) {
		this.imagen_perfil = imagen_perfil;
	}

	public String getAcerca() {
		return acerca;
	}

	public void setAcerca(String acerca) {
		this.acerca = acerca;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SolicitudesModel> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SolicitudesModel> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public ExperienciaModel getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ExperienciaModel experiencia) {
		this.experiencia = experiencia;
	}

	public EducacionModel getEducacion() {
		return educacion;
	}

	public void setEducacion(EducacionModel educacion) {
		this.educacion = educacion;
	}

	public List<ProyectosModel> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<ProyectosModel> proyectos) {
		this.proyectos = proyectos;
	}

	public List<CuentasBancariasModel> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentasBancariasModel> cuentas) {
		this.cuentas = cuentas;
	}

	public List<ComprasModel> getCompras() {
		return compras;
	}

	public void setCompras(List<ComprasModel> compras) {
		this.compras = compras;
	}

	public List<TecnologiasModel> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(List<TecnologiasModel> tecnologias) {
		this.tecnologias = tecnologias;
	}

	public List<ResenasModel> getResenas() {
		return resenas;
	}

	public void setResenas(List<ResenasModel> resenas) {
		this.resenas = resenas;
	}
}
