package test.tecnico.excepciones;

public class ExcepcionDeNegocio extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionDeNegocio(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionDeNegocio(String mensaje, Throwable pila) {
		super(mensaje, pila);
	}
}
