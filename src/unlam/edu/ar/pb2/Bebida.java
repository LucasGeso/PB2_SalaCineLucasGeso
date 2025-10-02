package unlam.edu.ar.pb2;

public class Bebida extends Producto{
	
	private Contenedor contenedor;
	private double precioBase;

	public Bebida(String nombre, double precioBase, Contenedor contenedor, int stock) {
		super(nombre, stock);
		this.contenedor = contenedor;
		this.precioBase = precioBase;
	}

	@Override
	protected double calcularPrecioFinal() {
		
		double precioFinal = 0.0;
		
		if(this.contenedor == Contenedor.VASO) {
			precioFinal = this.precioBase;
		} else if(this.contenedor == Contenedor.BOTELLA) {
			precioFinal = this.precioBase + ((this.precioBase*10)/100);
		} 
		return precioFinal;
	}

	public double getPrecioBase() {
		return precioBase;
	}
	
	

}
