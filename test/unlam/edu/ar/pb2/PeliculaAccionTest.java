package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeliculaAccionTest {
	
	PeliculaAccion peli1;

	@BeforeEach
	void setUp(){
		peli1 = new PeliculaAccion("Jhon Wick", 120, 13);
	}

	@Test
	void queSePuedaCrearUnaPeliDeAccionCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "Jhon Wick");
	}

	@Test
	void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 120);
	}
	
	@Test
	void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 13);
	}
}
