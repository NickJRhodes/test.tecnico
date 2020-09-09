package test.tecnico.enums.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import test.tecnico.enums.Sexo;

public class SexoTest {
	
	@Test
	public void existeMasculinoTest() {
		assertThat(Sexo.M).isNotNull();
	}
	
	@Test
	public void existeFemeninoTest() {
		assertThat(Sexo.F).isNotNull();
	}

}
