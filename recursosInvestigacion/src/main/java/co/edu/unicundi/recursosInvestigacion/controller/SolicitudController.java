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

import co.edu.unicundi.recursosInvestigacion.dto.solicitudDTO;
import co.edu.unicundi.recursosInvestigacion.entity.Solicitudes;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.service.ISolicitudesService;

@RestController
@RequestMapping("/solicitud")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SolicitudController {

	@Autowired
	private ISolicitudesService service;
	
	@GetMapping("/retornar")
	public ResponseEntity<?> retornar() {
			List<solicitudDTO> listaSolicitud = service.retornar();
			return new ResponseEntity<List<solicitudDTO>>(listaSolicitud, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaPorId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException{
		solicitudDTO solicitud = service.retornarPorId(id);
		return new ResponseEntity<solicitudDTO>(solicitud, HttpStatus.OK);			
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Solicitudes solicitud) throws ModelNotFoundException {	
			service.guardar(solicitud);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@Valid @RequestBody Solicitudes solicitud) throws ModelNotFoundException, Exception{	
			service.editar(solicitud);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}	
	
	@DeleteMapping("eliminar/{id}") 
	public ResponseEntity<Object> eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}	
}
