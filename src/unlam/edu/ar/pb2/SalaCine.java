package unlam.edu.ar.pb2;

import java.util.Map;
import java.util.TreeMap;
public class SalaCine {
	
	private TreeMap<String, Asiento> butacas;
	private Pelicula pelicula;
	
	public SalaCine(Integer cantidadFila, Integer columna) {
		
		this.butacas = new TreeMap<String, Asiento>();
		
		for(int i=1; i<=cantidadFila;i++) {
			for(int j=1; j<=columna; j++) {
				String concatenado = "";
				char letra = ' ';
				letra = (char) (64 + i);
				concatenado = letra + "" +  (j);
				this.butacas.put(concatenado, new Asiento());
			}
		}
	}

	public TreeMap<String, Asiento> getButacas() {
		return butacas;
	}

	public Integer contarAsientosOcupados() {
		Integer asientosOcupados = 0;
		
		for(Asiento asiento : this.butacas.values()) {
			if(asiento.estaOcupado()) {
				asientosOcupados++;
			}
		}
		return asientosOcupados;
	}

	public Integer getTotalAsientos() {
		return this.butacas.size();
	}
	

	public String getTitulo() {
		return this.pelicula.getTitulo();
	}

	public Pelicula getPeliculaActual() {
		return this.pelicula;
	}

	public void cambiarPelicula(Pelicula peliculaSeleccionada) {
		this.pelicula = peliculaSeleccionada;
	}
	
	public boolean venderBoleto(String fila, int columna, int edad, String nombreComprador) {
		String concatenado = fila.toUpperCase() + "" + columna;
		Boolean venta = false;
		if(this.butacas.containsKey(concatenado) && edad>=pelicula.getEdadMinima() && !butacaOcupada(concatenado)) {
			this.butacas.get(concatenado).ocupar(nombreComprador);
			venta = true;
		}
		return venta;
	}
	
	private Boolean butacaOcupada(String concatenado) {
		if(this.butacas.get(concatenado).estaOcupado()) {
			return true;
		}
		return false;
	}


	
	public boolean liberarAsiento(String fila, int columna) {
		String concatenado = fila.toUpperCase()+ "" + columna;
		Boolean liberar = false;
		if(this.butacas.containsKey(concatenado)) {
			this.butacas.get(concatenado).liberar();
			liberar = true;
		}
		return liberar;
	}
	
	public void vaciarLaSala() {
		for(Map.Entry<String, Asiento> prueba : this.butacas.entrySet()) {
			prueba.getValue().liberar();
		}
	}

		
}
