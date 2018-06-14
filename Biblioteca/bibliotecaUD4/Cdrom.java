package bibliotecaUD4;

public class Cdrom {
	
	private long codcdrom;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public Cdrom(){
		
	}
	
	public Cdrom(long codcdrom, String signatura, String titulo, String autor, String materia, String editorial) {
		this.codcdrom = codcdrom;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}

	public long getCodcdrom() {
		return codcdrom;
	}

	public void setCodcdrom(long codcdrom) {
		this.codcdrom = codcdrom;
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
		return "codcdrom=" + codcdrom + ", signatura=" + signatura + ", titulo=" + titulo + ", autor=" + autor
				+ ", materia=" + materia + ", editorial=" + editorial;
	}
	
	
	
	

}
