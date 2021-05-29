package co.edu.unicundi.recursosInvestigacion.dto;

import co.edu.unicundi.recursosInvestigacion.entity.RolUser;

public class usuarioDTO {

	private Integer user_id;
    
	private Integer userCodigo;
	
	private String userNombre;
	
	private String userApellido;
	
	private String userIdentificacion;
	
	private String userProgramaAcademico;
	
	private RolUser rolUser;
	
	private String userUsuario;
	
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

	public RolUser getRolUser() {
		return rolUser;
	}

	public void setRolUser(RolUser rolUser) {
		this.rolUser = rolUser;
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
	
	
}
