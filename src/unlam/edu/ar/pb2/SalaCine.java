package unlam.edu.ar.pb2;

import java.util.Map;
import java.util.TreeMap;
public class SalaCine {
	
	/*private Asiento[][] butacas;*/
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
		
	/*public SalaCine(int fila, int columna) {
		this.butacas = new Asiento[fila][columna];
		
		for(int i=0; i<fila; i++) {
			for(int j=0; j<columna;j++) {
				this.butacas[i][j] = new Asiento();
			}
		}*/
	}

	public TreeMap<String, Asiento> getButacas() {
		return butacas;
	}
	
	/*public Asiento[][] getButacas(){
		return butacas;
	}*/

	public Integer contarAsientosOcupados() {
		Integer asientosOcupados = 0;
		
		for(Asiento asiento : this.butacas.values()) {
			if(asiento.estaOcupado()) {
				asientosOcupados++;
			}
		}
		return asientosOcupados;
		
		/*public Integer contarAsientosOcupados() {
		for(int i=0; i<butacas.length; i++) {
			for(int j=0; j<butacas[i].length;j++) {
				if(this.butacas[i][j].estaOcupado()) {
					asientosOcupados++;
				}
			}
		}
		return asientosOcupados;*/
	}

	public Integer getTotalAsientos() {
		return this.butacas.size();
	}
	
	/*public int getTotalAsientos() {
		return butacas.length*butacas[0].length;
	}*/

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

	/*public boolean venderBoleto(int fila, int columna, int edad, String nombreComprador) {
		String concatenado = fila + "" + columna;
		if(this.butacas.containsValue(concatenado) && edad>pelicula.edadMinima) {
			this.butacas.merge(null, concatenado, null);
			return true;
		}
		return false;*/

		
	/*	if(existeButaca(fila, columna)) {
			if(!butacas[fila][columna].estaOcupado() && edad>pelicula.edadMinima) {
				butacas[fila][columna].ocupar(nombreComprador);
				return true;
			}
			return false;
		}
		return false;

	}*/
	
	/*private boolean existeButaca(int fila, int columna) {
		if(fila<butacas.length && columna<butacas[0].length) {
			return true;
		}
		return false;
	}*/
	
	public boolean liberarAsiento(String fila, int columna) {
		String concatenado = fila.toUpperCase()+ "" + columna;
		Boolean liberar = false;
		if(this.butacas.containsKey(concatenado)) {
			this.butacas.get(concatenado).liberar();
			liberar = true;
		}
		return liberar;
	}

	/*public boolean liberarAsiento(int fila, int columna) {
		if(butacas[fila][columna].estaOcupado()) {
			butacas[fila][columna].liberar();
			return true;
		}	
				return false;
	}*/
	
	public void vaciarLaSala() {
		for(Map.Entry<String, Asiento> prueba : this.butacas.entrySet()) {
			prueba.getValue().liberar();
		}
	}

	/*public void vaciarLaSala() {
		for(int i=0; i<butacas.length; i++) {
			for(int j=0; j<butacas[i].length;j++) {
				if(this.butacas[i][j].estaOcupado()) {
					this.butacas[i][j].liberar();
				}
			}
		}
		}*/
		
}
