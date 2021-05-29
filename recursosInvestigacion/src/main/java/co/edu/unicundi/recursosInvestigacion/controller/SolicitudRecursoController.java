package co.edu.unicundi.recursosInvestigacion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.recursosInvestigacion.dto.solicitudrecursoDTO;
import co.edu.unicundi.recursosInvestigacion.dto.solirecuSolicitudDTO;
import co.edu.unicundi.recursosInvestigacion.entity.SolicitudRecurso;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.service.ISolicitudesRecursosService;

@RestController
@RequestMapping("/solicitudRecursos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SolicitudRecursoController {
	
	@Autowired
	private ISolicitudesRecursosService service;
	
	@GetMapping("/retornar")
	public ResponseEntity<?> retornar() {
			List<solicitudrecursoDTO> listaSoliRecursos = service.retornar();
			return new ResponseEntity<List<solicitudrecursoDTO>>(listaSoliRecursos, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaPorId/{id}")
	public ResponseEntity<?> retornarPorIdSolicitud(@PathVariable int id) throws ModelNotFoundException{
		solirecuSolicitudDTO solirecuDTO = service.retornarPorSolicitud(id);
		return new ResponseEntity<solirecuSolicitudDTO>(solirecuDTO, HttpStatus.OK);			
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody SolicitudRecurso soliRecurso) throws ModelNotFoundException {	
			service.guardar(soliRecurso);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@Valid @RequestBody SolicitudRecurso soliRecurso) throws ModelNotFoundException, Exception{	
			service.editar(soliRecurso);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}
	
	@DeleteMapping("eliminarSoli/{id}") 
	public ResponseEntity<Object> eliminarSolicitud(@PathVariable int id) throws ModelNotFoundException{
		service.eliminarPorSolicitud(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("eliminarRecu/{id}") 
	public ResponseEntity<Object> eliminarRecurso(@PathVariable int id) throws ModelNotFoundException{
		service.eliminarPorRecurso(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}	

}
