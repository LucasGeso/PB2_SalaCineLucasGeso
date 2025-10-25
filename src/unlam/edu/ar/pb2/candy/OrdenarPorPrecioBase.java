package unlam.edu.ar.pb2.candy;

import java.util.Comparator;

public class OrdenarPorPrecioBase implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		return o1.getPrecioBase().compareTo(o2.getPrecioBase());
	}

}
