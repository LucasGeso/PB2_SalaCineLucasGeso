package unlam.edu.ar.pb2.candy;

public class Combo extends Producto{
	
	private Snack snack;
	private Bebida bebida;
	private Double descuento;

	public Combo(String nombre,Snack snack, Bebida bebida,Double descuento, Integer stock) {
		super(nombre, stock, snack.getPrecioBase() + bebida.getPrecioBase());
		this.snack = snack;
		this.bebida = bebida;
		this.descuento = descuento;	
	}
	
	public Snack getSnack() {
		return snack;
	}

	public Bebida getBebida() {
		return bebida;
	}

	@Override
	protected Double calcularPrecioFinal() {
		Double precioFinal =0.0;
		Double precioProductos = 0.0;
		precioProductos= (super.precioBase);
		if(this.descuento!=0.0) {
			precioFinal = precioProductos *(1.0-descuento);
		} else {
			precioFinal = precioProductos;
		}
		return precioFinal;
	}
}
