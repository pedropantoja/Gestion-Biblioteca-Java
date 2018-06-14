package bibliotecaUD5;

public class GestionArticulos {

	private Articulo[] articulos=new Articulo[2000];
	private int posicion=0;
	
	public void menu(){
		int opcion=0;
		do{
			System.out.println("_____________________________");
			System.out.println("1. Añadir articulo");
			System.out.println("2. Listar articulos");
			System.out.println("3. Modificar articulo");
			System.out.println("4. Eliminar articulo");
			System.out.println("0. Volver al menú principal");
			opcion=PedirDatos.leerEntero("Elija una opción");
			
			switch (opcion) {
			case 1:
				addArticulo();
				break;
			case 2:
				listarArticulos();
				break;
			case 3:
				modificarArticulo1();
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
	
	private void eliminarArticulo() {
		String codigo=PedirDatos.leerCadena("Introduzca el código del articulo a eliminar");
		int pos=buscarArticulo(codigo);
		if(pos==-1){
			System.out.println("No existe ningún articulo con código "+codigo+". No puede borrar nada");
			return;
		}
		
		for(int i=pos;i<posicion;i++){
			articulos[i]=articulos[i+1];
		}
		posicion--;
	}

	private void listarArticulos() {
		for(int i=0;i<posicion;i++){
			System.out.println(articulos[i]);
		}
	}

	private void addArticulo(){
		Articulo a=new Articulo();
		System.out.println("Introduzca el nuevo articulo");
		a.pedirArticulo();
		if(buscarArticulo(a.getCodigo())==-1){
			articulos[posicion]=a;
			posicion++;
		}else{
			System.out.println("El articulo con código "+a.getCodigo()+" ya existe");
		}
	}
	
	private void modificarArticulo1(){
		String codigo=PedirDatos.leerCadena("Introduzca el código del articulo a modificar");
		int pos=buscarArticulo(codigo);
		if(pos==-1){
			System.out.println("No existe ningún articulo con código "+codigo+". No puede modificar nada");
			return;
		}
		Articulo a=new Articulo();	
		a.pedirArticulo(codigo);
		articulos[pos]=a;
	}
	
	private void modificarArticulo(){
		System.out.println("introduzca el articulo a modificar");
		Articulo a=new Articulo();
		a.pedirArticulo();
		int pos=buscarArticulo(a.getCodigo());
		if(pos==-1){
			System.out.println("No existe ningún articulo con código "+a.getCodigo()+". No puede modificar nada");
			return;
		}	
		articulos[pos]=a;
	}
	
	public int buscarArticulo(String codigo){
		for(int i=0;i<posicion;i++){
			if(articulos[i].getCodigo().equals(codigo)){
				return i;
			}
		}
		return -1;
	}
	
	public String buscarTituloArticulo(String codigo){
		int pos=buscarArticulo(codigo);
		Articulo a=articulos[pos];
		return a.getTitulo();
	}
}
