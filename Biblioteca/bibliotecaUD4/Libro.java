package bibliotecaUD4;

public class Libro {
	
	private long ISBN;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public Libro(){
		
	}
	
	public Libro(long iSBN, String signatura, String titulo, String autor, String materia, String editorial) {
		ISBN = iSBN;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
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
		return "ISBN=" + ISBN + ", signatura=" + signatura + ", titulo=" + titulo + ", autor=" + autor
				+ ", materia=" + materia + ", editorial=" + editorial;
	}
}
