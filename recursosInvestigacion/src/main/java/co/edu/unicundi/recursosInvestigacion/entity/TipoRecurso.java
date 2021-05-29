package co.edu.unicundi.recursosInvestigacion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tiporecurso")
public class TipoRecurso {

	@Id
    private Integer trecId;
    
	@Size(min = 3, max = 20, message = "Debe tener entre 3 y 20 letras")
    @Column(name = "trec_nombre", nullable = false, length = 30)
    private String trecNombre;
	
	@OneToMany(mappedBy = "trecurso")
	private List<Recurso> recursos;

	public Integer getTrecId() {
		return trecId;
	}

	public void setTrecId(Integer trecId) {
		this.trecId = trecId;
	}

	public String getTrecNombre() {
		return trecNombre;
	}

	public void setTrecNombre(String trecNombre) {
		this.trecNombre = trecNombre;
	}

	@JsonIgnore
	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	
}
