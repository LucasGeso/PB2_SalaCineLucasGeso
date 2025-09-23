package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeliculaDramaTest {
	
	PeliculaDrama peli1;

	@BeforeEach
	void setUp(){
		peli1 = new PeliculaDrama("Forrest Gump", 142, 13);
	}

	@Test
	void queSePuedaCrearUnaPeliDeDramaCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "Forrest Gump");
	}

	@Test
	void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 142);
	}
	
	@Test
	void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 13);
	}

}
