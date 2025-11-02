package unlam.edu.ar.pb2.candy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CandyBarTest {

    private CandyBar candyBar;
    private Snack palomitas;
    private Bebida refresco;
    private Bebida agua;
    private Snack papas;
    private Snack nachos;

    // Se ejecuta antes de cada test para inicializar el objeto CandyBar
    @Before
    public void setUp() {
        candyBar = new CandyBar(5); // Capacidad para 5 productos
        palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 10);
        refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
        agua = new Bebida("Agua sin gas", 2.0, Contenedor.BOTELLA, 20);
        papas = new Snack("Lays", 10.0, Tamano.GRANDE, 30);
        nachos = new Snack("Nachos", 7.0, Tamano.MEDIANO, 10);
    }

    @Test
    public void testAgregarProducto() throws ProductoDuplicadoExeption {
        assertTrue(candyBar.agregarProducto(palomitas));
        assertEquals(1, contarProductosEnInventario());

        assertTrue(candyBar.agregarProducto(refresco));
        assertEquals(2, contarProductosEnInventario());
        
        assertTrue(candyBar.agregarProducto(nachos));
        assertEquals(3, contarProductosEnInventario());
    }
    
    @Test(expected = ProductoDuplicadoExeption.class)
    public void testNoAgregarProductosRepetidos() throws ProductoDuplicadoExeption {
    	candyBar.agregarProducto(palomitas);
    	candyBar.agregarProducto(palomitas);
    	  assertEquals(1, contarProductosEnInventario());
    }

    @Test
    public void testEliminarProductoExistente() throws ProductoDuplicadoExeption, ProductoNoEncontradoException {
        candyBar.agregarProducto(palomitas);
        candyBar.agregarProducto(refresco);

        Boolean eliminado = candyBar.eliminarProducto("Palomitas");
        assertTrue(eliminado);
        assertEquals(1, contarProductosEnInventario());
    }

    @Test(expected = ProductoNoEncontradoException.class)
    public void testEliminarProductoNoExistente() throws ProductoDuplicadoExeption, ProductoNoEncontradoException {
        candyBar.agregarProducto(palomitas);
        candyBar.eliminarProducto("Chocolate");
        assertEquals(1, contarProductosEnInventario());
    }

    @Test
    public void testInventarioLleno() throws ProductoDuplicadoExeption {
    	
        // Llenar el inventario hasta su capacidad
    	//APLICO DIFERENTE STOCK POR EL ORDEN NATURAL QUE SE ASIGNO
    	Integer stock = 1;
        for (int i = 0; i < 5; i++) {
            candyBar.agregarProducto(new Snack("Snack " + i, 1.0, Tamano.MEDIANO, stock++));
        }

        // Intentar agregar un sexto producto
        boolean agregado = candyBar.agregarProducto(new Snack("Snack Extra", 1.0, Tamano.MEDIANO, 3));
        assertFalse(agregado);
        assertEquals(5, contarProductosEnInventario());
    }
    
    @Test
    public void queSoloSePuedanVerLasBebidas() throws ProductoDuplicadoExeption {
        candyBar.agregarProducto(palomitas);
        candyBar.agregarProducto(refresco);
        candyBar.agregarProducto(agua);
        candyBar.agregarProducto(papas);
        
        ArrayList<Producto> listaBebidas = new ArrayList<Producto>();
    	listaBebidas.add(agua); // PRECIO BASE 2.0
    	listaBebidas.add(refresco); // PRECIO BASE 3.0
    	
    	assertEquals(listaBebidas, candyBar.mostrarLasBebidas());
    	assertEquals(listaBebidas.size(), candyBar.mostrarLasBebidas().size());
    }
    
    @Test
    public void queSoloSePuedanVerLosSnacks() throws ProductoDuplicadoExeption {
        candyBar.agregarProducto(palomitas);
        candyBar.agregarProducto(refresco);
        candyBar.agregarProducto(agua);
        candyBar.agregarProducto(papas);
        
        ArrayList<Producto> listaSnacks = new ArrayList<Producto>();
    	listaSnacks.add(papas); // NOMBRE: LAYS
    	listaSnacks.add(palomitas); // NOMBRE: PALOMITAS
    	
    	assertEquals(listaSnacks, candyBar.mostrarLosSnacks());
    	assertEquals(listaSnacks.size(), candyBar.mostrarLosSnacks().size());
    }
    

   private int contarProductosEnInventario() {
	   return candyBar.obtenerInventario().size();
    }
    
}

