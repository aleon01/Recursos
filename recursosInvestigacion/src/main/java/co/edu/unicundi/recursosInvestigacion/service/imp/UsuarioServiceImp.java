package co.edu.unicundi.recursosInvestigacion.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.recursosInvestigacion.dto.usuarioDTO;
import co.edu.unicundi.recursosInvestigacion.entity.RolUser;
import co.edu.unicundi.recursosInvestigacion.entity.Usuario;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.repository.IRolUserRepo;
import co.edu.unicundi.recursosInvestigacion.repository.IUsuarioRepo;
import co.edu.unicundi.recursosInvestigacion.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService{

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private IRolUserRepo repoRol;
	
	@Override
	public List<usuarioDTO> retornar() {
		List<Usuario> listaUser = repo.findAll();
		List<usuarioDTO> DTOuser = new ArrayList<>();
		for(Usuario listUsuario : listaUser) {
			 ModelMapper modelMapper = new ModelMapper();
			 usuarioDTO dtousuarios = modelMapper.map(listUsuario, usuarioDTO.class);
			 dtousuarios.getRolUser().setUsuarios(null);
           DTOuser.add(dtousuarios);
			 
		}
		return DTOuser;
	}

	@Override
	public usuarioDTO retornarPorId(Integer id) throws ModelNotFoundException {
		Optional<Usuario> optional = repo.findById(id);
		Usuario user;
		usuarioDTO dtouser;
		if (optional.isPresent()) {
			user = optional.get();
			ModelMapper modelMapper = new ModelMapper();
			dtouser = modelMapper.map(user, usuarioDTO.class);
			dtouser.getRolUser().setUsuarios(null);
		} else {
			throw new ModelNotFoundException("Usuario no existe");
		}
		return dtouser;
	}

	@Override
	public void guardar(Usuario user) throws ModelNotFoundException {
		Usuario userCod = repo.findByUserCodigo(user.getUserCodigo());
		if(userCod == null) {
			
		}else {
			throw new ModelNotFoundException("El codigo del usuario ya existe");
		}
		//-----
		Usuario userIden = repo.findByUserIdentificacion(user.getUserIdentificacion());
		if(userIden == null) {	
			
		}else {
			throw new ModelNotFoundException("La identificación del usuario ya existe");
		}
		//-----
		//Valida el ROl
		Optional<RolUser> rolu = repoRol.findById(user.getRolUser().getRoluId());
		if(rolu.isPresent()) {
			
		}else {
			throw new ModelNotFoundException("El Rol no existe");
		}
		//-----
		Usuario userUser = repo.findByUserUsuario(user.getUserUsuario());
		if(userUser == null) {
			
		}else {
			throw new ModelNotFoundException("Este usuario ya existe");
		}		
		repo.save(user);
	}

	@Override
	public void editar(Usuario user) throws ModelNotFoundException {
		
		Optional<Usuario> optional = repo.findById(user.getUser_id());
		Usuario userBus;
		if (optional.isPresent()) {
			userBus = optional.get();
			
			userBus.setUserCodigo(user.getUserCodigo());
			userBus.setUserNombre(user.getUserNombre());
			userBus.setUserApellido(user.getUserApellido());
			userBus.setUserIdentificacion(user.getUserIdentificacion());
			userBus.setUserProgramaAcademico(user.getUserProgramaAcademico());
			//VALIDA ROL
			Optional<RolUser> rolu = repoRol.findById(user.getRolUser().getRoluId());
			if(rolu.isPresent()) {
				
			} else {
				throw new ModelNotFoundException("Rol no existe");
			}
			userBus.setRolUser(user.getRolUser());
			userBus.setUserUsuario(user.getUserUsuario());
			userBus.setUserContrasena(user.getUserContrasena());
			repo.save(userBus);
		}else {
			throw new ModelNotFoundException("Usuario no existe");
		}
	}

	
	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		Optional<Usuario> user = repo.findById(id);
		if(user.isPresent()) {
			repo.deleteById(id);	
		}else {
			new ModelNotFoundException("Usuario no se encontra Registrado");
		}
	}

	@Override
	public usuarioDTO findByUserUsuarioAndUserContrasena(String userUsuario, String userContrasena)  throws ModelNotFoundException {
		Usuario optional = repo.findByUserUsuarioAndUserContrasena(userUsuario, userContrasena);
		usuarioDTO dtouser;
		if (optional != null) {
			
			ModelMapper modelMapper = new ModelMapper();
			dtouser = modelMapper.map(optional, usuarioDTO.class);
			dtouser.getRolUser().setUsuarios(null);
		} else {
			throw new ModelNotFoundException("Usuario no existe");
		}
		return dtouser;
		/*
		Usuario user = repo.findByUserUsuarioAndUserContrasena(userUsuario, userContrasena);
		if(user == null) {
			new ModelNotFoundException("Usuario o Contraseña incorrecta");
		} 
			return user;
		*/	
			
	}

	@Override
	public usuarioDTO consultarUsuarioAndContrasena(String userUsuario, String userContrasena) throws ModelNotFoundException{
		Usuario optional = repo.consultarUsuarioAndContrasena(userUsuario, userContrasena);;
		usuarioDTO dtouser;
		if (optional != null) {
			
			ModelMapper modelMapper = new ModelMapper();
			dtouser = modelMapper.map(optional, usuarioDTO.class);
			dtouser.getRolUser().setUsuarios(null);
		} else {
			throw new ModelNotFoundException("Usuario no existe");
		}
		return dtouser;
		
		
		/*
		Usuario user = repo.consultarUsuarioAndContrasena(userUsuario, userContrasena);
		if(user == null) {
			new ModelNotFoundException("Usuario o Contraseña incorrecta");
		} 
			return user;*/
	}

}
