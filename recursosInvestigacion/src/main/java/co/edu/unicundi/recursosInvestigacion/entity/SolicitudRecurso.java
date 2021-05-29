package co.edu.unicundi.recursosInvestigacion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "solicitudrecurso")
@IdClass(SolicitudRecursoPK.class)
public class SolicitudRecurso {

	@Id
	private Solicitudes solicitud;
	
	@Id
	private Recurso recurso;

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
