package bibliotecaUD6;

import java.io.IOException;


public class Biblioteca {
	GestionLibros gl=new GestionLibros();
	GestionArticulos ga=new GestionArticulos();
	GestionCdrom gc=new GestionCdrom();
	GestionUsuario gu=new GestionUsuario();
 
	public void menu() {
		try{
			int opcion=0;
			do{
				System.out.println("_____________________________");
				System.out.println("1. Gestión de Libros");
				System.out.println("2. Gestión de articulos");
				System.out.println("3. Gestión de Revistas");
				System.out.println("4. Gestión de CD-Roms");
				System.out.println("5. Gestión de Usuarios");
				System.out.println("6. Realizar Prestamo");
				System.out.println("7. Devolver Prestamo");
				System.out.println("8. Mostrar Prestamos activos");
				System.out.println("9. Mostrar Prestamos devueltos");
				System.out.println("0. Salir");
				System.out.println("_____________________________");
				opcion=PedirDatos.leerEntero("Elija una opción");
				
				switch (opcion) {
				case 1:
					gl.menu();
					break;
				case 2:
					ga.menu();
					break;
				case 3:
					break;
				case 4:
					gc.menu();
					break;
				case 5:
					gu.menu();
					break;
				case 6:
					nuevoPrestamo();
					break;
				case 7:
					devolverPrestamo();
					break;
				case 8:
					mostrarPrestamos(true);
					break;
				case 9:
					mostrarPrestamos(false);
					break;
				case 0:
					System.out.println("Adios!!!");
					break;
				default:
					System.out.println("Debe introducir un numero entre 0 y 4");
					break;
				}
			}while(opcion!=0);
		}catch (IOException e) {
			System.out.println("Error de I/O");
		}
	}

	private void mostrarPrestamos(boolean b) {
		// TODO Apéndice de método generado automáticamente
		
	}

	private void devolverPrestamo() {
		// TODO Apéndice de método generado automáticamente
		
	}

	private void nuevoPrestamo() {
		// TODO Apéndice de método generado automáticamente
		
	}
}
