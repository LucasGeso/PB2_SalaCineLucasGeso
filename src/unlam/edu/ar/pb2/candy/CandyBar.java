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

