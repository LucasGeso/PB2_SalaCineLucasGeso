package unlam.edu.ar.pb2.candy;

import java.util.Objects;

public abstract class Producto {
	
	protected String nombre;
	protected int stock;
	
	public Producto(String nombre, int stock) {
		this.nombre = nombre;
		this.stock = stock;
	}
	
	protected abstract double calcularPrecioFinal();

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}
}
