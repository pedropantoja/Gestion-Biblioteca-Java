package bibliotecaUD7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionLibro {
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private Connection conn;
	
	public void menu(Connection conn) throws IOException{
		this.conn=conn;
		int opcion=0;
		do {
			System.out.println("1. Nuevo Libro");
			System.out.println("2. Modificar Libro");
			System.out.println("3. Borrar Libro");
			System.out.println("4. Listar Libro");
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
		System.out.println("Introduce el ISBN del libro a instertar");
		String ISBN=teclado.readLine();
		Libro l =new Libro();
		l.pedirLibro(ISBN);
		String sql="insert into libro values("+l.getISBN()+",'"+l.getSignatura()+"','"+l.getTitulo()+"','"+l.getAutor()+
				"','"+l.getMateria()+"','"+l.getEditorial()+"')";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if (num_filas==1) {
				System.out.println("libro creada correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void listarLibro() {
		
		try {
			Libro l =new Libro();
			String sql="select * from libro";
			Statement stmt = conn.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			while(rset.next()){
				l.setISBN(rset.getString("ISBN"));
				l.setSignatura(rset.getString("signatura"));
				l.setTitulo(rset.getString("titulo"));
				l.setAutor(rset.getString("autor"));
				l.setMateria(rset.getString("materia"));
				l.setEditorial(rset.getString("editorial"));
				System.out.println(l);
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
		
	}

	private void borrarLibro() throws IOException {
		System.out.println("Introduce el ISBN del libro a borrar");
		String ISBN=teclado.readLine();

		String sql="delete from libro where ISBN='"+ISBN+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("libro borrado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void modificarLibro() throws IOException {
		System.out.println("Introduce el ISBN del libro a modificar");
		String ISBN=teclado.readLine();
		Libro l =new Libro();
		l.pedirLibro(ISBN);
		String sql="update revista set signatura='"+l.getSignatura()+"',titulo='"+l.getTitulo()+"', autor='"+l.getAutor()+
				"' materia='"+l.getMateria()+"', editorial='"+l.getEditorial()+" where ISBN='"+ISBN+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("libro modificado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}	
	}
}
