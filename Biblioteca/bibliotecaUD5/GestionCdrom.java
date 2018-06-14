package bibliotecaUD5;

public class GestionCdrom {
	
	private Cdrom[] cdroms = new Cdrom[2000];
	private int posicion = 0;

	public void menu(){
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
				modificarCdrom();
				break;
			case 4:
				eliminarCdrom();
				break;
			case 0:
				
				break;
			default:
				System.out.println("Debe introducir un número del 0 al 4.");
				break;
			}
		} while (opcion!=0);
	}
	
	public int buscarCdrom(String codigo){
		for (int i = 0; i < posicion; i++) {
			if (codigo.equals(cdroms[i].getCodigo())) {
				return i;
			}
		}
		return -1;
	}
	
	public String buscarTituloCd(String codigo){
		int pos=buscarCdrom(codigo);
		Cdrom c=cdroms[pos];
		return c.getTitulo();
	}
	
	private void addCdrom(){
		Cdrom cd = new Cdrom();
		cd.pedirCdrom();
		if (buscarCdrom(cd.getCodigo())>=0) {
			System.out.println("ya existe un cdrom con el codigo "+cd.getCodigo());
			return;
		}	
		cdroms[posicion] = cd;
		posicion++;
	}
	
	private void listarCdroms(){
		for (int i = 0; i < posicion; i++) {
			System.out.println(cdroms[i]);
		}
	}
	
	private void modificarCdrom(){
		String codigo=PedirDatos.leerCadena("introduzca el codigo del Cdrom a modificar");
		int pos=buscarCdrom(codigo);
		if (pos==-1) {
			System.out.println("no existe ningun cdrom con codigo "+codigo);
			return;
		}
		Cdrom cd = new Cdrom();
		cd.pedirCdrom(codigo);
		cdroms[pos] = cd;	
	}
	
	private void eliminarCdrom(){
		String codigo=PedirDatos.leerCadena("Introduzca el código del cdrom a eliminar");
		int pos=buscarCdrom(codigo);
		if(pos==-1){
			System.out.println("El cdrom a eliminar no existe");
			return;
		}
		for(int i=pos;i<posicion;i++){
			cdroms[i]=cdroms[i+1];		
		}
		posicion--;
	}
}
