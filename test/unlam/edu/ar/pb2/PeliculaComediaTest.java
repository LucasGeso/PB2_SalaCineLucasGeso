package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PeliculaComediaTest {

	private PeliculaComedia peli1;

	@Before
	public void setUp(){
		peli1 = new PeliculaComedia("La Máscara", 120, 7);
	}

	@Test
	public void queSePuedaCrearUnaPeliDeComediaCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	public void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "La Máscara");
	}

	@Test
	public void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 120);
	}
	
	@Test
	public void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 7);
	}

}
