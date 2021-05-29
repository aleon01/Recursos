package co.edu.unicundi.recursosInvestigacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recurso")
public class Recurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recuId;
    
	@ManyToOne
	@JoinColumn(name = "trec_id", nullable = false, foreignKey = @ForeignKey(name = "RECURSOS_FK1"))
	private TipoRecurso trecurso;
	
	@Column(name = "recu_codigo", nullable = false)
    private Integer recuCodigo;
	
	@Size(min = 3, max = 20, message = "Debe tener entre 3 y 20 letras")
    @Column(name = "recu_nombre", nullable = false, length = 30)
    private String recuNombre;
	
	@Size(min = 10, max = 3000, message = "Debe tener entre 10 y 3000 letras")
    @Column(name = "recu_descripcion", nullable = false, length = 3000)
    private String recuDescripcion;
	
	@Column(name = "recu_soporte", nullable = false)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recuId == null) ? 0 : recuId.hashCode());
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
		Recurso other = (Recurso) obj;
		if (recuId == null) {
			if (other.recuId != null)
				return false;
		} else if (!recuId.equals(other.recuId))
			return false;
		return true;
	}


	
}
