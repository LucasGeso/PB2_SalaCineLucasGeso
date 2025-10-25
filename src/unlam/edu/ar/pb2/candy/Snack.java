package unlam.edu.ar.pb2.candy;

public class Snack extends Producto{
	
	private Tamano tamano;

	public Snack(String nombre, double precioBase, Tamano tamano, int stock) {
		super(nombre, stock, precioBase);
		this.tamano = tamano;
		this.precioBase = precioBase;
	}

	@Override
	protected double calcularPrecioFinal() {
		double precioFinal = 0.0;
		
		if(this.tamano==Tamano.PEQUENO) {
			precioFinal = super.precioBase - ((super.precioBase*15)/100);
		} else if(this.tamano==Tamano.MEDIANO) {
			precioFinal = super.precioBase;
		} else {
			precioFinal = super.precioBase + ((super.precioBase*20)/100);
		}
		return precioFinal;
	}
	
	

}
