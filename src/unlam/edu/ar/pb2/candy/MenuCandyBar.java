package unlam.edu.ar.pb2.candy;

public enum MenuCandyBar {
	
	INGRESAR_PRODUCTO("1 - Ingresar un nuevo producto"), RETIRAR_PRODUCTO("2 - Retirar un producto del Candy Bar"),VER_SNACKS("3 - Ver los snacks disponibles"), VER_BEBIDAS("4 - Ver las bebidas disponibles"), VER_INVENTARIO("5 - Ver el inventario completo"),SALIR("6 - Salir ");

	private String mensaje;

	MenuCandyBar(String mensaje) {
		this.mensaje= mensaje;
}

	public String toString() {
		return mensaje;
	
}
}

