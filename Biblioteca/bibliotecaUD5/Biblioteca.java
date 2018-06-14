package bibliotecaUD5;

import java.util.Vector;

public class Biblioteca {
	GestionLibros gl=new GestionLibros();
	GestionArticulos ga=new GestionArticulos();
	GestionCdrom gc=new GestionCdrom();
	GestionRevista gr=new GestionRevista();
	GestionUsuario gu=new GestionUsuario();
	private Vector<Prestamo> prestamos=new Vector<Prestamo>(); 
	public void menu() {
		int opcion=0;
		do{
			System.out.println("_____________________________");
			System.out.println("1. Gestión de Libros");
			System.out.println("2. Gestión de articulos");
			System.out.println("3. Gestión de Revistas");
			System.out.println("4. Gestión de CD-Roms");
			System.out.println("5. Gestión de Usuarios");
			System.out.println("6. Realizar Prestamo");
			System.out.println("7. Devolver Prestamo");
			System.out.println("8. Mostrar Prestamos activos");
			System.out.println("9. Mostrar Prestamos devueltos");
			System.out.println("0. Salir");
			System.out.println("_____________________________");
			opcion=PedirDatos.leerEntero("Elija una opción");
			
			switch (opcion) {
			case 1:
				gl.menu();
				break;
			case 2:
				ga.menu();
				break;
			case 3:
				gr.menu();
				break;
			case 4:
				gc.menu();
				break;
			case 5:
				gu.menu();
				break;
			case 6:
				nuevoPrestamo();
				break;
			case 7:
				devolverPrestamo();
				break;
			case 8:
				mostrarPrestamos(true);
				break;
			case 9:
				mostrarPrestamos(false);
				break;
			case 0:
				System.out.println("Adios!!!");
				break;
			default:
				System.out.println("Debe introducir un numero entre 0 y 4");
				break;
			}
		}while(opcion!=0);
	}
	
	private int buscarPrestamo(char tipomaterial, String codmaterial){
		for(int i=0; i<prestamos.size();i++){
			Prestamo p=prestamos.elementAt(i);
			if((p.getTipomaterial()==tipomaterial)&&
				(p.getCodmaterial().equals(codmaterial))&&
				(p.getFechadevolucion()==null)){
				return i;
			}
		}
		return -1;
	}

	private void nuevoPrestamo() {
		String codusuario=PedirDatos.leerCadena("Dime el código del usuario que realiza el prestamo");
		if(gu.buscarUsuario(codusuario)==-1){
			System.out.println("El usuario no existe. No se puede realizar el prestamo");
			return;
		}
		
		char tipomaterial=PedirDatos.leerCaracter("Introduzca el tipo [L:Libro, A:Articulo, R:revista, C:CDRom]");
		String codmaterial;
		switch (tipomaterial) {
		case 'L':
			codmaterial=PedirDatos.leerCadena("Introduzca el ISBN del libro a prestar");
			if(gl.buscarLibro(codmaterial)==-1){
				System.out.println("No existe el libro que desea prestar");
				return;
			}
			break;
		case 'A':
			codmaterial=PedirDatos.leerCadena("Introduzca el código del articulo a prestar");
			if(ga.buscarArticulo(codmaterial)==-1){
				System.out.println("No existe el Articulo que desea prestar");
				return;
			}
			break;
		case 'R':
			codmaterial=PedirDatos.leerCadena("Introduzca el código de la revista a prestar");
			if(gr.buscarRevista(codmaterial)==-1){
				System.out.println("No existe la Revista que desea prestar");
				return;
			}
			break;
		case 'C':
			codmaterial=PedirDatos.leerCadena("Introduzca el código del CDRom a prestar");
			if(gc.buscarCdrom(codmaterial)==-1){
				System.out.println("No existe el CDRom que desea prestar");
				return;
			}
			break;
		default:
			System.out.println("No existe el tipo de material que ha solicitado");
			return;
		}
		int pos=buscarPrestamo(tipomaterial, codmaterial);
		if(pos>=0){
			System.out.println("El prestamo ya se ha realizado, no puede volver a prestarlo.");
			return;
		}
		
		String fechaprestamo=PedirDatos.leerCadena("Introduzca la fecha del prestamo");
		
		Prestamo p=new Prestamo(codusuario, tipomaterial, codmaterial, fechaprestamo);
		prestamos.addElement(p);
	}
	
	private void devolverPrestamo(){
		char tipomaterial=PedirDatos.leerCaracter("Introduzca el tipo de material a devolver [L:Libro, A:Articulo, R:revista, C:CDRom]: ");
		String codmaterial=PedirDatos.leerCadena("Introduzca el codigo de material a devolver: ");
		int pos=buscarPrestamo(tipomaterial, codmaterial);
		if(pos ==-1){
			System.out.println("El prestamo no existe, no puede devolverlo");
			return;
		}
		String fechadevolucion=PedirDatos.leerCadena("Introduzca la fecha de devolucion: ");
		prestamos.elementAt(pos).setFechadevolucion(fechadevolucion);
		System.out.println("El prestamo se ha devuelto correctamente.");
	}
	private String mostrarPrestamo(Prestamo p){
		String ret="";
		String nombreusuario=gu.buscarNombreUsuario(p.getCodusuario());
		String titulo="";
		switch (p.getTipomaterial()) {
		case 'L':
			titulo=gl.buscarTituloLibro(p.getCodmaterial());
			break;
		case 'R':
			titulo=gr.buscarTituloRevista(p.getCodmaterial());
			break;
		case 'C':
			titulo=gc.buscarTituloCd(p.getCodmaterial());
			break;
		case 'A':
			titulo=ga.buscarTituloArticulo(p.getCodmaterial());
			break;
		default:
			break;
		}
		if(p.getTipomaterial()=='L'){
			if(p.getFechadevolucion()==null){
				return nombreusuario+" se ha llevado el Libro con titulo "+titulo+". Con fecha de prestamo "+p.getFechaprestamo();
			}else{
			return nombreusuario+" se ha llevado el Libro con titulo "+titulo+". Con fecha de prestamo "+p.getFechaprestamo()+" con fecha de devolucion "+p.getFechadevolucion();
			}
		}
		if(p.getTipomaterial()=='C'){
			if(p.getFechadevolucion()==null){
				return nombreusuario+" se ha llevado el CDROM con titulo "+titulo+". Con fecha de prestamo "+p.getFechaprestamo();
			}else{
			return nombreusuario+" se ha llevado el CDROM con titulo "+titulo+". Con fecha de prestamo "+p.getFechaprestamo()+" con fecha de devolucion "+p.getFechadevolucion();
			}
		}
		if(p.getTipomaterial()=='A'){
			if(p.getFechadevolucion()==null){
				return nombreusuario+" se ha llevado el Articulo con titulo "+titulo+". Con fecha de prestamo "+p.getFechaprestamo();
			}else{
			return nombreusuario+" se ha llevado el Articulo con titulo "+titulo+". Con fecha de prestamo "+p.getFechaprestamo()+" con fecha de devolucion "+p.getFechadevolucion();
			}
		}
		if(p.getTipomaterial()=='R'){
			if(p.getFechadevolucion()==null){
				return nombreusuario+" se ha llevado la Revista con titulo "+titulo+". Con fecha de prestamo "+p.getFechaprestamo();
			}else{
			return nombreusuario+" se ha llevado la Revista con nombre "+titulo+". Con fecha de prestamo "+p.getFechaprestamo()+" con fecha de devolucion "+p.getFechadevolucion();
			}
		}
		return ret;
	}
	
	private void mostrarPrestamos(boolean activos){
		for (int i = 0; i < prestamos.size(); i++) {
			Prestamo p=prestamos.elementAt(i);
			if(activos&&(p.getFechadevolucion()==null)){
				System.out.println(mostrarPrestamo(p));	
			}else if(!activos&&p.getFechadevolucion()!=null){
				System.out.println(mostrarPrestamo(p));	
			}
		}	
	}
}
