package unlam.edu.ar.pb2;

public class PeliculaTerror extends Pelicula {

	public PeliculaTerror(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	protected String mostrarSinopsis() {
		String sinopsis ="Sinopsis de película de terror: \n" + 
	"Título: " + this.titulo + "\n" + "Duración: " + this.duracion + 
	" minutos \n" + "Edad mínima: " + this.edadMinima + " años \n" + "Estas películas se destacan por brindar grandes sustos y mucho suspenso";
		return sinopsis;

	}

}
