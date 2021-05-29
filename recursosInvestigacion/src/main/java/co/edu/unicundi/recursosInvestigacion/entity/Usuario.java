package co.edu.unicundi.recursosInvestigacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
    
	@Column(name = "user_codigo", nullable = false, length = 30)
    private Integer userCodigo;
	
	@Size(min = 4, max = 20, message = "Debe tener entre 4 y 20 letras")
    @Column(name = "user_nombre", nullable = false, length = 50)
    private String userNombre;
	
	@Size(min = 4, max = 20, message = "Debe tener entre 4 y 20 letras")
    @Column(name = "user_apellido", nullable = false, length = 50)
    private String userApellido;
	
	@Size(min = 7, max = 15, message = "Debe tener entre 7 y 15 letras")
    @Column(name = "user_identificacion", nullable = false, length = 30)
    private String userIdentificacion;
	
	@Size(min = 4, max = 20, message = "Debe tener entre 4 y 20 letras")
    @Column(name = "user_programaacademico", nullable = false, length = 30)
    private String userProgramaAcademico;
	
	@ManyToOne
	@JoinColumn(name = "rolu_id", nullable = false, foreignKey = @ForeignKey(name = "USUARIOS_FK1"))
	private RolUser rolUser;
	
	@Size(min = 7, max = 15, message = "Debe tener entre 7 y 15 letras")
    @Column(name = "user_usuario", nullable = false, length = 30)
    private String userUsuario;
	
	@Size(min = 7, max = 15, message = "Debe tener entre 7 y 15 letras")
    @Column(name = "user_contrasena", nullable = false, length = 30)
    private String userContrasena;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getUserCodigo() {
		return userCodigo;
	}

	public void setUserCodigo(Integer userCodigo) {
		this.userCodigo = userCodigo;
	}

	public String getUserNombre() {
		return userNombre;
	}

	public void setUserNombre(String userNombre) {
		this.userNombre = userNombre;
	}

	public String getUserApellido() {
		return userApellido;
	}

	public void setUserApellido(String userApellido) {
		this.userApellido = userApellido;
	}

	public String getUserIdentificacion() {
		return userIdentificacion;
	}

	public void setUserIdentificacion(String userIdentificacion) {
		this.userIdentificacion = userIdentificacion;
	}

	public String getUserProgramaAcademico() {
		return userProgramaAcademico;
	}

	public void setUserProgramaAcademico(String userProgramaAcademico) {
		this.userProgramaAcademico = userProgramaAcademico;
	}

	public String getUserUsuario() {
		return userUsuario;
	}

	public void setUserUsuario(String userUsuario) {
		this.userUsuario = userUsuario;
	}

	public String getUserContrasena() {
		return userContrasena;
	}

	public void setUserContrasena(String userContrasena) {
		this.userContrasena = userContrasena;
	}

	public RolUser getRolUser() {
		return rolUser;
	}

	public void setRolUser(RolUser rolUser) {
		this.rolUser = rolUser;
	}
	
}
