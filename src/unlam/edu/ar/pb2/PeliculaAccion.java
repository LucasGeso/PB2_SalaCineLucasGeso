package unlam.edu.ar.pb2;

public class PeliculaAccion extends Pelicula {

	public PeliculaAccion(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
	}

	@Override
	protected String mostrarSinopsis() {
		String sinopsis ="Sinopsis de película de acción: \n" + 
	"Título: " + this.titulo + "\n" + "Duración: " + this.duracion + 
	" minutos \n" + "Edad mínima: " + this.edadMinima + " años \n" + "Estas películas tienen un alto grado de Violencia, efectos especiales y unas grandes historias";
		return sinopsis;
	}
	
	

}
