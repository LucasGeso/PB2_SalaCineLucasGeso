package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SalaCineTest {
	
	private SalaCine sala1;
	private Pelicula peli1;
	
	@Before
	public void setUp() {
		sala1 = new SalaCine(4,4);
		peli1 = new PeliculaAccion("Jhon Wick", 120, 13);
	}

	@Test
	public void crearUnaSala() {
		assertNotNull(sala1);
	}
	
	@Test
	public void obtenerLasButacasInicializadas(){
		ArrayList<Asiento> prueba = new ArrayList<Asiento>();
		ArrayList<Asiento> pruebaButacas = new ArrayList<Asiento>();
			for(int i=0; i<16; i++) {
				prueba.add(new Asiento());
			}
		for(Asiento asientoCine : sala1.getButacas().values()) {
			pruebaButacas.add(asientoCine);
		}
		assertEquals(pruebaButacas, prueba);	
	}
	
	@Test
	public void queSePuedaContarLaCantidadDeAsientosTotalDeLaSala() {
		assertEquals(Integer.valueOf(sala1.getTotalAsientos()), Integer.valueOf(16));
	}
	
	@Test
	public void queSePuedaContarLaCantidadDeAsientosOcupadosDeLaSala() {
		sala1.cambiarPelicula(peli1);
		sala1.venderBoleto("A", 1, 33, "Lucas");
		sala1.venderBoleto("A", 2, 34, "Hugo");
		sala1.venderBoleto("A", 3, 35, "Jesús");
		assertEquals(Integer.valueOf(sala1.contarAsientosOcupados()), Integer.valueOf(3));
	}
	
	@Test
	public void queSePuedaCambiarUnaPelicula() {
		sala1.cambiarPelicula(peli1);
		assertEquals(sala1.getPeliculaActual(),peli1);
	}
	
	@Test
	public void queSePuedaVerElTituloDeLaPeliculaDeLaSala() {
		sala1.cambiarPelicula(peli1);
		assertEquals(sala1.getTitulo(), "Jhon Wick");
	}
	
	@Test
	public void queSePuedaVenderUnBoleto() {
		sala1.cambiarPelicula(peli1);
		assertTrue(sala1.venderBoleto("A", 1, 33, "Lucas"));
	}
	
	@Test
	public void queNoSePuedaVenderUnBoletoAUnaPersonaQueNoCumplaConLaEdadMinima() {
		sala1.cambiarPelicula(peli1);
		assertFalse(sala1.venderBoleto("A", 1, 10, "Lucas"));
	}
	
	@Test
	public void queNoSePuedaVenderBoletoParaUnAsientoOcupado() {
		sala1.cambiarPelicula(peli1);
		assertTrue(sala1.venderBoleto("A", 1, 33, "Lucas"));
		assertFalse(sala1.venderBoleto("A", 1, 35, "Johanna"));
	}
	
	@Test
	public void queNoSePuedaVenderUnBoletoAParaUnaFilaDeButacasQueNoExiste() {
		sala1.cambiarPelicula(peli1);
		assertFalse(sala1.venderBoleto("F", 1, 33, "Lucas"));
	}
	
	@Test
	public void queNoSePuedaVenderUnBoletoAParaUnaColumnaDeButacasQueNoExiste() {
		sala1.cambiarPelicula(peli1);
		assertFalse(sala1.venderBoleto("A", 5, 33, "Lucas"));
	}
	
	@Test
	public void queSePuedaLiberarUnAsientoQueSeEncuentraOcupado() {
		sala1.cambiarPelicula(peli1);
		assertTrue(sala1.venderBoleto("A", 1, 33, "Lucas"));
		assertTrue(sala1.liberarAsiento("A", 1));
	}
	
	@Test
	public void queSePuedanContarLaCantidadDeAsientosOcupados() {
		sala1.cambiarPelicula(peli1);
		sala1.venderBoleto("A", 1, 33, "Lucas");
		sala1.venderBoleto("A", 2, 34, "Hugo");
		sala1.venderBoleto("A", 3, 35, "Jesús");
		assertEquals(Integer.valueOf(sala1.contarAsientosOcupados()), Integer.valueOf(3));
	}
	
	@Test
	public void queSePuedaVaciarUnaSala() {
		sala1.cambiarPelicula(peli1);
		sala1.venderBoleto("A", 1, 33, "Lucas");
		sala1.venderBoleto("A", 2, 34, "Hugo");
		sala1.venderBoleto("A", 3, 35, "Jesús");
		sala1.vaciarLaSala();
		assertEquals(Integer.valueOf(sala1.contarAsientosOcupados()), Integer.valueOf(0));
	}
	
	
	
	

}
