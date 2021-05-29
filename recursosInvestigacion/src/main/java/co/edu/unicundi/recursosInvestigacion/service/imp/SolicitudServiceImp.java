 package co.edu.unicundi.recursosInvestigacion.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicundi.recursosInvestigacion.dto.solicitudDTO;
import co.edu.unicundi.recursosInvestigacion.entity.Recurso;
import co.edu.unicundi.recursosInvestigacion.entity.SolicitudRecurso;
import co.edu.unicundi.recursosInvestigacion.entity.Solicitudes;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.repository.IRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ISolicitudRecursoRepo;
import co.edu.unicundi.recursosInvestigacion.repository.ISolicitudRepo;
import co.edu.unicundi.recursosInvestigacion.service.ISolicitudesService;

@Service
public class SolicitudServiceImp implements ISolicitudesService{

	@Autowired
	private ISolicitudRepo repo;
	
	@Autowired
	private ISolicitudRecursoRepo repoSoliRecu;
	
	@Autowired
	private IRecursoRepo repoRecu;
	
	@Override
	public List<solicitudDTO> retornar() {
		List<Solicitudes> listaSolicitudes = repo.findAll();
		List<solicitudDTO> soliDTO = new ArrayList<>();
		for(Solicitudes solicitudes : listaSolicitudes) {
			 ModelMapper modelMapper = new ModelMapper();
	         solicitudDTO dtosoli = modelMapper.map(solicitudes, solicitudDTO.class);
	         soliDTO.add(dtosoli);
		}
		return soliDTO;
	}

	@Override
	public solicitudDTO retornarPorId(Integer id) throws ModelNotFoundException {
		Optional<Solicitudes> solicitud = repo.findById(id);
		solicitudDTO soliDTO = new solicitudDTO();
		Solicitudes solicit = new Solicitudes();
			if(solicitud.isPresent()) {
				solicit = solicitud.get();
				ModelMapper modelMapper = new ModelMapper();
		        soliDTO = modelMapper.map(solicit, solicitudDTO.class);
			}
			//.orElseThrow(() -> new ModelNotFoundException("Solicitud no encontrada"));
		return soliDTO;
	}

	@Override
	public void guardar(Solicitudes solicitud) throws ModelNotFoundException {
		System.out.println("--------------------------- ---------------------------------------------------Afuer");
		if(solicitud.getSolicitudRecurso() != null) {
			for(SolicitudRecurso soliRecu : solicitud.getSolicitudRecurso()) {
				SolicitudRecurso solirecusave = new SolicitudRecurso();
				Recurso recuSave = new Recurso();
				recuSave.setRecuId(soliRecu.getRecurso().getRecuId());
				solirecusave.setRecurso(recuSave);
				solirecusave.setSolicitud(solicitud);
				
				repoSoliRecu.guardar(solirecusave.getRecurso().getRecuId(), solirecusave.getSolicitud().getSoliId());
				
				//soliRecu.getSolicitud().setSoliId(solicitud.getSoliId());
				//repoSoliRecu.guardar(soliRecu.getRecurso().getRecuId(), soliRecu.getSolicitud().getSoliId());
			}
		}
		repo.save(solicitud);	
		
	}

	@Override
	public void editar(Solicitudes solicitud) throws ModelNotFoundException, Exception {
		
		if (solicitud.getSoliId() == null) {
            throw new Exception("Ingresar el Id de la Solicitud");
        } else {
            Optional<Solicitudes> solici = repo.findById(solicitud.getSoliId());
            Solicitudes soliEdi;
            if (solici.isPresent()) {
            	soliEdi = solici.get();
            	
            	soliEdi.setSoliFecha(solicitud.getSoliFecha());
            	soliEdi.setSoliHoraInicio(solicitud.getSoliHoraInicio());
            	soliEdi.setSoliDuracion(solicitud.getSoliDuracion());
            	soliEdi.setSoliCantPersona(solicitud.getSoliCantPersona());
            	soliEdi.setSoliObservaciones(solicitud.getSoliObservaciones());
            	/*for(SolicitudRecurso soliRecu : solicitud.getSolicitudRecurso()) {
    				Optional<Recurso> recu = repoRecu.findById(soliRecu.getRecurso().getRecuId());
    				if(recu.isPresent()) {
    					
    				}else {
    					throw new ModelNotFoundException("el Id del recurso no existe");
    				}
    				
    				repoSoliRecu.editar(soliRecu.getSolicitud().getSoliId(), soliRecu.getRecurso().getRecuId());
    				//soliRecu.setSolicitud(solicitud);
    			}*/
            	repo.save(soliEdi);
            } else {
                throw new ModelNotFoundException("el Id de la solicitud no existe");
            }
        }
            
		
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		Optional<Solicitudes> optional = repo.findById(id);
		if (optional.isPresent()) {
			repoSoliRecu.eliminarSolicitud(id);
			repo.deleteById(id);
		}else {
			throw new ModelNotFoundException("Solicitud no existe");
		}
	}

}
