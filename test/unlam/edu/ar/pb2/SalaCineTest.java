package unlam.edu.ar.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalaCineTest {
	
	SalaCine sala1;
	Pelicula peli1;
	
	@BeforeEach
	void setUp() {
		sala1 = new SalaCine(4,4);
		peli1 = new PeliculaAccion("Jhon Wick", 120, 13);
	}

	@Test
	void crearUnaSala() {
		assertNotNull(sala1);
	}
	
	@Test
	void obtenerLasButacasInicializadas(){
		Asiento[][] prueba = new Asiento[4][4];
		for(int i=0;i<prueba.length;i++) {
			for(int j=0;j<prueba[i].length;j++) {
				prueba[i][j]= new Asiento();
			}
		}
		assertArrayEquals(sala1.getButacas(), prueba);
	}
	
	@Test
	void queSePuedaContarLaCantidadDeAsientosTotalDeLaSala() {
		assertEquals(sala1.getTotalAsientos(), 16);
	}
	
	@Test
	void queSePuedaContarLaCantidadDeAsientosOcupadosDeLaSala() {
		sala1.cambiarPelicula(peli1);
		sala1.venderBoleto(1, 1, 33, "Lucas");
		sala1.venderBoleto(1, 2, 34, "Hugo");
		sala1.venderBoleto(1, 3, 35, "Jesús");
		assertEquals(sala1.contarAsientosOcupados(), 3);
	}
	
	@Test
	void queSePuedaCambiarUnaPelicula() {
		sala1.cambiarPelicula(peli1);
		assertEquals(sala1.getPeliculaActual(),peli1);
	}
	
	@Test
	void queSePuedaVerElTituloDeLaPeliculaDeLaSala() {
		sala1.cambiarPelicula(peli1);
		assertEquals(sala1.getTitulo(), "Jhon Wick");
	}
	
	@Test
	void queSePuedaVenderUnBoleto() {
		sala1.cambiarPelicula(peli1);
		assertTrue(sala1.venderBoleto(1, 1, 33, "Lucas"));
	}
	
	@Test
	void queNoSePuedaVenderUnBoletoAUnaPersonaQueNoCumplaConLaEdadMinima() {
		sala1.cambiarPelicula(peli1);
		assertFalse(sala1.venderBoleto(1, 1, 10, "Lucas"));
	}
	
	@Test
	void queNoSePuedaVenderBoletoParaUnAsientoOcupado() {
		sala1.cambiarPelicula(peli1);
		assertTrue(sala1.venderBoleto(1, 1, 33, "Lucas"));
		assertFalse(sala1.venderBoleto(1, 1, 35, "Johanna"));
	}
	
	@Test
	void queNoSePuedaVenderUnBoletoAParaUnaFilaDeButacasQueNoExiste() {
		sala1.cambiarPelicula(peli1);
		assertFalse(sala1.venderBoleto(5, 1, 33, "Lucas"));
	}
	
	@Test
	void queNoSePuedaVenderUnBoletoAParaUnaColumnaDeButacasQueNoExiste() {
		sala1.cambiarPelicula(peli1);
		assertFalse(sala1.venderBoleto(1, 5, 33, "Lucas"));
	}
	
	@Test
	void queSePuedaLiberarUnAsientoQueSeEncuentraOcupado() {
		sala1.cambiarPelicula(peli1);
		assertTrue(sala1.venderBoleto(1, 1, 33, "Lucas"));
		assertTrue(sala1.liberarAsiento(1, 1));
	}
	
	@Test
	void queSePuedanContarLaCantidadDeAsientosOcupados() {
		sala1.cambiarPelicula(peli1);
		sala1.venderBoleto(1, 1, 33, "Lucas");
		sala1.venderBoleto(1, 2, 34, "Hugo");
		sala1.venderBoleto(1, 3, 35, "Jesús");
		assertEquals(sala1.contarAsientosOcupados(),3);
	}
	
	@Test
	void queSePuedaVaciarUnaSala() {
		sala1.cambiarPelicula(peli1);
		sala1.venderBoleto(1, 1, 33, "Lucas");
		sala1.venderBoleto(1, 2, 34, "Hugo");
		sala1.venderBoleto(1, 3, 35, "Jesús");
		sala1.vaciarLaSala();
		assertEquals(sala1.contarAsientosOcupados(),0);
	}
	
	
	
	

}
