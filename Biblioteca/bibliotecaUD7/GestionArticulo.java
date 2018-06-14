package bibliotecaUD7;

import java.io.*;
import java.sql.*;

public class GestionArticulo {
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	Connection conn;
	
	public void menu(Connection conn) throws IOException{
		this.conn=conn;
		int opcion=0;
		do {
			System.out.println("1. Nuevo libro");
			System.out.println("2. Modificar libro");
			System.out.println("3. Borrar libro");
			System.out.println("4. Listar libro");
			System.out.println("0. Salir");
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
				nuevoLibro();
				break;
			case 2:
				modificarLibro();
				break;
			case 3:
				borrarLibro();
				break;
			case 4:
				listarLibro();
				break;
			case 0:
				break;
			default:
				System.out.println("Debes elegir una opción entre 0 y 4.");
				break;
			}
		} while (opcion!=0);
}

	private void nuevoLibro() throws IOException {
		System.out.println("Introduce el codigo del libro a instertar");
		boolean seguir=true;
		int codigo=0;
		do{
			try {
				codigo=Integer.parseInt(teclado.readLine());
				seguir=false;
			} catch (NumberFormatException e){
				System.out.println("Debe introducir un numero");
			}
		}while(seguir);
		Articulo a=new Articulo();
		a.pedirArticulo(codigo);
		String sql="insert into articulo values("+a.getCodigo()+",'"+a.getTitulo()+"',"+a.getAutor()+"',"+a.getPaginas()+")";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if (num_filas==1) {
				System.out.println("articulo creado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void listarLibro() {
		
		try {
			Articulo a =new Articulo();
			String sql="select * from articulo";
			Statement stmt = conn.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			while(rset.next()){
				a.setCodigo(rset.getInt("codarticulo"));
				a.setTitulo(rset.getString("titulo"));
				a.setAutor(rset.getString("autor"));
				a.setPaginas(rset.getInt("numpaginas"));
				System.out.println(a);
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
		
	}

	private void borrarLibro() throws IOException {
		System.out.println("Introduce el codigo del libro a borrar");
		boolean seguir=true;
		int codigo=0;
		do{
			try {
				codigo=Integer.parseInt(teclado.readLine());
				seguir=false;
			} catch (NumberFormatException e){
				System.out.println("Debe introducir un numero");
			}
		}while(seguir);
		String sql="delete from articulo where codigoarticulo="+codigo;
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("articulo borrado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void modificarLibro() throws IOException {
		System.out.println("Introduce el codigo del libro a modificar");
		boolean seguir=true;
		int codigo=0;
		do{
			try {
				codigo=Integer.parseInt(teclado.readLine());
				seguir=false;
			} catch (NumberFormatException e){
				System.out.println("Debe introducir un numero");
			}
		}while(seguir);
		Articulo a =new Articulo();
		a.pedirArticulo(codigo);
		String sql="update articulo set titulo='"+a.getTitulo()+"',autor='"+a.getAutor()+"' numpaginas="+a.getPaginas()+" where codigoarticulo="+codigo;
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("articulo modificado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}	
	}
}
