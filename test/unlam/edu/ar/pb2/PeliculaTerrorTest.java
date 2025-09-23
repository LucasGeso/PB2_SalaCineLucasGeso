package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeliculaTerrorTest {

	PeliculaTerror peli1;

	@BeforeEach
	void setUp(){
		peli1 = new PeliculaTerror("El Conjuro", 112, 16);
	}

	@Test
	void queSePuedaCrearUnaPeliDeTerrorCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "El Conjuro");
	}

	@Test
	void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 112);
	}
	
	@Test
	void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 16);
	}
}
