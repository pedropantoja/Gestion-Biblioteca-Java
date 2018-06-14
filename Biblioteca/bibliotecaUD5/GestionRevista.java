package bibliotecaUD5;

public class GestionRevista {
	private Revista[] revistas= new Revista[2000];
	private int posicion;
	
	public void menu(){
		int opcion=0;
		do{
			System.out.println("_____________________________");
			System.out.println("1. Añadir Revista");
			System.out.println("2. Listar Revista");
			System.out.println("3. Modificar Revista");
			System.out.println("4. Eliminar Revista");
			System.out.println("0. Volver al menú principal");
			opcion=PedirDatos.leerEntero("Elija una opción");
			
			switch (opcion) {
			case 1:
				addRevista();
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
				System.out.println("Debe introducir un numero entre 0 y 4");
				break;
			}
		}while(opcion!=0);
	}
	
	public int buscarRevista(String codigo){
		for(int i=0;i<posicion;i++){
			if(revistas[i].getCodigo().equals(codigo)){
				return i;
			}
		}
		return -1;
	}
	
	public String buscarTituloRevista(String codigo){
		int pos=buscarRevista(codigo);
		Revista r=revistas[pos];
		return r.getNombre();
	}

	private void listarRevista() {
		for(int i=0;i<posicion;i++){
			System.out.println(revistas[i]);
		}
	}

	private void eliminarRevista() {
		String codigo=PedirDatos.leerCadena("Introduzca el código de la revista a eliminar");
		int pos=buscarRevista(codigo);
		if(pos==-1){
			System.out.println("No existe ningúna revista con código "+codigo+". No puede borrar nada");
			return;
		}
		for(int i=pos;i<posicion;i++){
			revistas[i]=revistas[i+1];
		}
		posicion--;
	}

	private void modificarRevista() {
		String codigo=PedirDatos.leerCadena("Introduzca el código de la revista a modificar");
		int pos=buscarRevista(codigo);
		if(pos==-1){
			System.out.println("No existe ningúna revista con código "+codigo+". No puede modificar nada");
			return;
		}
		Revista re=new Revista();
		re.pedirRevista(codigo);
		revistas[pos]=re;
	}

	private void addRevista() {
		Revista r=new Revista();
		System.out.println("Introduzca la nueva Revista");
		r.pedirRevista();
		if (buscarRevista(r.getCodigo())==-1) {
			revistas[posicion]=r;
			posicion++;
		}else{
			System.out.println("La Revista con código "+r.getCodigo()+" ya existe");
		}
	}	
}
