package bibliotecaUD5;

public class Cdrom {

	private String codigo;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;

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
	public void pedirCdrom(String codigo){
		this.codigo=codigo;
		this.signatura = PedirDatos.leerCadena("introduzca la signatura");
		this.titulo = PedirDatos.leerCadena("introduzca el titulo");
		this.autor = PedirDatos.leerCadena("introduzca el autor");
		this.materia = PedirDatos.leerCadena("introduzca la materia");
		this.editorial = PedirDatos.leerCadena("introduzca la editorial");
	}
}
