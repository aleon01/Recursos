package co.edu.unicundi.recursosInvestigacion.dto;

import co.edu.unicundi.recursosInvestigacion.entity.TipoRecurso;

public class recursoDTO {
	
	private Integer recuId;
    
	private TipoRecurso trecurso;
	
	private Integer recuCodigo;
	
	private String recuNombre;
	
	private String recuDescripcion;
	
	private String recuSoporte;

	public Integer getRecuId() {
		return recuId;
	}

	public void setRecuId(Integer recuId) {
		this.recuId = recuId;
	}

	public TipoRecurso getTrecurso() {
		return trecurso;
	}

	public void setTrecurso(TipoRecurso trecurso) {
		this.trecurso = trecurso;
	}

	public Integer getRecuCodigo() {
		return recuCodigo;
	}

	public void setRecuCodigo(Integer recuCodigo) {
		this.recuCodigo = recuCodigo;
	}

	public String getRecuNombre() {
		return recuNombre;
	}

	public void setRecuNombre(String recuNombre) {
		this.recuNombre = recuNombre;
	}

	public String getRecuDescripcion() {
		return recuDescripcion;
	}

	public void setRecuDescripcion(String recuDescripcion) {
		this.recuDescripcion = recuDescripcion;
	}

	public String getRecuSoporte() {
		return recuSoporte;
	}

	public void setRecuSoporte(String recuSoporte) {
		this.recuSoporte = recuSoporte;
	}
	
	

}
