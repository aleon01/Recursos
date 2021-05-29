package co.edu.unicundi.recursosInvestigacion.service;

import java.util.List;

import co.edu.unicundi.recursosInvestigacion.dto.solicitudDTO;
import co.edu.unicundi.recursosInvestigacion.entity.Solicitudes;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;

public interface ISolicitudesService {

	public List<solicitudDTO> retornar();

	public solicitudDTO retornarPorId(Integer id) throws ModelNotFoundException;

	public void guardar(Solicitudes solicitud) throws ModelNotFoundException;

	public void editar(Solicitudes solicitud) throws ModelNotFoundException, Exception;

	public void eliminar(Integer id) throws ModelNotFoundException;
}
