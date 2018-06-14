package bibliotecaUD7;

import java.io.*;
import java.sql.*;

public class GestionRevista {
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private Connection conn;
	
	public void menu(Connection conn) throws IOException{
		this.conn=conn;
		int opcion=0;
		do {
			System.out.println("1. Nuevo Revista");
			System.out.println("2. Modificar Revista");
			System.out.println("3. Borrar Revista");
			System.out.println("4. Listar Revista");
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
				nuevoRevista();
				break;
			case 2:
				modificarRevista();
				break;
			case 3:
				borrarRevista();
				break;
			case 4:
				listarRevista();
				break;
			case 0:
				break;
			default:
				System.out.println("Debes elegir una opción entre 0 y 4.");
				break;
			}
		} while (opcion!=0);
}

	private void nuevoRevista() throws IOException {
		System.out.println("Introduce el codigo de la revista a instertar");
		String codigo=teclado.readLine();
		Revista r=new Revista();
		r.pedirRevista(codigo);
		String sql="insert into articulo values('"+r.getCodigo()+"','"+r.getSignatura()+"',"+r.getNombre()+"','"+r.getMateria()+"')";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if (num_filas==1) {
				System.out.println("revista creada correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void listarRevista() {
		
		try {
			Revista r=new Revista();
			String sql="select * from revista";
			Statement stmt = conn.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			while(rset.next()){
				r.setCodigo(rset.getString("codrevista"));
				r.setSignatura(rset.getString("signatura"));
				r.setNombre(rset.getString("nombre"));
				r.setMateria(rset.getString("materia"));
				System.out.println(r);
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
		
	}

	private void borrarRevista() throws IOException {
		System.out.println("Introduce el codigo de la revista a borrar");
		String codigo=teclado.readLine();

		String sql="delete from revista where codrevista='"+codigo+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("revista borrada correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void modificarRevista() throws IOException {
		System.out.println("Introduce el codigo de la revista a modificar");
		String codigo=teclado.readLine();

		Revista r=new Revista();
		r.pedirRevista(codigo);
		String sql="update revista set signatura='"+r.getSignatura()+"',nombre='"+r.getNombre()+"' materia='"+r.getMateria()+"' where codrevista='"+codigo+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("revista modificada correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}	
	}
}
