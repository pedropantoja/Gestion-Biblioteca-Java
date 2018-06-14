package bibliotecaUD5;

import java.util.Vector;

public class GestionLibros {
	
	private Vector<Libro> libros=new Vector<Libro>();
	
	public void menu(){
		int opcion=0;
		
		do {
			System.out.println("1.Añadir libro");
			System.out.println("2.Listar libros");
			System.out.println("3.Modificar libro");
			System.out.println("4.Eliminar libro");
			System.out.println("0.Volver al menu");
			opcion=PedirDatos.leerEntero("Elija una opcion");
			switch (opcion) {
			case 1:
				addLibro();			
				break;
			case 2:
				listarLibros();				
				break;
			case 3:
				modificarLibro();				
				break;
			case 4:	
				eliminarLibro();		
				break;
			case 0:
				break;

			default:
				System.out.println("debe introducir una opcion (0-4)");
				break;
			}
		} while (opcion!=0);
	}

	public int buscarLibro(String ISBN){
		for (int i = 0; i < libros.size(); i++) {
			if(libros.elementAt(i).getISBN().equals(ISBN)){
				return i;
			}
		}	
		return -1;
	}
	
	public String buscarTituloLibro(String ISBN){
		int pos=buscarLibro(ISBN);
		Libro l=libros.elementAt(pos);
		return l.getTitulo();
	}
	
	private void addLibro() {
		String ISBN=PedirDatos.leerCadena("Dime el ISBN del libro a añadir");
		if(buscarLibro(ISBN)!=-1){
			System.out.println("EL libro con ISBN "+ISBN+" ya existe");
			return;
		}	
		Libro l=new Libro();
		l.pedirLibro(ISBN);
		
		libros.addElement(l);	
	}

	private void listarLibros() {
		for (int i = 0; i < libros.size(); i++) {
			System.out.println(libros.elementAt(i));
		}		
	}

	private void modificarLibro() {
		String ISBN=PedirDatos.leerCadena("Dame el ISBN del libro a eliminar");
		int pos=buscarLibro(ISBN);
		if(pos==-1){
			System.out.println("El libro con ISBN "+ISBN+" no existe");
			return;
		}		
		Libro l=new Libro();
		l.pedirLibro(ISBN);
		libros.setElementAt(l, pos);
	}

	private void eliminarLibro() {
		String ISBN=PedirDatos.leerCadena("Dame el ISBN del libro a eliminar");
		int pos=buscarLibro(ISBN);
		if(pos==-1){
			System.out.println("El libro con ISBN "+ISBN+" no existe");
			return;
		}
		libros.remove(pos);	
	}
}
