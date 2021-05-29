package co.edu.unicundi.recursosInvestigacion.service;

import java.util.List;

import co.edu.unicundi.recursosInvestigacion.entity.TipoRecurso;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;

public interface ITipoRecuService {

	public List<TipoRecurso> retornar();

	public TipoRecurso retornarPorId(Integer id) throws ModelNotFoundException;

	public void guardar(TipoRecurso tipor) throws ModelNotFoundException;

	public void editar(TipoRecurso tipor) throws ModelNotFoundException;

	public void eliminar(Integer id) throws ModelNotFoundException;
	
}
