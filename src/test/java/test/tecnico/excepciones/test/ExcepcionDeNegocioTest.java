package test.tecnico.excepciones.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import test.tecnico.excepciones.ExcepcionDeNegocio;

public class ExcepcionDeNegocioTest {
	
	@Test
	public void mensajeDeExcepcionTest() {
		final String mensajeExcepcion = "Error";
		Throwable e = assertThrows(ExcepcionDeNegocio.class, new Executable() {
	
			@Override
			public void execute() throws Throwable {
				throw new ExcepcionDeNegocio(mensajeExcepcion);
			}
			
		});
		
		assertEquals(mensajeExcepcion, e.getMessage());
	}
	
	@Test
	public void mensajeDeExcepcionConPilaTest() {
		final String mensajeExcepcion = "Error";
		Throwable e = assertThrows(ExcepcionDeNegocio.class, new Executable() {
	
			@Override
			public void execute() throws Throwable {
				try {
					throw new RuntimeException("Mensaje de pila");
				} catch (Exception e2) {
					throw new ExcepcionDeNegocio(mensajeExcepcion, e2);
				}
			}
			
		});
		
		assertEquals(mensajeExcepcion, e.getMessage());
	}

}
