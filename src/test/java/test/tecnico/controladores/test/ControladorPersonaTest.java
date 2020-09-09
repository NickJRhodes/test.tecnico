package test.tecnico.controladores.test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import test.tecnico.controladores.ControladorPersona;
import test.tecnico.daos.PersonaDao;
import test.tecnico.enums.Sexo;
import test.tecnico.modelos.Persona;
import test.tecnico.utils.JsonUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(ControladorPersona.class)
public class ControladorPersonaTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PersonaDao personaDao;
	
	@Test
	public void getPersonasTest() throws Exception {
		mvc.perform(get("/personas")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void postPersonaTest() throws Exception {
		Persona persona = new Persona();
		persona.setNombre("Nombre");
		persona.setApellido("Apellido");
		persona.setEdad(10);
		persona.setSexo(Sexo.M);
		
		given(personaDao.save(Mockito.any())).willReturn(persona);
		
		mvc.perform(post("/personas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(persona)))
				.andExpect(status().isCreated());
		
		reset(personaDao);
	}
	
	@Test
	public void editarPersonaTest() throws Exception {
		Persona persona = new Persona();
		persona.setId(1L);
		persona.setNombre("Nombre");
		persona.setApellido("Apellido");
		persona.setEdad(10);
		persona.setSexo(Sexo.M);
		
		given(personaDao.save(Mockito.any())).willReturn(persona);
		given(personaDao.findById(Mockito.anyLong())).willReturn(Optional.of(persona));
		
		mvc.perform(post("/personas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(persona)))
				.andExpect(status().isCreated());
		
		mvc.perform(put("/personas/" + persona.getId().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(persona)))
				.andExpect(status().isOk());
		
		reset(personaDao);
	}
	
	@Test
	public void editarPersonaExcepcionTest() throws Exception {
		Persona persona = new Persona();
		persona.setId(1L);
		persona.setNombre("Nombre");
		persona.setApellido("Apellido");
		persona.setEdad(10);
		persona.setSexo(Sexo.M);
		
		Persona personaEditada = new Persona();
		personaEditada.setId(20L);
		personaEditada.setNombre(persona.getNombre());
		personaEditada.setApellido(persona.getApellido());
		personaEditada.setEdad(persona.getEdad());
		personaEditada.setSexo(persona.getSexo());
		
		given(personaDao.save(Mockito.any())).willReturn(persona);
		given(personaDao.findById(Mockito.anyLong())).willReturn(Optional.of(personaEditada));
		
		mvc.perform(post("/personas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(persona)))
				.andExpect(status().isCreated());
		
		mvc.perform(put("/personas/" + persona.getId().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(personaEditada)))
				.andExpect(status().isInternalServerError());
		
		reset(personaDao);
	}
	
	@Test
	public void borrarPersonaTest() throws Exception {
		Persona persona = new Persona();
		persona.setId(1L);
		persona.setNombre("Nombre");
		persona.setApellido("Apellido");
		persona.setEdad(10);
		persona.setSexo(Sexo.M);
		
		given(personaDao.save(Mockito.any())).willReturn(persona);
		
		mvc.perform(post("/personas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(persona)))
				.andExpect(status().isCreated());
		
		mvc.perform(delete("/personas/" + persona.getId().toString())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		reset(personaDao);
	}

}
