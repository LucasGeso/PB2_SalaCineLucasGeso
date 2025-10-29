package unlam.edu.ar.pb2.candy;

public class ProductoNoEncontradoException extends Exception{
	
	public ProductoNoEncontradoException() {
		super("Producto no encontrado");
	}

}
