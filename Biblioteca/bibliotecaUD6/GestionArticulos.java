package bibliotecaUD6;

import java.io.*;


public class GestionArticulos {
	private File fart=new File("articulos.txt");
	private File ftemp=new File("temporal.txt");
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

	public void menu() throws IOException {
		int opcion=0;
		do{
			System.out.println("_____________________________");
			System.out.println("1. Añadir articulo");
			System.out.println("2. Listar articulos");
			System.out.println("3. Modificar articulo");
			System.out.println("4. Eliminar articulo");
			System.out.println("0. Volver al menú principal");
			boolean seguir=true;
			do{
				try {
					System.out.println("Introduce una opcion");
					opcion=Integer.parseInt(teclado.readLine());
					seguir=false;
				} catch (NumberFormatException e) {
					System.out.println("Debe de introducir una numero");
				}
			}while(seguir);
			
			switch (opcion) {
			case 1:
				addArticulo();
				break;
			case 2:
				listarArticulos();
				break;
			case 3:
				modificarArticulo();
				break;
			case 4:
				eliminarArticulo();
				break;
			case 0:

				break;
			default:
				System.out.println("Debe introducir un numero entre 0 y 4");
				break;
			}
		}while(opcion!=0);
	}
	
	public boolean existeArticulo(int codigo) throws IOException{
		try{
			Articulo a=new Articulo();
			BufferedReader br=new BufferedReader(new FileReader(fart));
			String linea=br.readLine();
			while(linea!=null){
				a.descomponerLinea(linea);
					if(a.getCodigo()==codigo){
						br.close();
						return true;
					}
				linea=br.readLine();
			}
		}catch(FileNotFoundException e){
			System.out.println("Error, no existe el fichero");
		}
		return false;
	}

	private void addArticulo() throws IOException {
		
		boolean seguir=true;
		int codigo=-1;
		do{
			try{
				System.out.println("Introduce el codigo del articulo");
				codigo=Integer.parseInt(teclado.readLine());
				seguir=false;
			}catch(NumberFormatException e){
				System.out.println("Error, Debe introducir un numero");
			}
		}while(seguir);
		
		if(existeArticulo(codigo)){
			System.out.println("El articulo no existe");
			return;
		}

		Articulo a=new Articulo();
		a.pedirArticulo(codigo);
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fart));
		}catch(FileNotFoundException e){
			BufferedWriter brw=new BufferedWriter(new FileWriter(fart));
			brw.close();
			br=new BufferedReader(new FileReader(fart));
		}
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		String linea=br.readLine();
		while(linea!=null){
			bw.write(linea);
			bw.newLine();
			linea=br.readLine();
		}
		linea=a.crearLinea();
		bw.write(linea);
		bw.flush();

		bw.close();
		br.close();

		fart.delete();
		ftemp.renameTo(fart);
		
	}

	private void listarArticulos() throws IOException {

		try{
			BufferedReader br=new BufferedReader(new FileReader(fart));
			Articulo a=new Articulo();
			String linea=br.readLine();
			while(linea!=null){
				a.descomponerLinea(linea);
				System.out.println(a);
				linea=br.readLine();
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("Error, no existen articulos");
		}
	}
	
	private void modificarArticulo() throws IOException {
		boolean seguir=false;
		boolean existe=false;
		int codigo=-1;
		do{
			try{
				System.out.println("Introduce el codigo del articulo a modificar");
				codigo=Integer.parseInt(teclado.readLine());
				seguir=false;
			}catch(NumberFormatException e){
				System.out.println("Error, Debe introducir un numero");
			}
		}while(seguir);
		
		BufferedReader br;
		
		try{
			br=new BufferedReader(new FileReader(fart));
		}catch(FileNotFoundException e){
			System.out.println("Error, el articulo con codigo "+codigo+" no existe");
			return;
		}
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		Articulo a =new Articulo();
		String linea=br.readLine();
		while(linea!=null){
			a.descomponerLinea(linea);
			if(codigo==a.getCodigo()){
				a.pedirArticulo(codigo);
				linea=a.crearLinea();
				existe=true;
			}
			bw.write(linea);
			bw.newLine();
			linea=br.readLine();
		}
		bw.flush();
		bw.close();
		br.close();

		fart.delete();
		ftemp.renameTo(fart);

		if(existe){
			System.out.println("articulo "+codigo+" modificado correctamente");
		}else{
			System.out.println("No se ha modificado el articulo "+codigo+" porque no existe");
		}

	}

	private void eliminarArticulo() throws IOException {
		boolean seguir=false;
		boolean existe=false;
		int codigo=-1;
		do{
			try{
				System.out.println("Introduce el codigo del articulo a borrar");
				codigo=Integer.parseInt(teclado.readLine());
				seguir=false;
			}catch(NumberFormatException e){
				System.out.println("Error, Debe introducir un numero");
			}
		}while(seguir);

		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(fart));
		}catch (FileNotFoundException e) {
			System.out.println("El departamento "+codigo+" no existe");
			return;
		}
		BufferedWriter bw=new BufferedWriter(new FileWriter(ftemp));
		Articulo a=new Articulo();
		String linea=br.readLine();
		while(linea!=null){
			a.descomponerLinea(linea);
			if (a.getCodigo()==codigo) {
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

		fart.delete();
		ftemp.renameTo(fart);
		if(existe){
			System.out.println("articulo "+codigo+" borrado correctamente");
		}else{
			System.out.println("No se ha borrado el articulo "+codigo+" porque no existe");
		}
	}
}

