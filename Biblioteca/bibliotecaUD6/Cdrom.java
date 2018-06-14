package bibliotecaUD6;

import java.io.*;

public class Cdrom {

	private String codigo;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;

	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public Cdrom() {
	}
	public Cdrom(String codigo, String signatura, String titulo, String autor, String materia, String editorial) {
		super();
		this.codigo = codigo;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getSignatura() {
		return signatura;
	}
	public void setSignatura(String signatura) {
		this.signatura = signatura;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	//toString

	@Override
	public String toString() {
		return "CDROMs [codigo=" + codigo + ", signatura=" + signatura + ", titulo=" + titulo + ", autor=" + autor
				+ ", materia=" + materia + ", editorial=" + editorial + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cdrom other = (Cdrom) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codigo != other.codigo)
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (signatura == null) {
			if (other.signatura != null)
				return false;
		} else if (!signatura.equals(other.signatura))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public void pedirCdrom(){
		this.codigo=PedirDatos.leerCadena("Introduce el código del CDROM");
		this.signatura = PedirDatos.leerCadena("introduzca la signatura");
		this.titulo = PedirDatos.leerCadena("introduzca el titulo");
		this.autor = PedirDatos.leerCadena("introduzca el autor");
		this.materia = PedirDatos.leerCadena("introduzca la materia");
		this.editorial = PedirDatos.leerCadena("introduzca la editorial");
	}
	public void pedirCdrom(String codigo) throws IOException{
		this.codigo=codigo;
		System.out.println("Introduce la signatura");
		this.signatura =teclado.readLine();
		System.out.println("Introduce el titulo");
		this.titulo =teclado.readLine();
		System.out.println("Introduce el autor");
		this.autor = teclado.readLine();
		System.out.println("Introduce la materia");
		this.materia = teclado.readLine();
		System.out.println("Introduce la editorial");
		this.editorial = teclado.readLine();
	}
	private String addEspacios(String cadena,int longitud){
		String ret=cadena;
		for(int i=cadena.length();i<longitud;i++){
			ret+=" ";
		}
		return ret.substring(0, longitud);
	}
	
	public String  crearLinea() {
		String linea="";
		linea+=addEspacios(this.codigo,4);
		linea+=addEspacios(this.signatura,20);
		linea+=addEspacios(this.titulo,20);
		linea+=addEspacios(this.autor, 20);
		linea+=addEspacios(this.materia, 20);
		linea+=addEspacios(this.editorial, 20);
		return linea;	
	}
	
	public void descomponerLinea(String linea){
		this.codigo=linea.substring(0, 4).trim();
		this.signatura=linea.substring(4,24).trim();
		this.titulo=linea.substring(24, 44).trim();
		this.autor=linea.substring(44, 64).trim();
		this.materia=linea.substring(64, 84).trim();
		this.editorial=linea.substring(84, 104).trim();
	}
}
