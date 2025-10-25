package unlam.edu.ar.pb2.candy;

public class CandyBar {
	
	private Producto[] productos;
	
	public CandyBar(int cantidad) {
		this.productos = new Producto[cantidad];
	}
	
	public boolean agregarProducto(Producto nuevo) {
		for(int i=0; i<this.productos.length; i++) {
			if(this.productos[i]==null) {
				this.productos[i]=nuevo;
				return true;
			}
		}
		return false;
	}

	public Producto[] obtenerInventario() {
		return this.productos;
	}

	public boolean eliminarProducto(String nombre) {
		for(int i=0; i<this.productos.length; i++) {
			if(this.productos[i]!=null && this.productos[i].getNombre().equalsIgnoreCase(nombre)) {
				this.productos[i]=null;
				return true;
			}
		}
		return false;
	}

}
