package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PeliculaDramaTest {
	
	private PeliculaDrama peli1;

	@Before
	public void setUp(){
		peli1 = new PeliculaDrama("Forrest Gump", 142, 13);
	}

	@Test
	public void queSePuedaCrearUnaPeliDeDramaCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	public void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "Forrest Gump");
	}

	@Test
	public void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 142);
	}
	
	@Test
	public void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 13);
	}

}
