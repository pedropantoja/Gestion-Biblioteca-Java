package bibliotecaUD6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Libro {
	
	private String ISBN;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public Libro() {
		
	}
	public Libro(String ISBN, String signatura, String titulo, String autor, String materia, String editorial) {
		super();
		this.ISBN = ISBN;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
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
		return "Libros [ISBN=" + ISBN + ", signatura=" + signatura + ", titulo=" + titulo + ", autor=" + autor
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
		Libro other = (Libro) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
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

	public void pedirLibro(String ISBN) throws IOException{
		this.ISBN=ISBN;
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
		linea+=addEspacios(this.ISBN,4);
		linea+=addEspacios(this.signatura,20);
		linea+=addEspacios(this.titulo,20);
		linea+=addEspacios(this.autor, 20);
		linea+=addEspacios(this.materia, 20);
		linea+=addEspacios(this.editorial, 20);
		return linea;	
	}
	
	public void descomponerLinea(String linea){
		this.ISBN=linea.substring(0, 4).trim();
		this.signatura=linea.substring(4,24).trim();
		this.titulo=linea.substring(24, 44).trim();
		this.autor=linea.substring(44, 64).trim();
		this.materia=linea.substring(64, 84).trim();
		this.editorial=linea.substring(84, 104).trim();
	}

}
