package unlam.edu.ar.pb2;

public class PeliculaComedia extends Pelicula {

	public PeliculaComedia(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	protected String mostrarSinopsis() {
		String sinopsis ="Sinopsis de película cómicas: \n" + 
	"Título: " + this.titulo + "\n" + "Duración: " + this.duracion + 
	" minutos \n" + "Edad mínima: " + this.edadMinima + " años \n" + "Estas películas son ideales para reir";
		return sinopsis;

	}

}
