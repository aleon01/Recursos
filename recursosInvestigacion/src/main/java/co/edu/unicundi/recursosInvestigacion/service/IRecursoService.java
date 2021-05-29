package co.edu.unicundi.recursosInvestigacion.service;

import java.util.List;
import co.edu.unicundi.recursosInvestigacion.entity.Recurso;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;

public interface IRecursoService {

	public List<Recurso> retornar();

	public Recurso retornarPorId(Integer id) throws ModelNotFoundException;

	public void guardar(Recurso recurso) throws ModelNotFoundException;

	public void editar(Recurso recurso) throws ModelNotFoundException;

	public void eliminar(Integer id) throws ModelNotFoundException;
}
