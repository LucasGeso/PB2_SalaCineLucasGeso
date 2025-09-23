package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeliculaComediaTest {

	PeliculaComedia peli1;

	@BeforeEach
	void setUp(){
		peli1 = new PeliculaComedia("La Máscara", 120, 7);
	}

	@Test
	void queSePuedaCrearUnaPeliDeComediaCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "La Máscara");
	}

	@Test
	void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 120);
	}
	
	@Test
	void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 7);
	}

}
