package bibliotecaUD5;

public class Libro {

	private String ISBN;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;

	public Libro() {
		// TODO Apéndice de constructor generado automáticamente
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

	public void pedirLibro(){
		this.autor=PedirDatos.leerCadena("introduzca el autor del libro");
		this.editorial=PedirDatos.leerCadena("introduzca la editorial del libro");
		this.ISBN=PedirDatos.leerCadena("introduzca el ISBN del libro");
		this.materia=PedirDatos.leerCadena("introduzca la materia del libro");
		this.signatura=PedirDatos.leerCadena("introduzca la signatura del libro");
		this.titulo=PedirDatos.leerCadena("introduzca el titulo del libro");
	}
	public void pedirLibro(String ISBN){
		this.autor=PedirDatos.leerCadena("introduzca el autor del libro");
		this.editorial=PedirDatos.leerCadena("introduzca la editorial del libro");
		this.ISBN=ISBN;
		this.materia=PedirDatos.leerCadena("introduzca la materia del libro");
		this.signatura=PedirDatos.leerCadena("introduzca la signatura del libro");
		this.titulo=PedirDatos.leerCadena("introduzca el titulo del libro");
	}
}
