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

import co.edu.unicundi.recursosInvestigacion.dto.usuarioDTO;
import co.edu.unicundi.recursosInvestigacion.entity.Usuario;
import co.edu.unicundi.recursosInvestigacion.exception.ModelNotFoundException;
import co.edu.unicundi.recursosInvestigacion.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/retornaUserPassJPQL/{user}/{pass}")
	public ResponseEntity<?> retornaUserPass(@PathVariable String user, @PathVariable String pass) throws ModelNotFoundException{
			usuarioDTO userUsuario = service.consultarUsuarioAndContrasena(user, pass);
			return new ResponseEntity<usuarioDTO>(userUsuario, HttpStatus.OK);			
	}
	
	@GetMapping("/retornaUserPassFind/{user}/{pass}")
	public ResponseEntity<?> retornaUserPassFind(@PathVariable String user, @PathVariable String pass) throws ModelNotFoundException{
			usuarioDTO userUsuario = service.findByUserUsuarioAndUserContrasena(user, pass);
			return new ResponseEntity<usuarioDTO>(userUsuario, HttpStatus.OK);			
	}
	
	@GetMapping("/retornar")
	public ResponseEntity<?> retornar() {
			List<usuarioDTO> listaUser = service.retornar();
			return new ResponseEntity<List<usuarioDTO>>(listaUser, HttpStatus.OK);			
	}	
	
	@GetMapping("/retornaPorId/{id}")
	public ResponseEntity<?> retornarPorId(@PathVariable int id) throws ModelNotFoundException{
			usuarioDTO user = service.retornarPorId(id);
			return new ResponseEntity<usuarioDTO>(user, HttpStatus.OK);			
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Usuario usuario) throws ModelNotFoundException {	
			service.guardar(usuario);
			return new ResponseEntity<Object>("", HttpStatus.CREATED);				
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario) throws ModelNotFoundException{	
			service.editar(usuario);
			return new ResponseEntity<Object>("", HttpStatus.OK);				
	}	
	
	@DeleteMapping("eliminar/{id}") 
	public ResponseEntity<Object> elimianr(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
	}	
	
}
