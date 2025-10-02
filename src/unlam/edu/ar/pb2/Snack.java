package unlam.edu.ar.pb2;

public class Snack extends Producto{
	
	private Tamano tamano;
	private double precioBase;

	public Snack(String nombre, double precioBase, Tamano tamano, int stock) {
		super(nombre, stock);
		this.tamano = tamano;
		this.precioBase = precioBase;
	}

	@Override
	protected double calcularPrecioFinal() {
		double precioFinal = 0.0;
		
		if(this.tamano==Tamano.PEQUENO) {
			precioFinal = this.precioBase - ((this.precioBase*15)/100);
		} else if(this.tamano==Tamano.MEDIANO) {
			precioFinal = this.precioBase;
		} else {
			precioFinal = this.precioBase + ((this.precioBase*20)/100);
		}
		return precioFinal;
	}

	public double getPrecioBase() {
		return precioBase;
	}
	
	

}
