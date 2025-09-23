package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeliculaInfantilTest {

	PeliculaInfantil peli1;

	@BeforeEach
	void setUp(){
		peli1 = new PeliculaInfantil("Frozen", 102, 0);
	}

	@Test
	void queSePuedaCrearUnaPeliDeInfantilCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "Frozen");
	}

	@Test
	void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 102);
	}
	
	@Test
	void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 0);
	}

}
