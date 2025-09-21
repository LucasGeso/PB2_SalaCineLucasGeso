package unlam.edu.ar.pb2;

public class PeliculaInfantil extends Pelicula {

	public PeliculaInfantil(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	protected String mostrarSinopsis() {
		String sinopsis ="Sinopsis de películas infantiles: \n" + 
	"Título: " + this.titulo + "\n" + "Duración: " + this.duracion + 
	" minutos \n" + "Edad mínima: " + this.edadMinima + " años \n" + "Estas películas son ideales para los más chicos de la familia";
		return sinopsis;

	}

}
