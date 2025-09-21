package unlam.edu.ar.pb2;

import java.util.Objects;

public class Asiento {
	private String nombreComprador;
	private boolean ocupado;
		
	public Asiento() {
		this.liberar();
	}
	
	public Asiento(String nombreComprador, boolean estado) {
		this.nombreComprador = nombreComprador;
		this.ocupado = estado;
	}
	
	public String getNombreComprador() {
		return nombreComprador;
	}
	
	public void ocupar(String nombreComprador) {
		this.nombreComprador = nombreComprador;
		this.ocupado = true;
	}
	
	public void liberar() {
		this.nombreComprador = "";
		this.ocupado = false;
	}
	
	public boolean estaOcupado() {
		return ocupado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreComprador, ocupado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asiento other = (Asiento) obj;
		return Objects.equals(nombreComprador, other.nombreComprador) && ocupado == other.ocupado;
	}
	
	
}
