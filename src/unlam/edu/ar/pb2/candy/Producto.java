package unlam.edu.ar.pb2.candy;

public abstract class Producto implements Comparable<Producto>{
	
	protected String nombre;
	protected Integer stock;
	protected Double precioBase;
	
	public Producto(String nombre, Integer stock, Double precioBase) {
		this.nombre = nombre;
		this.stock = stock;
		this.precioBase = precioBase;
	}
	
	protected abstract Double calcularPrecioFinal();

	public String getNombre() {
		return nombre;
	}

	public Double getPrecioBase() {
		return precioBase;
	}
	
	public Integer getStock() {
		return stock;
	}

	@Override
	public int compareTo(Producto o) {
		int comparacionStock =  this.stock.compareTo(o.stock);
		if(comparacionStock ==0) {
			return this.nombre.compareToIgnoreCase(o.nombre);
		}
		return comparacionStock;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Stock:" + stock + " Precio $" + calcularPrecioFinal();
	}
	
	
	
}
