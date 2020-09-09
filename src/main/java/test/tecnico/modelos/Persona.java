package test.tecnico.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.logging.log4j.util.Strings;

import test.tecnico.enums.Sexo;
import test.tecnico.excepciones.ExcepcionDeNegocio;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;
	
	@Column(nullable = false)
	private Integer edad;
	
	@Column(nullable = false)
	private Sexo sexo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(Strings.isEmpty(nombre)) {
			throw new ExcepcionDeNegocio("Nombre de la persona vacío.");
		}
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if(Strings.isEmpty(apellido)) {
			throw new ExcepcionDeNegocio("Apellido de la persona vacío.");
		}
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		if(edad == null) {
			throw new ExcepcionDeNegocio("Edad de la persona vacío.");
		}
		this.edad = edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		if(sexo == null) {
			throw new ExcepcionDeNegocio("Sexo de la persona vacío.");
		}
		this.sexo = sexo;
	}

}
