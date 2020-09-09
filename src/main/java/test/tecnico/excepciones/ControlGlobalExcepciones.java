package test.tecnico.excepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlGlobalExcepciones {
	
	private static final Logger logger = LoggerFactory.getLogger(ControlGlobalExcepciones.class);
	
	private static final String MENSAJE_GENERICO = "Error inesperado.";
	
	@ExceptionHandler
	public ResponseEntity<String> lanzarPorCualquierExcepcion(Exception e) {
		logger.error("Error en controlador.", e);
		return new ResponseEntity<String>(MENSAJE_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
