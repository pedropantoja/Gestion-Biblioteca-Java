package bibliotecaUD7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionCdrom {
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private Connection conn;
	
	public void menu(Connection conn) throws IOException{
		this.conn=conn;
		int opcion=0;
		do {
			System.out.println("1. Nuevo Cdrom");
			System.out.println("2. Modificar Cdrom ");
			System.out.println("3. Borrar Cdrom");
			System.out.println("4. Listar Cdrom");
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
				nuevoCdrom();
				break;
			case 2:
				modificarCdrom();
				break;
			case 3:
				borrarCdrom();
				break;
			case 4:
				listarCdrom();
				break;
			case 0:
				break;
			default:
				System.out.println("Debes elegir una opción entre 0 y 4.");
				break;
			}
		} while (opcion!=0);
}

	private void nuevoCdrom() throws IOException {
		System.out.println("Introduce el codigo del cdrom a instertar");
		String codigo=teclado.readLine();
		Cdrom cd=new Cdrom();
		cd.pedirCdrom(codigo);
		String sql="insert into cdrom values("+cd.getCodigo()+",'"+cd.getSignatura()+"',"+cd.getTitulo()+"','"+cd.getAutor()+"'"+cd.getMateria()+
				"','"+cd.getEditorial()+"'')";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if (num_filas==1) {
				System.out.println("cdrom creado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void listarCdrom() {
		
		try {
			Cdrom cd=new Cdrom();
			String sql="select * from cdrom";
			Statement stmt = conn.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			while(rset.next()){
				cd.setCodigo(rset.getString("codrevista"));
				cd.setSignatura(rset.getString("signatura"));
				cd.setTitulo(rset.getString("titulo"));
				cd.setAutor(rset.getString("autor"));
				cd.setMateria(rset.getString("materia"));
				cd.setEditorial(rset.getString("editorial"));
				System.out.println(cd);
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
		
	}

	private void borrarCdrom() throws IOException {
		System.out.println("Introduce el codigo del cdrom a borrar");
		String codigo=teclado.readLine();
		String sql="delete from cdrom where codcdrom='"+codigo+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("cdrom borrado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}
	}

	private void modificarCdrom() throws IOException {
		System.out.println("Introduce el codigo del cdrom a modificar");
		String codigo=teclado.readLine();

		Cdrom cd=new Cdrom();
		cd.pedirCdrom(codigo);
		String sql="update cdrom set signatura='"+cd.getSignatura()+"',titulo='"+cd.getTitulo()+"', autor='"+cd.getAutor()+
				"',materia='"+cd.getMateria()+"',editorial='"+cd.getEditorial()+"' where codcdrom='"+codigo+"'";
		try {
			Statement stmt=conn.createStatement();
			int num_filas=stmt.executeUpdate(sql);
			if(num_filas>0){
				System.out.println("cdrom modificado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BD");
			System.out.println(e.getMessage());
		}	
	}
}
