package co.edu.unicundi.recursosInvestigacion.service.imp;

import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicundi.recursosInvestigacion.dto.roluserDTO;
import java.util.Optional;
import co.edu.unicundi.recursosInvestigacion.entity.RolUser;
import co.edu.unicundi.recursosInvestigacion.repository.IRolUserRepo;
import co.edu.unicundi.recursosInvestigacion.repository.IUsuarioRepo;
import co.edu.unicundi.recursosInvestigacion.service.IRolUserService;

@Service
public class RolUserServiceImp implements IRolUserService{

	@Autowired
	private IRolUserRepo repo;
	
	@Autowired
	private IUsuarioRepo repoUser;

	@Override
	public List<roluserDTO> retornar() {
		List<RolUser> listaRolU = repo.findAll();
		List<roluserDTO> DTOrol = new ArrayList<>();
		for(RolUser listRol : listaRolU) {
			 ModelMapper modelMapper = new ModelMapper();
			 roluserDTO dtorolu = modelMapper.map(listRol, roluserDTO.class);
			 dtorolu.setUsuarios(null);
			 DTOrol.add(dtorolu);
		}
		return DTOrol;
	}

	@Override
	public roluserDTO retornarPorId(Integer id) throws ModelNotFoundException {
		Optional<RolUser> optional = repo.findById(id);
		RolUser rolu;
		roluserDTO dtorolu;
		if (optional.isPresent()) {
			rolu = optional.get();
			ModelMapper modelMapper = new ModelMapper();
			dtorolu = modelMapper.map(rolu, roluserDTO.class);
			dtorolu.setUsuarios(null);
		} else {
			throw new ModelNotFoundException("Rol no existe");
		}
		return dtorolu;
	}

	@Override
	public void guardar(RolUser rolu) throws ModelNotFoundException {
		Optional<RolUser> optional = repo.findById(rolu.getRoluId());
		if (optional.isPresent()) {
			throw new ModelNotFoundException("Este rol ya existe");
		}else {
			repo.save(rolu);
		}
	}

	@Override
	public void editar(RolUser rolu) throws ModelNotFoundException{
		Optional<RolUser> optional = repo.findById(rolu.getRoluId());
		RolUser rolus;
		if (optional.isPresent()) {
			rolus = optional.get();
			rolus.setRoluNombre(rolu.getRoluNombre());
			repo.save(rolus);	
		}else {
			throw new ModelNotFoundException("Rol no existe");
		}
		
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException{
		
		Optional<RolUser> optional = repo.findById(id);
		if (optional.isPresent()) {
			repoUser.eliminarUser(id);
			repo.deleteById(id);
		}else {
			throw new ModelNotFoundException("Rol no existe");
		}
	}

}
