package bibliotecaUD6;

import java.io.*;

public class GestionRevista {
	private File frevista=new File("revistas.txt");
	private File ftemp=new File("temporal.txt");
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public void menu() throws IOException{
		int opcion = 0;
		do {		
			System.out.println("1. Añadir Revista.");
			System.out.println("2. Listar Revista.");
			System.out.println("3. Modificar Revista.");
			System.out.println("4. Eliminar Revista.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerEntero("Introduzca una opción.");
		
			switch (opcion) {
			case 1:
				nuevoRevista();
				break;
			case 2:
				listarRevista();
				break;
			case 3:
				modificarRevista();
				break;
			case 4:
				eliminarRevista();
				break;
			case 0:
				
				break;
			default:
				System.out.println("Debe introducir un número del 0 al 4.");
				break;
			}
		} while (opcion!=0);
	}
	
	private void modificarRevista() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el codigo de la revista a modificar");
		String codigo=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(frevista));
		}catch (FileNotFoundException e) {
			System.out.println("La revista no existe");
			return;
		}
		BufferedWriter bw=new BufferedWriter(new FileWriter(frevista));
		Revista r=new Revista();
		String linea=br.readLine();
		while(linea!=null){
			r.descomponerLinea(linea);
			if(codigo.equals(r.getCodigo())){
			r.pedirRevista(codigo);
				linea=r.crearLinea();
				existe=true;
			}
			bw.write(linea);
			bw.newLine();;
			linea=br.readLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
		frevista.delete();
		ftemp.renameTo(frevista);
		if(existe){
			System.out.println("Revista modificado correctamente");
		}else{
			System.out.println("No se ha modificado la revista porque no existe");
		}
	}

	private void eliminarRevista() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el codigo de la revista a eliminar");
		String codigo=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(frevista));
		}catch (FileNotFoundException e) {
			System.out.println("No existe la revista");
			return;
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		String linea=br.readLine();
		Revista r=new Revista();
		while(linea!=null){
			r.descomponerLinea(linea);
			if(!codigo.equals(r.getCodigo())){
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
		frevista.delete();
		ftemp.renameTo(frevista);
		if(existe){
			System.out.println("revista borrada correctamente");
		}else{
			System.out.println("No se ha borrado la revista porque no existe");
		}
	}

	private void nuevoRevista() throws IOException {
		
		System.out.println("Introduce el codigo de la revista");
		String codigo=teclado.readLine();
		Revista r =new Revista();
		r.pedirRevista(codigo);
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(frevista));
		}catch (FileNotFoundException e) {
			BufferedWriter brw=new BufferedWriter(new FileWriter(frevista));
			brw.close();
			br=new BufferedReader(new FileReader(frevista));
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(frevista));
		String linea=br.readLine();
		while (linea!=null) {
			bw.write(linea);
			bw.newLine();
			linea=br.readLine();		
		}
		
		linea=r.crearLinea();
		bw.write(linea);
		bw.flush();
		bw.close();
		br.close();
		frevista.delete();
		ftemp.renameTo(frevista);
		
	}
	
	private void listarRevista() throws IOException {

		try{
			BufferedReader br=new BufferedReader(new FileReader(frevista));
			Revista r=new Revista();
			String linea=br.readLine();
			while(linea!=null){
				r.descomponerLinea(linea);
				System.out.println(r);
				linea=br.readLine();
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("Error, no existen articulos");
		}
	}
}