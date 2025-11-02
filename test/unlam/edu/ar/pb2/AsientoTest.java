package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AsientoTest {
	Asiento asiento1; //ASIENTO LIBRE
	Asiento asiento2; //ASIENTO OCUPADO

	@Before
	public void setUp() {
		asiento1 = new Asiento();
		asiento2 = new Asiento("Lucas", true);
	}

	@Test
	public void queSePuedaCrearUnAsientoCorrectamente() {
		assertNotNull(asiento1);
		assertNotNull(asiento2);
	}
	
	@Test
	public void queSePuedaVerElNombreDelCompradorDelAsiento() {
		assertEquals(asiento2.getNombreComprador(), "Lucas");
	}
	
	@Test
	public void queSePuedaVerificarQueUnAsientoEstaOcupado() {
		assertTrue(asiento2.estaOcupado());
	}
	
	@Test
	public void queSePuedaVerificarQueUnAsientoEstaLibre() {
		assertFalse(asiento1.estaOcupado());
	}
	
	@Test
	public void queSePuedaLiberarUnAsientoOcupado() {
		asiento2.liberar();
		assertFalse(asiento2.estaOcupado());
	}
	
	@Test
	public void queSePuedaOcuparUnAsientoLibre() {
		asiento1.ocupar("Lucas");
		assertTrue(asiento1.estaOcupado());
	}
	
	@Test
	public void queSePuedanCompararDosAsientosIguales() {
		Asiento prueba = new Asiento("Lucas", true);
		assertEquals(asiento2, prueba);
	}

}
