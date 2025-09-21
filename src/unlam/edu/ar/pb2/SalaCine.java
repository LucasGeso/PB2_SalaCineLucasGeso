package unlam.edu.ar.pb2;

public class SalaCine {
	
	private Asiento[][] butacas;
	private Pelicula pelicula;
	
	public SalaCine(int fila, int columna) {
		this.butacas = new Asiento[fila][columna];
		
		for(int i=0; i<fila; i++) {
			for(int j=0; j<columna;j++) {
				this.butacas[i][j] = new Asiento();
			}
		}
	}
	
	public Asiento[][] getButacas(){
		return butacas;
	}

	public int contarAsientosOcupados() {
		int asientosOcupados = 0;
		
		for(int i=0; i<butacas.length; i++) {
			for(int j=0; j<butacas[i].length;j++) {
				if(this.butacas[i][j].estaOcupado()) {
					asientosOcupados++;
				}
			}
		}
		
		return asientosOcupados;
	}

	public int getTotalAsientos() {
		return butacas.length*butacas[0].length;
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

	public boolean venderBoleto(int fila, int columna, int edad, String nombreComprador) {

		if(existeButaca(fila, columna)) {
			if(!butacas[fila][columna].estaOcupado() && edad>pelicula.edadMinima) {
				butacas[fila][columna].ocupar(nombreComprador);
				return true;
			}
			return false;
		}
		return false;

	}
	
	private boolean existeButaca(int fila, int columna) {
		if(fila<butacas.length && columna<butacas[0].length) {
			return true;
		}
		return false;
	}

	public boolean liberarAsiento(int fila, int columna) {
		if(butacas[fila][columna].estaOcupado()) {
			butacas[fila][columna].liberar();
			return true;
		}	
				return false;
	}

	public void vaciarLaSala() {
		for(int i=0; i<butacas.length; i++) {
			for(int j=0; j<butacas[i].length;j++) {
				if(this.butacas[i][j].estaOcupado()) {
					this.butacas[i][j].liberar();
				}
			}
		}
		
	}

}
