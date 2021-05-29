package co.edu.unicundi.recursosInvestigacion.dto;

import co.edu.unicundi.recursosInvestigacion.entity.Recurso;
import co.edu.unicundi.recursosInvestigacion.entity.Solicitudes;

public class solicitudrecursoDTO {

	private  Integer idSolicitud;
	
	private  Integer idRecurso;
    
    private  Solicitudes solicitud; 
    
    private  Recurso  recurso;

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}

	public Solicitudes getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitudes solicitud) {
		this.solicitud = solicitud;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
    
    
	
}
