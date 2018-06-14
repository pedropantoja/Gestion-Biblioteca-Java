package bibliotecaUD6;

import java.io.*;

public class GestionLibros {
	private File flibros=new File("libros.txt");
	private File ftemp=new File("temporal.txt");
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public void menu() throws IOException{
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
				nuevoLibro();
				
				break;
			case 2:
				listarLibros();
				
				break;
			case 3:
				modificarlibro();
				
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
	
	private void nuevoLibro() throws IOException {
		
		System.out.println("Introduce el ISBN del usuario");
		String ISBN=teclado.readLine();
		Libro l=new Libro();
		l.pedirLibro(ISBN);
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(flibros));
		}catch (FileNotFoundException e) {
			BufferedWriter brw=new BufferedWriter(new FileWriter(flibros));
			brw.close();
			br=new BufferedReader(new FileReader(flibros));
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		String linea=br.readLine();
		while (linea!=null) {
			bw.write(linea);
			bw.newLine();
			linea=br.readLine();		
		}
		
		linea=l.crearLinea();
		bw.write(linea);
		bw.flush();
		bw.close();
		br.close();
		flibros.delete();
		ftemp.renameTo(flibros);	
	}
	
	private void listarLibros() throws IOException {

		try{
			BufferedReader br=new BufferedReader(new FileReader(flibros));
			Libro l=new Libro();
			String linea=br.readLine();
			while(linea!=null){
				l.descomponerLinea(linea);
				System.out.println(l);
				linea=br.readLine();
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("Error, no existen articulos");
		}
	}
	
	private void modificarlibro() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el ISBN del libro a modificar");
		String ISBN=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(flibros));
		}catch (FileNotFoundException e) {
			System.out.println("El Libro no existe");
			return;
		}
		BufferedWriter bw=new BufferedWriter(new FileWriter(flibros));
		Libro l =new Libro();
		String linea=br.readLine();
		while(linea!=null){
			l.descomponerLinea(linea);
			if(ISBN.equals(l.getISBN())){
			l.pedirLibro(ISBN);
				linea=l.crearLinea();
				existe=true;
			}
			bw.write(linea);
			bw.newLine();;
			linea=br.readLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
		flibros.delete();
		ftemp.renameTo(flibros);
		if(existe){
			System.out.println("Libro modificado correctamente");
		}else{
			System.out.println("No se ha modificado el Libro porque no existe");
		}
	}

	private void eliminarLibro() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el ISBN del libro a eliminar");
		String ISBN=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(flibros));
		}catch (FileNotFoundException e) {
			System.out.println("No existe el libro ");
			return;
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		String linea=br.readLine();
		Libro l =new Libro();
		while(linea!=null){
			l.descomponerLinea(linea);
			if(!ISBN.equals(l.getISBN())){
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
		flibros.delete();
		ftemp.renameTo(flibros);
		if(existe){
			System.out.println("Libro borrado correctamente");
		}else{
			System.out.println("No se ha borrado el libro porque no existe");
		}
	}
}
