package test.tecnico.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.tecnico.daos.PersonaDao;
import test.tecnico.excepciones.ExcepcionDeNegocio;
import test.tecnico.modelos.Persona;

@RestController
@RequestMapping("/personas")
public class ControladorPersona {
	
	@Autowired
	private PersonaDao personaDao;
	
	@GetMapping
	public ResponseEntity<List<Persona>> todasLasPersonas() {
		return new ResponseEntity<List<Persona>>(personaDao.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) {
		return new ResponseEntity<Persona>(personaDao.save(persona), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona, @PathVariable Long id) {
		if(persona.getId() != id) {
			throw new ExcepcionDeNegocio("El id de la entidad con corresponde con el informado");
		}
		Persona personaEnBaseDeDatos = personaDao.findById(id).get();
		personaEnBaseDeDatos.setNombre(persona.getNombre());
		personaEnBaseDeDatos.setApellido(persona.getApellido());
		personaEnBaseDeDatos.setEdad(persona.getEdad());
		personaEnBaseDeDatos.setSexo(persona.getSexo());
		return new ResponseEntity<Persona>(personaDao.save(persona), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> editarPersona(@PathVariable Long id) {
		personaDao.deleteById(id);
		return new ResponseEntity<String>("Recurso eliminado", HttpStatus.OK);
	}

}
