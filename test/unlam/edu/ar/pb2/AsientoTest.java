package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AsientoTest {
	Asiento asiento1; //ASIENTO LIBRE
	Asiento asiento2; //ASIENTO OCUPADO

	@BeforeEach
	void setUp() {
		asiento1 = new Asiento();
		asiento2 = new Asiento("Lucas", true);
	}

	@Test
	void queSePuedaCrearUnAsientoCorrectamente() {
		assertNotNull(asiento1);
		assertNotNull(asiento2);
	}
	
	@Test
	void queSePuedaVerElNombreDelCompradorDelAsiento() {
		assertEquals(asiento2.getNombreComprador(), "Lucas");
	}
	
	@Test
	void queSePuedaVerificarQueUnAsientoEstaOcupado() {
		assertTrue(asiento2.estaOcupado());
	}
	
	@Test
	void queSePuedaVerificarQueUnAsientoEstaLibre() {
		assertFalse(asiento1.estaOcupado());
	}
	
	@Test
	void queSePuedaLiberarUnAsientoOcupado() {
		asiento2.liberar();
		assertFalse(asiento2.estaOcupado());
	}
	
	@Test
	void queSePuedaOcuparUnAsientoLibre() {
		asiento1.ocupar("Lucas");
		assertTrue(asiento1.estaOcupado());
	}
	
	@Test
	void queSePuedanCompararDosAsientosIguales() {
		Asiento prueba = new Asiento("Lucas", true);
		assertEquals(asiento2, prueba);
	}

}
