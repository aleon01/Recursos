package co.edu.unicundi.recursosInvestigacion.dto;

import java.util.List;

public class roluserDTO {
	
	private Integer roluId;
    
	private String roluNombre;
	
	private List<usuarioDTO> usuarios;

	public Integer getRoluId() {
		return roluId;
	}

	public void setRoluId(Integer roluId) {
		this.roluId = roluId;
	}

	public String getRoluNombre() {
		return roluNombre;
	}

	public void setRoluNombre(String roluNombre) {
		this.roluNombre = roluNombre;
	}

	public List<usuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<usuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
}
