package co.edu.unicundi.recursosInvestigacion.service;

import java.util.List;

import co.edu.unicundi.recursosInvestigacion.dto.roluserDTO;
import co.edu.unicundi.recursosInvestigacion.entity.RolUser;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;

public interface IRolUserService {

	public List<roluserDTO> retornar();

	public roluserDTO retornarPorId(Integer id) throws ModelNotFoundException;

	public void guardar(RolUser rolu) throws ModelNotFoundException;

	public void editar(RolUser rolu) throws ModelNotFoundException;

	public void eliminar(Integer id) throws ModelNotFoundException;
	
}
