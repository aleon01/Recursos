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
import co.edu.unicundi.recursosInvestigacion.entity.Recurso;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.service.IRecursoService;

@RestController
@RequestMapping("/recurso")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class RecursoController {

	@Autowired
	private IRecursoService service;
	
	@GetMapping("/retornar")
	public ResponseEntity<?> retornar() {
			List<Recurso> listaRecurso = service.retornar();
			return new ResponseEntity<List<Recurso>>(listaRecurso, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaPorId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException{
		Recurso recurso = service.retornarPorId(id);
		return new ResponseEntity<Recurso>(recurso, HttpStatus.OK);			
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Recurso recurso) throws ModelNotFoundException {	
			service.guardar(recurso);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@Valid @RequestBody Recurso recurso) throws ModelNotFoundException{	
			service.editar(recurso);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}	
	
	@DeleteMapping("eliminar/{id}") 
	public ResponseEntity<Object> elimianr(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}	

}
