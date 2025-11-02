package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PeliculaInfantilTest {

	private PeliculaInfantil peli1;

	@Before
	public void setUp(){
		peli1 = new PeliculaInfantil("Frozen", 102, 0);
	}

	@Test
	public void queSePuedaCrearUnaPeliDeInfantilCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	public void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "Frozen");
	}

	@Test
	public void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 102);
	}
	
	@Test
	public void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 0);
	}

}
