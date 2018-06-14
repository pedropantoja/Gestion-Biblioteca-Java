package bibliotecaUD5;

import java.util.Vector;

public class GestionUsuario {

	private Vector<Usuario> usuarios=new Vector<Usuario>();

	public void menu(){
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

	private void listarUsuarios() {
		for (int i=0; i<usuarios.size(); i++) {
			System.out.println(usuarios.elementAt(i));
		}	
	}

	private void borrarUsuario() {
		String codigo=PedirDatos.leerCadena("Escriba el codigo del usuario que desea eliminar");
		int pos=buscarUsuario(codigo);
		if (pos==-1) {
			System.out.println("El usuario que desea borrar no existe.");
			return;
		}
		usuarios.remove(pos);
	}

	private void modificarUsuario() {
		String codigo=PedirDatos.leerCadena("Escriba el codigo del usuario que desee modificar");
		int pos=buscarUsuario(codigo);
		if (pos==-1) {
			System.out.println("El usuario no existe, no se puede modificar.");
			return;
		}
		Usuario u=new Usuario();
		u.pedirUsuario(codigo);
		usuarios.setElementAt(u, pos);
	}

	private void nuevoUsuario() {
		String codigo=PedirDatos.leerCadena("Escriba el código del usuario");
		if (buscarUsuario(codigo)!=-1) {
			System.out.println("El usuario ya existe, no se puede crear.");
			return;
		}
		Usuario u=new Usuario();
		u.pedirUsuario(codigo);
		usuarios.addElement(u);
	}

	public int buscarUsuario(String codigo){
		for (int i=0; i<usuarios.size(); i++) {
			if (usuarios.elementAt(i).getCodigo().equals(codigo)) {
				return i;
			}
		}
		return -1;
	}
	
	public String buscarNombreUsuario(String codigo){
		int pos=buscarUsuario(codigo);
		Usuario u=usuarios.elementAt(pos);
		return u.getNombre()+" "+u.getApellidos1()+" "+u.getApellidos2();
	}
}
