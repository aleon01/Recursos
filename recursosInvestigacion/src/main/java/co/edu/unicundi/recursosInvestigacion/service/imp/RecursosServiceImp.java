package co.edu.unicundi.recursosInvestigacion.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.recursosInvestigacion.entity.Recurso;
import co.edu.unicundi.recursosInvestigacion.entity.TipoRecurso;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.repository.IRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ISolicitudRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ITipoRecuRepo;
import co.edu.unicundi.recursosInvestigacion.service.IRecursoService;

@Service
public class RecursosServiceImp implements IRecursoService{

	@Autowired
	private IRecursoRepo repo;
	
	@Autowired
	private ITipoRecuRepo repoTipoR;
	
	@Autowired
	private ISolicitudRecursoRepo repoSoliRecu;
	
	@Override
	public List<Recurso> retornar() {
		List<Recurso> listaRecurso = repo.findAll();
		return listaRecurso;
	}

	@Override
	public Recurso retornarPorId(Integer id) throws ModelNotFoundException {
		Recurso recurso = repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Recurso no encontrado"));
		return recurso;
	}

	@Override
	public void guardar(Recurso recurso) throws ModelNotFoundException {
		Optional<TipoRecurso> tiporecu  = repoTipoR.findById(recurso.getTrecurso().getTrecId());
		if(tiporecu.isPresent()) {
			
		}else {
			throw new ModelNotFoundException("El tipo de recurso no existe");
		}
		Recurso recu = repo.findByRecuCodigo(recurso.getRecuCodigo());
		if(recu == null) {
			
		}else {
			throw new ModelNotFoundException("El recurso con ese codigo ya existe");
		}
		repo.save(recurso);	
	}

	@Override
	public void editar(Recurso recurso) throws ModelNotFoundException {
		Optional<Recurso> optional = repo.findById(recurso.getRecuId());
		Recurso recBus;
		if (optional.isPresent()) {
			recBus = optional.get();
			
			Optional<TipoRecurso> tiporecu  = repoTipoR.findById(recurso.getTrecurso().getTrecId());
			if(tiporecu.isPresent()) {
				
			}else {
				throw new ModelNotFoundException("El tipo de recurso no existe");
			}
			recBus.setTrecurso(recurso.getTrecurso());
			recBus.setRecuCodigo(recurso.getRecuCodigo());
			recBus.setRecuNombre(recurso.getRecuNombre());
			recBus.setRecuDescripcion(recurso.getRecuDescripcion());
			recBus.setRecuSoporte(recurso.getRecuSoporte());
			repo.save(recBus);
		}else {
			throw new ModelNotFoundException("Recurso no existe");
		}
		
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		Optional<Recurso> recu = repo.findById(id);
		if(recu.isPresent()) {
			repoSoliRecu.eliminarRecurso(id);
			repo.deleteById(id);
		}else {
			throw new ModelNotFoundException("No existe un recurso con ese ID");
		}
			
	}

}
