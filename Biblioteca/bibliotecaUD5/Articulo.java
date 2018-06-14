package bibliotecaUD5;

public class Articulo {
	
	private String codigo;
	private String titulo;
	private String autor;
	private int paginas;
	
	public Articulo() {
		// TODO Apéndice de constructor generado automáticamente
	}
	
	public Articulo(String codigo, String titulo, String autor, int paginas) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;	
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	@Override
	public String toString() {
		return "Articulos [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codigo != other.codigo)
			return false;
		if (paginas != other.paginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	public void pedirArticulo(){
		this.codigo=PedirDatos.leerCadena("inserte el código del articulo");
		this.titulo = PedirDatos.leerCadena("inserte el titulo del articulo");
		this.autor = PedirDatos.leerCadena("inserte el autor del Articulo");
		this.paginas = PedirDatos.leerEntero("inserte el numero de paginas del articulo");
	}
	public void pedirArticulo(String codigo){
		this.codigo=codigo;
		this.titulo = PedirDatos.leerCadena("inserte el titulo del articulo");
		this.autor = PedirDatos.leerCadena("inserte el autor del Articulo");
		this.paginas = PedirDatos.leerEntero("inserte el numero de paginas del articulo");
	}	
}
