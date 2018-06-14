package bibliotecaUD7;

import java.io.*;
import java.sql.*;

public class GestionUsuario {
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	Connection conn;
	
	public void menu(Connection conn) throws IOException{
		this.conn=conn;
		int opcion=0;
		do {
			System.out.println("1. Nuevo usuario");
			System.out.println("2. Modificar usuario");
			System.out.println("3. Borrar usuario");
			System.out.println("4. Listar usuarios");
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
				nuevoUsuario();
				break;
			case 2:
				modificarUsuario();
				break;
			case 3:
				borrarUsuario();
				break;
			case 4:
				listarUsuarios();
				break;
			case 0:
				break;
			default:
				System.out.println("Debes elegir una opción entre 0 y 4.");
				break;
			}
		} while (opcion!=0);
	}

	private void nuevoUsuario() throws IOException  {
		
		try{
			System.out.println("Introduce el codigo del usuario");
			String codigo=teclado.readLine();
			Usuario u=new Usuario();
			u.pedirUsuario(codigo);
			Statement stmt=conn.createStatement();
			String sql="insert into usuario values ('"+u.getCodigo()+"','"+u.getNombre()+"','"+u.getApellidos1()+"','"+u.getApellidos2()+"')";
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas==1){
				System.out.println("usuario "+codigo+" creado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void modificarUsuario() throws IOException  {
		System.out.println("Introduce el codigo del usuario a modificar");
		String codigo=teclado.readLine();
		Usuario u=new Usuario();
		u.pedirUsuario(codigo);
		String sql="update usuario set nombre='"+u.getNombre()+"',apellido1='"+u.getApellidos1()+
				"',apellido2='"+u.getApellidos2()+"' where codusuario='"+codigo+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("Usuario modificado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void borrarUsuario() throws IOException  {
		System.out.println("Introduce el codigo del usuario a borrar");
		String codigo=teclado.readLine();
		String sql="delete from usuario where codusuario='"+codigo+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("usuario borrado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}	
	}

	private void listarUsuarios() {
		try {
			Usuario u=new Usuario();
			String sql="select * from usuario";
			Statement stmt = conn.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			while(rset.next()){
				u.setCodigo(rset.getString("codusuario"));
				u.setNombre(rset.getString("nombre"));
				u.setApellidos1(rset.getString("apellido1"));
				u.setApellidos2(rset.getString("apellido2"));
				System.out.println(u);
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}
}

