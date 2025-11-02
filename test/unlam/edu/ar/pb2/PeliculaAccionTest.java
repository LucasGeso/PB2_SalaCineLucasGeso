package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PeliculaAccionTest {
	
	private PeliculaAccion peli1;

	@Before
	public void setUp(){
		peli1 = new PeliculaAccion("Jhon Wick", 120, 13);
	}

	@Test
	public void queSePuedaCrearUnaPeliDeAccionCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	public void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "Jhon Wick");
	}

	@Test
	public void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 120);
	}
	
	@Test
	public void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 13);
	}
}
