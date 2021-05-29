package co.edu.unicundi.recursosInvestigacion.dto;

import java.util.List;

import co.edu.unicundi.recursosInvestigacion.entity.Solicitudes;

public class solirecuSolicitudDTO {
	
	private Integer idSolicitud;

	private Solicitudes solicitud;

	private List<recursoDTO> recurso;
	
	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Solicitudes getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitudes solicitud) {
		this.solicitud = solicitud;
	}

	public List<recursoDTO> getRecurso() {
		return recurso;
	}

	public void setRecurso(List<recursoDTO> recurso) {
		this.recurso = recurso;
	}

	
}
