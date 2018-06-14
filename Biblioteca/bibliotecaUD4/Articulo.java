package bibliotecaUD4;

public class Articulo {
	
	private long codarticulo;
	private String titulo;
	private String autor;
	private int numpaginas;
	private String keywords;
	
	public Articulo(){
		
	}
	
	public Articulo(long codarticulo, String titulo, String autor, int numpaginas, String keywords) {
		this.codarticulo = codarticulo;
		this.titulo = titulo;
		this.autor = autor;
		this.numpaginas = numpaginas;
		this.keywords = keywords;
	}

	public long getCodarticulo() {
		return codarticulo;
	}

	public void setCodarticulo(long codarticulo) {
		this.codarticulo = codarticulo;
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

	public int getNumpaginas() {
		return numpaginas;
	}

	public void setNumpaginas(int numpaginas) {
		this.numpaginas = numpaginas;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "codarticulo=" + codarticulo + ", titulo=" + titulo + ", autor=" + autor + ", numpaginas="
				+ numpaginas + ", keywords=" + keywords;
	}
}
