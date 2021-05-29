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

import co.edu.unicundi.recursosInvestigacion.dto.roluserDTO;
import co.edu.unicundi.recursosInvestigacion.entity.RolUser;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.service.IRolUserService;

@RestController
@RequestMapping("/roluser")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class RolUserController {

	@Autowired
	private IRolUserService service;
	
	@GetMapping("/retornar")
	public ResponseEntity<?> retornar() {
			List<roluserDTO> listaRolU = service.retornar();
			return new ResponseEntity<List<roluserDTO>>(listaRolU, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaPorId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException{
		roluserDTO rolu = service.retornarPorId(id);
		return new ResponseEntity<roluserDTO>(rolu, HttpStatus.OK);			
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody RolUser rolu) throws ModelNotFoundException {	
			service.guardar(rolu);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@Valid @RequestBody RolUser rolu) throws ModelNotFoundException{	
			service.editar(rolu);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}	
	
	@DeleteMapping("eliminar/{roluId}") 
	public ResponseEntity<Object> elimianr(@PathVariable Integer roluId) throws ModelNotFoundException{
		service.eliminar(roluId);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}	
	
}
