package co.edu.unicundi.recursosInvestigacion.entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "solicitud")
public class Solicitudes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer soliId;
	
	
	@Column(name = "soli_fecha", nullable = false)
    private LocalDateTime soliFecha;
	
	@Column(name = "soli_horainicio", nullable = false)
    private Timestamp soliHoraInicio;
	
	@Column(name = "soli_duracion", nullable = false)
    private Integer soliDuracion;
	
	@Column(name = "soli_cantpersona", nullable = false)
    private Integer soliCantPersona;
	
	@Column(name = "soli_observacion", nullable = false)
    private String soliObservaciones;
	
	@OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SolicitudRecurso> solicitudRecurso;

	public Integer getSoliId() {
		return soliId;
	}

	public void setSoliId(Integer soliId) {
		this.soliId = soliId;
	}

	public LocalDateTime getSoliFecha() {
		return soliFecha;
	}

	public void setSoliFecha(LocalDateTime soliFecha) {
		this.soliFecha = soliFecha;
	}

	public Timestamp getSoliHoraInicio() {
		return soliHoraInicio;
	}

	public void setSoliHoraInicio(Timestamp soliHoraInicio) {
		this.soliHoraInicio = soliHoraInicio;
	}

	public Integer getSoliDuracion() {
		return soliDuracion;
	}

	public void setSoliDuracion(Integer soliDuracion) {
		this.soliDuracion = soliDuracion;
	}

	public Integer getSoliCantPersona() {
		return soliCantPersona;
	}

	public void setSoliCantPersona(Integer soliCantPersona) {
		this.soliCantPersona = soliCantPersona;
	}

	public String getSoliObservaciones() {
		return soliObservaciones;
	}

	public void setSoliObservaciones(String soliObservaciones) {
		this.soliObservaciones = soliObservaciones;
	}
	
	public List<SolicitudRecurso> getSolicitudRecurso() {
		return solicitudRecurso;
	}

	public void setSolicitudRecurso(List<SolicitudRecurso> solicitudRecurso) {
		this.solicitudRecurso = solicitudRecurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((soliId == null) ? 0 : soliId.hashCode());
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
		Solicitudes other = (Solicitudes) obj;
		if (soliId == null) {
			if (other.soliId != null)
				return false;
		} else if (!soliId.equals(other.soliId))
			return false;
		return true;
	}
	
}
