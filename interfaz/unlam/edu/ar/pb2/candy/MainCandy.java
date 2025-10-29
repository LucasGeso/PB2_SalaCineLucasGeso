package unlam.edu.ar.pb2.candy;

import java.util.ArrayList;
import java.util.Scanner;

public class MainCandy {
	
	
	public static void main(String[] args) {
		CandyBar candy = new CandyBar(10);
		
		Scanner teclado = new Scanner(System.in);
		MenuCandyBar menu[] = MenuCandyBar.values();
		MenuCandyBar opcionElegida;
		
		System.out.println("Bienvenido: ");
		do {
		System.out.println(" ");
		mostrarMenu();
		System.out.println("Seleccione una de las opciones disponibles: ");
		int opcion = teclado.nextInt();
		opcionElegida = menu[opcion-1];
		
		switch(opcionElegida) {
			case INGRESAR_PRODUCTO:
				agregarProducto(candy, teclado);
				break;
			case RETIRAR_PRODUCTO:
				eliminarProducto(candy, teclado);
				break;
			case VER_SNACKS:
				verSnacks(candy, teclado);
				break;
			case VER_BEBIDAS:
				verBebidas(candy, teclado);
				break;
			case VER_INVENTARIO:
				verInvetarioCompleto(candy, teclado);
			case SALIR:
				break;
		}
		
		}while(opcionElegida!=MenuCandyBar.SALIR);
		
		System.out.println("Muchas graicas, hasta luego!!!");
		
		}

	private static void verInvetarioCompleto(CandyBar candy, Scanner teclado) {
		for(Producto p : candy.obtenerInventario()) {
			System.out.println(p);
		}
	}

	private static void verBebidas(CandyBar candy, Scanner teclado) {
		ArrayList<Producto> bebidasBuscadas = new ArrayList<Producto>();
		bebidasBuscadas = candy.mostrarLasBebidas();
		for(Producto buscado : bebidasBuscadas) {
			System.out.println(buscado);
		}
	}

	private static void verSnacks(CandyBar candy, Scanner teclado) {
		ArrayList<Producto> snacksBuscados = new ArrayList<Producto>();
		snacksBuscados = candy.mostrarLosSnacks();
		for(Producto buscado : snacksBuscados) {
			System.out.println(buscado);
		}
	}

	private static void eliminarProducto(CandyBar candy, Scanner teclado) {
		System.out.println("Ingrese el nombre del producto que desea eliminar: ");
		String nombre = teclado.next();
		try {
			candy.eliminarProducto(nombre);
			System.out.println("El producto " + nombre + " se eliminó correctamente");
		} catch(ProductoNoEncontradoException e ) {
			System.out.println(e.getMessage());
		}
	}

	private static void agregarProducto(CandyBar candy, Scanner teclado) {
		System.out.println("Que producto desea agregar ?");
		System.out.println("1 - Snack");
		System.out.println("2 - Bebida");
		int opcion = teclado.nextInt();
		do {
		if(opcion == 1) {
			try {
				candy.agregarProducto(crearSnack(teclado));
				System.out.println("Se agrego correctamente");
			} catch (ProductoDuplicadoExeption e) {
				System.out.println(e.getMessage());
			}
			
		} else if(opcion==2) {
			try {
				candy.agregarProducto(crearBebida(teclado));
				System.out.println("Se agrego correctamente");
			} catch (ProductoDuplicadoExeption e) {
				System.out.println(e.getMessage());
			} 
			} else {
				System.out.println("Opción incorrecta");

		}
		}while(opcion<1 || opcion>2);
		
	}

	private static Producto crearSnack(Scanner teclado) {
		System.out.println("Ingrese el nombre del Snack: ");
		String nombre = teclado.next();
		System.out.println("Ingrese su precio unitario: ");
		Double precio = teclado.nextDouble();
		int opcionTamano;
		Tamano tamanoSnack = null;
		do {
			System.out.println("Elija el tamaño: ");
			System.out.println("1 - Pequeño");
			System.out.println("2 - Mediano");
			System.out.println("3 - Grande");
			opcionTamano = teclado.nextInt();
			if(opcionTamano == 1 ) {
				tamanoSnack = Tamano.PEQUENO;
			} else if(opcionTamano == 2) {
				tamanoSnack = Tamano.MEDIANO;
			} else if(opcionTamano == 3){
				tamanoSnack = Tamano.GRANDE;
			} else {
				System.out.println("Opción incorrecta, vuelva a intentar: ");
			}
		}while(opcionTamano<1 || opcionTamano>3);
		
		System.out.println("Ingrese el stock: ");
		int stock = teclado.nextInt();
		Producto nuevo = new Snack(nombre, precio, tamanoSnack, stock);
		return nuevo;
	}
	
	private static Producto crearBebida(Scanner teclado) {
		System.out.println("Ingrese el nombre de la Bebida: ");
		String nombre = teclado.next();
		System.out.println("Ingrese su precio unitario: ");
		Double precio = teclado.nextDouble();
		int opcionContenedor;
		Contenedor contenedorBebida = null;
		do {
		System.out.println("Elija el contenedor: ");
		System.out.println("1 - Vaso");
		System.out.println("2 - Botella");
		opcionContenedor = teclado.nextInt();
			if(opcionContenedor == 1 ) {
				contenedorBebida = Contenedor.VASO;
			} else if(opcionContenedor == 2) {
				contenedorBebida = Contenedor.BOTELLA;
			} else {
				System.out.println("Opcion incorrecta, vuelva a intentarlo: ");
			}
		}while(opcionContenedor!=1 && opcionContenedor!=2);
		
		System.out.println("Ingrese el stock: ");
		int stock = teclado.nextInt();
		Producto nuevo = new Bebida(nombre, precio, contenedorBebida, stock);
		return nuevo;
	}

	private static void mostrarMenu() {
		
		MenuCandyBar menu[] = MenuCandyBar.values();
		
		for(int i=0; i<menu.length; i++) {
			System.out.print(menu[i] +"\n");
		}
	}


}
