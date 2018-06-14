package bibliotecaUD6;

import java.io.*;

public class GestionCdrom {
	private File fcd=new File("cdroms.txt");
	private File ftemp=new File("temporal.txt");
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public void menu() throws IOException{
		int opcion = 0;
		do {		
			System.out.println("1. Añadir CDROM.");
			System.out.println("2. Listar CDROM.");
			System.out.println("3. Modificar CDROM.");
			System.out.println("4. Eliminar CDROM.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerEntero("Introduzca una opción.");
		
			switch (opcion) {
			case 1:
				addCdrom();
				break;
			case 2:
				listarCdroms();
				break;
			case 3:
				modificarCdroms();
				break;
			case 4:
				borrarCdroms();
				break;
			case 0:
				
				break;
			default:
				System.out.println("Debe introducir un número del 0 al 4.");
				break;
			}
		} while (opcion!=0);
	}
	
	private void addCdrom() throws IOException {
		
		System.out.println("Introduce el codigo del Cdrom");
		String codigo=teclado.readLine();
		Cdrom c =new Cdrom();
		c.pedirCdrom(codigo);
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fcd));
		}catch (FileNotFoundException e) {
			BufferedWriter brw=new BufferedWriter(new FileWriter(fcd));
			brw.close();
			br=new BufferedReader(new FileReader(fcd));
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		String linea=br.readLine();
		while (linea!=null) {
			bw.write(linea);
			bw.newLine();
			linea=br.readLine();		
		}
		
		linea=c.crearLinea();
		bw.write(linea);
		bw.flush();
		bw.close();
		br.close();
		fcd.delete();
		ftemp.renameTo(fcd);
	}
	
	private void listarCdroms() throws IOException {

		try{
			BufferedReader br=new BufferedReader(new FileReader(fcd));
			Cdrom c=new Cdrom();
			String linea=br.readLine();
			while(linea!=null){
				c.descomponerLinea(linea);
				System.out.println(c);
				linea=br.readLine();
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("Error, no existen Cdroms");
		}
	}
	
	private void modificarCdroms() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el codigo del cdrom a modificar");
		String codigo=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fcd));
		}catch (FileNotFoundException e) {
			System.out.println("El Cdrom no existe");
			return;
		}
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		Cdrom c=new Cdrom();
		String linea=br.readLine();
		while(linea!=null){
			c.descomponerLinea(linea);
			if(codigo.equals(c.getCodigo())){
			c.pedirCdrom(codigo);
				linea=c.crearLinea();
				existe=true;
			}
			bw.write(linea);
			bw.newLine();;
			linea=br.readLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
		fcd.delete();
		ftemp.renameTo(fcd);
		if(existe){
			System.out.println("Cdrom modificado correctamente");
		}else{
			System.out.println("No se ha modificado el Cdrom porque no existe");
		}
	}
	
	private void borrarCdroms() throws IOException {
		
		boolean existe=false;
		System.out.println("Introduzca el codigo del cdrom a eliminar");
		String codigo=teclado.readLine();
		
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fcd));
		}catch (FileNotFoundException e) {
			System.out.println("No existe el Cdrom ");
			return;
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		String linea=br.readLine();
		Cdrom c=new Cdrom();
		while(linea!=null){
			c.descomponerLinea(linea);
			if(!codigo.equals(c.getCodigo())){
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
		fcd.delete();
		ftemp.renameTo(fcd);
		if(existe){
			System.out.println("Cdrom borrado correctamente");
		}else{
			System.out.println("No se ha borrado el Cdrom porque no existe");
		}	
	}
}
