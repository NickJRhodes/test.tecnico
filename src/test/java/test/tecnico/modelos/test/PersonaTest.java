package test.tecnico.modelos.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import test.tecnico.enums.Sexo;
import test.tecnico.excepciones.ExcepcionDeNegocio;
import test.tecnico.modelos.Persona;

public class PersonaTest {
	
	private Persona persona;
	
	@Before
	public void setup() {
		persona = new Persona();
	}
	
	@Test
	public void setIdTest() {
		final Long id = 25L;
		persona.setId(id);
		assertTrue(id.equals(persona.getId()));
	}
	
	@Test
	public void setNombreTest() {
		final String nombre = "Mario";
		persona.setNombre(nombre);
		assertTrue(nombre.equals(persona.getNombre()));
	}
	
	@Test
	public void setApellidoTest() {
		final String apellido = "Gómez";
		persona.setApellido(apellido);
		assertTrue(apellido.equals(persona.getApellido()));
	}
	
	@Test
	public void setEdadTest() {
		final Integer edad = 10;
		persona.setEdad(edad);
		assertTrue(edad.equals(persona.getEdad()));
	}
	
	@Test
	public void setSexoTest() {
		final Sexo sexo = Sexo.M;
		persona.setSexo(sexo);
		assertTrue(sexo.equals(persona.getSexo()));
	}
	
	@Test(expected = ExcepcionDeNegocio.class)
	public void setNombreNullTest() {
		persona.setNombre(null);
	}
	
	@Test(expected = ExcepcionDeNegocio.class)
	public void setApellidoNullTest() {
		persona.setApellido(null);
	}
	
	@Test(expected = ExcepcionDeNegocio.class)
	public void setEdadNullTest() {
		persona.setEdad(null);
	}
	
	@Test(expected = ExcepcionDeNegocio.class)
	public void setSexoNullTest() {
		persona.setSexo(null);
	}

}
