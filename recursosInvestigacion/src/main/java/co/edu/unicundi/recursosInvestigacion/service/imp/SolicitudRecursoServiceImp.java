package co.edu.unicundi.recursosInvestigacion.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicundi.recursosInvestigacion.dto.recursoDTO;
import co.edu.unicundi.recursosInvestigacion.dto.solicitudrecursoDTO;
import co.edu.unicundi.recursosInvestigacion.dto.solirecuSolicitudDTO;
import co.edu.unicundi.recursosInvestigacion.entity.Recurso;
import co.edu.unicundi.recursosInvestigacion.entity.SolicitudRecurso;
import co.edu.unicundi.recursosInvestigacion.entity.Solicitudes;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.repository.IRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ISolicitudRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ISolicitudRepo;
import co.edu.unicundi.recursosInvestigacion.service.ISolicitudesRecursosService;

@Service
public class SolicitudRecursoServiceImp implements ISolicitudesRecursosService{

	@Autowired
	private ISolicitudRecursoRepo repo;
	
	@Autowired
	private ISolicitudRepo repoSolicitudes;
	
	@Autowired
	private IRecursoRepo repoRecursos;
	
	@Override
	public List<solicitudrecursoDTO> retornar() {
		List<SolicitudRecurso> listaSoliRecu = repo.findAll();
		List<solicitudrecursoDTO> solirecuDTO = new ArrayList<>();
		for(SolicitudRecurso solirecu : listaSoliRecu) {
			 ModelMapper modelMapper = new ModelMapper();
	         solicitudrecursoDTO dtorecusoli = modelMapper.map(solirecu, solicitudrecursoDTO.class);
	         dtorecusoli.getSolicitud().setSolicitudRecurso(null);
	         solirecuDTO.add(dtorecusoli);
		}
		return solirecuDTO;
	}

	@Override
	public void guardar(SolicitudRecurso solicitudRecurso) throws ModelNotFoundException {
		Optional<Solicitudes> soli = repoSolicitudes.findById(solicitudRecurso.getSolicitud().getSoliId());
		Optional<Recurso> recur = repoRecursos.findById(solicitudRecurso.getRecurso().getRecuId());
		
		if(soli.isPresent() && recur.isPresent()) {
			SolicitudRecurso solirecusave = new SolicitudRecurso();
			Recurso recuSave = new Recurso();
			recuSave.setRecuId(solicitudRecurso.getRecurso().getRecuId());
			solirecusave.setRecurso(recuSave);
			Solicitudes solisave = new Solicitudes();
			solisave.setSoliId(solicitudRecurso.getSolicitud().getSoliId());
			solirecusave.setSolicitud(solisave);
			
			repo.guardar(solirecusave.getRecurso().getRecuId(), solirecusave.getSolicitud().getSoliId());
			//repo.save(solicitudRecurso);
		}else {
			throw new ModelNotFoundException("Solicitud o recurso no existe");
		}
	}

	@Override
	public void editar(SolicitudRecurso solicitudRecurso) throws ModelNotFoundException {
		List<SolicitudRecurso> soli = repo.buscarPorIdSolicitud(solicitudRecurso.getSolicitud().getSoliId());
		if(soli != null) {
			for(SolicitudRecurso recuSolicitud : soli) {
				Recurso recuSave = new Recurso();
				recuSave.setRecuId(solicitudRecurso.getRecurso().getRecuId());
				recuSolicitud.setRecurso(recuSave);
				repo.editar(recuSolicitud.getSolicitud().getSoliId(), recuSolicitud.getRecurso().getRecuId());
			}
		}else {
			throw new ModelNotFoundException("Solicitud o recurso no existe");
		}
	}

	

	@Override
	public solirecuSolicitudDTO retornarPorSolicitud(Integer soliId) throws ModelNotFoundException {
		List<SolicitudRecurso> soli = repo.buscarPorIdSolicitud(soliId);
		solirecuSolicitudDTO SolicitudDTO = null;
		if(soli != null) {
			for(SolicitudRecurso recuSolicitud : soli) {
				recursoDTO recurDTO;
				List<recursoDTO> listRecu = new ArrayList<>();
				ModelMapper modelMapper = new ModelMapper();
				SolicitudDTO = modelMapper.map(recuSolicitud,  solirecuSolicitudDTO.class);
				List<Integer> listRecursos =  repo.buscarRecursossoli(soliId);
				for(Integer recuList : listRecursos) {
					Recurso recursos = repoRecursos.findById(recuList).orElseThrow(() -> new ModelNotFoundException("Tipo de recurso no encontrado"));
						recurDTO = modelMapper.map(recursos, recursoDTO.class);
						listRecu.add(recurDTO);
				}
				SolicitudDTO.setRecurso(listRecu);
				SolicitudDTO.getSolicitud().setSolicitudRecurso(null);
				
			}
		}else {
			throw new ModelNotFoundException("Solicitud no existe");
		}
		return SolicitudDTO;	
		
	}

	@Override
	public SolicitudRecurso retornarPorRecurso(Integer idRecurso) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPorSolicitud(Integer soliId) throws ModelNotFoundException {
		Optional<Solicitudes> soliResult = repoSolicitudes.findById(soliId);
		if(soliResult.isPresent()) {
			repo.eliminarSolicitud(soliId);	
		}else {
			new ModelNotFoundException("Solicitud no se encontra Registrada");
		}
	}

	@Override
	public void eliminarPorRecurso(Integer recuId) throws ModelNotFoundException {
		Optional<Recurso> recuResult = repoRecursos.findById(recuId);
		if(recuResult.isPresent()) {
			repo.eliminarRecurso(recuId);	
		}else {
			new ModelNotFoundException("Recurso no se encontra Registrado");
		}
		
	}

}
