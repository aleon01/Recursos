package co.edu.unicundi.recursosInvestigacion.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SolicitudRecursoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "soli_id", nullable = false)
	private Solicitudes solicitud;

	@ManyToOne
	@JoinColumn(name = "recu_id", nullable = false)
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recurso == null) ? 0 : recurso.hashCode());
		result = prime * result + ((solicitud == null) ? 0 : solicitud.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolicitudRecursoPK other = (SolicitudRecursoPK) obj;
		if (recurso == null) {
			if (other.recurso != null)
				return false;
		} else if (!recurso.equals(other.recurso))
			return false;
		if (solicitud == null) {
			if (other.solicitud != null)
				return false;
		} else if (!solicitud.equals(other.solicitud))
			return false;
		return true;
	}

	
	
}
