package bibliotecaUD7;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Biblioteca {
	GestionLibro gl=new GestionLibro();
	GestionArticulo ga=new GestionArticulo();
	GestionCdrom gc=new GestionCdrom();
	GestionUsuario gu=new GestionUsuario();
	GestionRevista gr=new GestionRevista();
	
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private Connection conn;
	
	public Connection conectar(){
		Connection conn=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");
		}catch (ClassNotFoundException e) {
			System.out.println("No encontramos el Driver para conectar con la BD");
		} catch (SQLException e) {
			System.out.println("No se encuentra la BD o el usuario y contraseña son incorrectos");
		}
		return conn;
	}
	
	public void desconectar(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("error al desconectar de la BD");;
		}
	}
	
	public void menu() {
		this.conn=conectar();
		if(conn==null){
			return;
		}
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
				System.out.println("Introduce una opcion");
				boolean seguir=true;
				do{
					try {
						opcion=Integer.parseInt(teclado.readLine());
						seguir=false;
					} catch (NumberFormatException e){
						System.out.println("Debe introducir un numero");
					}
				}while(seguir);
				
				switch (opcion) {
				case 1:
					gl.menu(conn);
					break;
				case 2:
					ga.menu(conn);
					break;
				case 3:
					gr.menu(conn);
					break;
				case 4:
					gc.menu(conn);
					break;
				case 5:
					gu.menu(conn);
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
					desconectar(conn);
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
