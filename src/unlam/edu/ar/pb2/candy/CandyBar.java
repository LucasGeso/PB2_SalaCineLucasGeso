package unlam.edu.ar.pb2.candy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class CandyBar {
	
	private TreeSet<Producto> productos;
	private Integer cantidadDeProductosMaxima;
	
	public CandyBar(Integer cantidad) {
		this.productos = new TreeSet<Producto>();
		this.cantidadDeProductosMaxima = cantidad;
	}
	
	public Boolean agregarProducto(Producto nuevo) throws ProductoDuplicadoExeption{
		Boolean respuesta = false;
		if(this.productos.size()<cantidadDeProductosMaxima){
			respuesta = this.productos.add(nuevo);
			if(!respuesta) {
				throw new ProductoDuplicadoExeption();
			}
		}
			return respuesta;
	}
	
	public Boolean eliminarProducto(String nombre) throws ProductoNoEncontradoException{
		/*return this.productos.removeIf(prod -> prod.getNombre().equalsIgnoreCase(nombre));*/
		for(Producto buscado : this.productos) {
			if(buscado.getNombre().equalsIgnoreCase(nombre)) {
				return this.productos.remove(buscado);
		} 
		}
		throw new ProductoNoEncontradoException();
	}
	

	public TreeSet<Producto> obtenerInventario() {
		return this.productos;
	}

	public ArrayList<Producto> mostrarLasBebidas(){
		ArrayList<Producto> bebidas = new ArrayList<Producto>();
		for(Producto p : this.productos) {
			if(p instanceof Bebida) {
				bebidas.add(p);
			}
		}
		Collections.sort(bebidas, new OrdenarPorPrecioBase());
		
		return bebidas;
	}
	
	public ArrayList<Producto> mostrarLosSnacks(){
		ArrayList<Producto> snacks = new ArrayList<Producto>();
		for(Producto p : this.productos) {
			if(p instanceof Snack) {
				snacks.add(p);
			}
		}
		Collections.sort(snacks, new OrdenarPorNombre());
		return snacks;
	}

}

/*Boolean resultado = false;
for(Producto lista : this.productos){
	if(lista.getNombre().equalsIgnoreCase(nombre)) {
		resultado = this.productos.remove(lista);
	} 
}
for(int i=0; i<this.productos.length; i++) {
	if(this.productos[i]!=null && this.productos[i].getNombre().equalsIgnoreCase(nombre)) {
		this.productos[i]=null;
		return true;
	}
}
return false;
return resultado;*/
