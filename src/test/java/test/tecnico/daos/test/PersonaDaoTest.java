package test.tecnico.daos.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.tecnico.daos.PersonaDao;
import test.tecnico.enums.Sexo;
import test.tecnico.modelos.Persona;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonaDaoTest {
	
	@Autowired
	private PersonaDao personaDao;
	
	@Test
	public void crearybuscarPersona() {
		Persona persona = new Persona();
		persona.setNombre("Nombre");
		persona.setApellido("Apellido");
		persona.setEdad(10);
		persona.setSexo(Sexo.M);
		
		Persona temp = personaDao.saveAndFlush(persona);
		
		final Persona personaEnBaseDeDatos = personaDao.findById(temp.getId()).get();
		
		assertThat(personaEnBaseDeDatos.getNombre()).isEqualTo(persona.getNombre());
		assertThat(personaEnBaseDeDatos.getApellido()).isEqualTo(persona.getApellido());
		assertThat(personaEnBaseDeDatos.getEdad()).isEqualTo(persona.getEdad());
		assertThat(personaEnBaseDeDatos.getSexo()).isEqualTo(persona.getSexo());
	}
	
	@Test
	public void editarPersona() {
		Persona persona = new Persona();
		persona.setNombre("Nombre");
		persona.setApellido("Apellido");
		persona.setEdad(10);
		persona.setSexo(Sexo.M);
		
		Persona temp = personaDao.save(persona);
		temp.setNombre("Nombre2");
		temp.setApellido("Apellido2");
		temp.setEdad(20);
		temp.setSexo(Sexo.F);
		personaDao.save(temp);
		
		final Persona personaEnBaseDeDatos = personaDao.findById(temp.getId()).get();
		
		assertThat(personaEnBaseDeDatos.getNombre()).isEqualTo(temp.getNombre());
		assertThat(personaEnBaseDeDatos.getApellido()).isEqualTo(temp.getApellido());
		assertThat(personaEnBaseDeDatos.getEdad()).isEqualTo(temp.getEdad());
		assertThat(personaEnBaseDeDatos.getSexo()).isEqualTo(temp.getSexo());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void borrarPersona() {
		Persona persona = new Persona();
		persona.setNombre("Nombre");
		persona.setApellido("Apellido");
		persona.setEdad(10);
		persona.setSexo(Sexo.M);
		
		Persona temp = personaDao.saveAndFlush(persona);
		
		personaDao.deleteById(temp.getId());

		personaDao.findById(temp.getId()).get();
	}

}
