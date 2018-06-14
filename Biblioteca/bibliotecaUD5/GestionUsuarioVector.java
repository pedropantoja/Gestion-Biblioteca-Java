package bibliotecaUD5;

import java.util.Vector;

public class GestionUsuarioVector {
	private Vector<Usuario> Usuarios=new Vector<Usuario>();

	public void menu(){
		int opcion=0;
		do {
			System.out.println("1.Añadir Usuario");
			System.out.println("2.Listar Usuario");
			System.out.println("3.Modificar Usuario");
			System.out.println("4.Eliminar Usuario");
			System.out.println("0.Volver al menu");
			opcion=PedirDatos.leerEntero("Elija una opcion");
			switch (opcion) {
			case 1:
				addUsuario();				
				break;
			case 2:
				listarUsuario();				
				break;
			case 3:
				modUsuario();	
				break;
			case 4:	
				delUsuario();
				
				break;
			case 0:
				break;
			default:
				System.out.println("debe introducir una opcion 0-4");
				break;
			}
		} while (opcion!=0);
	}
	
	private int buscarUsuario(String codigo){
		for (int i = 0; i < Usuarios.size(); i++) {
			if (Usuarios.elementAt(i).equals(codigo)) {
				return i;
			}
		}
		return -1;
	}
	
	private void addUsuario() {
		String codigo=PedirDatos.leerCadena("Introduzca un codigo de usuario");
		if (buscarUsuario(codigo)!=-1) {
			System.out.println("Error el codigo "+codigo+" ya existe");
			return;
		}
		Usuario u=new Usuario();
		u.pedirUsuario(codigo);
		Usuarios.add(u);
	}

	private void listarUsuario() {
		for (int i = 0; i < Usuarios.size(); i++) {
			System.out.println(Usuarios.elementAt(i));
		}	
	}
	
	private void modUsuario() {
		String codigo=PedirDatos.leerCadena("Introduzca el codigo del usuario a modificar");
		int pos=buscarUsuario(codigo);
		if (pos==-1) {
			System.out.println("Error el codigo "+codigo+" no existe");
			return;
		}
		Usuario u=new Usuario();
		u.pedirUsuario(codigo);
		Usuarios.setElementAt(u, pos);
	}
	
	private void delUsuario() {
		String codigo=PedirDatos.leerCadena("Introduzca el codigo del usuario a borrar");
		int pos=buscarUsuario(codigo);
		if (pos==-1) {
			System.out.println("Error el codigo "+codigo+" no existe");
			return;
		}
		Usuarios.remove(pos);
	}
}
