package co.edu.unicundi.recursosInvestigacion.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class solicitudDTO {
	
	private Integer soliId;
	
	private LocalDateTime soliFecha;
	
	private Timestamp soliHoraInicio;
	
	private Integer soliDuracion;
	
	private Integer soliCantPersona;
	
	private String soliObservaciones;

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
}
