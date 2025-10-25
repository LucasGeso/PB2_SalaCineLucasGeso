package unlam.edu.ar.pb2.candy;

public class Combo extends Producto{
	
	private Snack snack;
	private Bebida bebida;
	private double descuento;

	public Combo(String nombre,Snack snack, Bebida bebida,double descuento, int stock) {
		super(nombre, stock, snack.getPrecioBase() + bebida.getPrecioBase());
		this.snack = snack;
		this.bebida = bebida;
		this.descuento = descuento;
		
	}

	@Override
	protected double calcularPrecioFinal() {
		double precioFinal =0.0;
		double precioProductos = 0.0;
		precioProductos= (super.precioBase);
		if(this.descuento!=0.0) {
			precioFinal = precioProductos *(1.0-descuento);
		} else {
			precioFinal = precioProductos;
		}
		return precioFinal;
	}

}
