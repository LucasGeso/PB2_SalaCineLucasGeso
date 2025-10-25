package unlam.edu.ar.pb2.candy;

public class Bebida extends Producto{
	
	private Contenedor contenedor;

	public Bebida(String nombre, Double precioBase, Contenedor contenedor, Integer stock) {
		super(nombre, stock, precioBase);
		this.contenedor = contenedor;
	}

	@Override
	protected Double calcularPrecioFinal() {
		
		Double precioFinal = 0.0;
		
		if(this.contenedor == Contenedor.VASO) {
			precioFinal = super.precioBase;
		} else if(this.contenedor == Contenedor.BOTELLA) {
			precioFinal = super.precioBase + ((super.precioBase*10)/100);
		} 
		return precioFinal;
	}
}
