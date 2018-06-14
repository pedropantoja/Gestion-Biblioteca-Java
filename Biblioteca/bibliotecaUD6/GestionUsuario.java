package bibliotecaUD6;

import java.io.*;

public class GestionUsuario {
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private File fusuarios=new File("usuarios.txt");
	private File ftemporal=new File("temporal.txt");
	
	
	public void menu() throws IOException{
		int opcion=0;
		do {
			System.out.println("1. Nuevo usuario");
			System.out.println("2. Modificar usuario");
			System.out.println("3. Borrar usuario");
			System.out.println("4. Listar usuarios");
			System.out.println("0. Salir");
			opcion=PedirDatos.leerEntero("Elija una opción");
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

	private void nuevoUsuario() throws IOException {
		
		System.out.println("Introduce el codigo del usuario");
		String codigo=teclado.readLine();
		Usuario u=new Usuario();
		u.pedirUsuario(codigo);
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fusuarios));
		}catch (FileNotFoundException e) {
			BufferedWriter brw=new BufferedWriter(new FileWriter(fusuarios));
			brw.close();
			br=new BufferedReader(new FileReader(fusuarios));
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemporal));
		String linea=br.readLine();
		while (linea!=null) {
			bw.write(linea);
			bw.newLine();
			linea=br.readLine();		
		}
		
		linea=u.crearLinea();
		bw.write(linea);
		bw.flush();
		bw.close();
		br.close();
		fusuarios.delete();
		ftemporal.renameTo(fusuarios);
		
	}

	private void modificarUsuario() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el codigo del usuario a modificar");
		String codigo=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fusuarios));
		}catch (FileNotFoundException e) {
			System.out.println("El usuario no existe");
			return;
		}
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemporal));
		Usuario u =new Usuario();
		String linea=br.readLine();
		while(linea!=null){
			u.descomponerLinea(linea);
			if(codigo.equals(u.getCodigo())){
			u.pedirUsuario(codigo);
				linea=u.crearLinea();
				existe=true;
			}
			bw.write(linea);
			bw.newLine();;
			linea=br.readLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
		fusuarios.delete();
		ftemporal.renameTo(fusuarios);
		if(existe){
			System.out.println("Usuario modificado correctamente");
		}else{
			System.out.println("No se ha modificado el usuario porque no existe");
		}
	}

	private void borrarUsuario() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el codigo del usuario a eliminar");
		String codigo=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fusuarios));
		}catch (FileNotFoundException e) {
			System.out.println("No existe el usuario ");
			return;
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemporal));
		String linea=br.readLine();
		Usuario u=new Usuario();
		while(linea!=null){
			u.descomponerLinea(linea);
			if(!codigo.equals(u.getCodigo())){
				bw.write(linea);
				bw.newLine();
			}else{
				existe=true;
			}
			linea=br.readLine();
		}
		bw.flush();
		bw.close();
		br.close();
		fusuarios.delete();
		ftemporal.renameTo(fusuarios);
		if(existe){
			System.out.println("usuario borrado correctamente");
		}else{
			System.out.println("No se ha borrado el usuario porque no existe");
		}
		
	}

	private void listarUsuarios() throws IOException {
		try {
			Usuario u=new Usuario();
			BufferedReader br=new BufferedReader(new FileReader(fusuarios));
			String linea=br.readLine();
			while(linea!=null){
				u.descomponerLinea(linea);
				System.out.println(u);
				linea=br.readLine();
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No existe ningún usuario");
		}
	}	
}

