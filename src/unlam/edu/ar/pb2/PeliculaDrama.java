package unlam.edu.ar.pb2;

public class PeliculaDrama extends Pelicula {

	public PeliculaDrama(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	protected String mostrarSinopsis() {
		String sinopsis ="Sinopsis de película dramáticas: \n" + 
	"Título: " + this.titulo + "\n" + "Duración: " + this.duracion + 
	" minutos \n" + "Edad mínima: " + this.edadMinima + " años \n" + "Estas películas son historias reales";
		return sinopsis;

	}

}
