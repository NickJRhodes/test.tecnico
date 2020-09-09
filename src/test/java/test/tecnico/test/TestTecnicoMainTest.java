package test.tecnico.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import test.tecnico.TestTecnicoRestApplication;

@RunWith(SpringRunner.class)
public class TestTecnicoMainTest {
	
	@Test
	public void mainTest() {
		TestTecnicoRestApplication.main(new String[] {});
	}

}
