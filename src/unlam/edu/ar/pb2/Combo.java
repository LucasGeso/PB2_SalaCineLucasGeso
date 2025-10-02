package unlam.edu.ar.pb2;

public class Combo extends Producto{
	
	private Snack snack;
	private Bebida bebida;
	private double descuento;

	public Combo(String nombre,Snack snack, Bebida bebida,double descuento, int stock) {
		super(nombre, stock);
		this.snack = snack;
		this.bebida = bebida;
		this.descuento = descuento;
		
	}

	@Override
	protected double calcularPrecioFinal() {
		double precioFinal =0.0;
		double precioProductos = 0.0;
		precioProductos= (this.snack.getPrecioBase()+ this.bebida.getPrecioBase());
		if(this.descuento!=0.0) {
			precioFinal = precioProductos *(1.0-descuento);
		} else {
			precioFinal = precioProductos;
		}
		return precioFinal;
	}

}
