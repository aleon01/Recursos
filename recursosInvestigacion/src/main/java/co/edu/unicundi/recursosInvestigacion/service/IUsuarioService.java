package co.edu.unicundi.recursosInvestigacion.service;

import java.util.List;

import co.edu.unicundi.recursosInvestigacion.dto.usuarioDTO;
import co.edu.unicundi.recursosInvestigacion.entity.Usuario;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;

public interface IUsuarioService {

	public List<usuarioDTO> retornar();

	public usuarioDTO retornarPorId(Integer id) throws ModelNotFoundException;

	public void guardar(Usuario user) throws ModelNotFoundException;

	public void editar(Usuario user) throws ModelNotFoundException;

	public void eliminar(Integer id) throws ModelNotFoundException;
	
	public usuarioDTO findByUserUsuarioAndUserContrasena(String userUsuario, String userContrasena)  throws ModelNotFoundException ;
	
    public usuarioDTO consultarUsuarioAndContrasena(String userUsuario, String userContrasena)  throws ModelNotFoundException ;
	
}
