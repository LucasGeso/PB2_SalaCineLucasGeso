package unlam.edu.ar.pb2;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class PeliculaTerrorTest {

	private PeliculaTerror peli1;

	@Before
	public void setUp(){
		peli1 = new PeliculaTerror("El Conjuro", 112, 16);
	}

	@Test
	public void queSePuedaCrearUnaPeliDeTerrorCorrectamente() {
		assertNotNull(peli1);
	}
	
	@Test
	public void queSePuedaObtenerElTituloDeLaPelicula() {
		assertEquals(peli1.getTitulo(), "El Conjuro");
	}

	@Test
	public void queSePuedaObtenerLaDuracionDeLaPelicula() {
		assertEquals(peli1.getDuracion(), 112);
	}
	
	@Test
	public void queSePuedaObtenerLaEdadMinimaParaVerLaPelicula() {
		assertEquals(peli1.getEdadMinima(), 16);
	}
}
