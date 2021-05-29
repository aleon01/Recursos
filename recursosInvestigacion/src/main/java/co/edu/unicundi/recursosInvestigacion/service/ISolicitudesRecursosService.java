package co.edu.unicundi.recursosInvestigacion.service;

import java.util.List;

import co.edu.unicundi.recursosInvestigacion.dto.solicitudrecursoDTO;
import co.edu.unicundi.recursosInvestigacion.dto.solirecuSolicitudDTO;
import co.edu.unicundi.recursosInvestigacion.entity.SolicitudRecurso;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;

public interface ISolicitudesRecursosService {

	public List<solicitudrecursoDTO> retornar();

	public solirecuSolicitudDTO retornarPorSolicitud(Integer idSolicitud) throws ModelNotFoundException;
	
	public SolicitudRecurso retornarPorRecurso(Integer idRecurso) throws ModelNotFoundException;

	public void guardar(SolicitudRecurso solicitudRecurso) throws ModelNotFoundException;

	public void editar(SolicitudRecurso solicitudRecurso) throws ModelNotFoundException;

	public void eliminarPorSolicitud(Integer idSolicitud) throws ModelNotFoundException;
	
	public void eliminarPorRecurso(Integer idRecurso) throws ModelNotFoundException;
}
