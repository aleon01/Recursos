package co.edu.unicundi.recursosInvestigacion.service.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicundi.recursosInvestigacion.entity.TipoRecurso;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.repository.IRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ISolicitudRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ITipoRecuRepo;
import co.edu.unicundi.recursosInvestigacion.service.ITipoRecuService;

@Service
public class TipoRecuServiceImp implements ITipoRecuService{

	@Autowired
	private ITipoRecuRepo repo;
	
	@Autowired
	private IRecursoRepo repoRecurso;
	
	@Autowired
	private ISolicitudRecursoRepo repoSoliRecu;
	
	@Override
	public List<TipoRecurso> retornar() {
		List<TipoRecurso> listaTipoR = repo.findAll();
		return listaTipoR;
	}

	@Override
	public TipoRecurso retornarPorId(Integer id) throws ModelNotFoundException {
		TipoRecurso tipoR = repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Tipo de recurso no encontrado"));
		return tipoR;
	}

	@Override
	public void guardar(TipoRecurso tipor) throws ModelNotFoundException {
		Optional<TipoRecurso> optional = repo.findById(tipor.getTrecId());
		if (optional.isPresent()) {
			throw new ModelNotFoundException("Este tipo de recurso ya existe");
		}else {
			repo.save(tipor);
		}
	}

	@Override
	public void editar(TipoRecurso tipor) throws ModelNotFoundException {
		Optional<TipoRecurso> optional = repo.findById(tipor.getTrecId());
		TipoRecurso tRec;
		if (optional.isPresent()) {
			tRec = optional.get();
			tRec.setTrecNombre(tipor.getTrecNombre());
			repo.save(tRec);	
		}else {
			throw new ModelNotFoundException("Tipo recurso no existe");
		}
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		Optional<TipoRecurso> optional = repo.findById(id);
		if (optional.isPresent()) {
			List<Integer> listRecursos =  repoRecurso.buscarRecursoList(id);
			for(Integer recuList : listRecursos) {
				repoSoliRecu.eliminarRecurso(recuList);
			}
			repoRecurso.eliminarRecurso(id);
			repo.deleteById(id);
		}else {
			throw new ModelNotFoundException("Tipo de recurso no existe");
		}
		
	}

}
