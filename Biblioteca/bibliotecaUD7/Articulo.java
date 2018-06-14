package bibliotecaUD7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Articulo {
	
	private int codigo;
	private String titulo;
	private String autor;
	private int paginas;
	
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public Articulo() {
	}
	
	public Articulo(int codigo, String titulo, String autor, int paginas) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;	
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + codigo;
		result = prime * result + paginas;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
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
	
	@Override
	public String toString() {
		return "codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + "]";
	}
	
	public void pedirArticulo(int codigo) throws IOException{
		boolean seguir=true;
		do{
			try{
		this.codigo=codigo;
		seguir=false;
			}catch(NumberFormatException e){
				System.out.println("Dame un numero decimal.");
			}
		}while(seguir);
		System.out.println("Inserte el titulo del articulo");
		this.titulo = teclado.readLine();
		System.out.println("Inserte el autor del articulo");
		this.autor = teclado.readLine();
		System.out.println("Inserte el numero de paginas del articulo");
		seguir=true;
		do{
			try{
		this.paginas = Integer.parseInt(teclado.readLine());
		seguir=false;
			}catch(NumberFormatException e){
				System.out.println("Dame un numero decimal.");
			}
		}while(seguir);
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
		linea+=addEspacios(""+this.codigo,4);
		linea+=addEspacios(this.titulo,20);
		linea+=addEspacios(this.autor,20);
		linea+=addEspacios(""+this.paginas, 4);
		return linea;	
	}
	
	public void descomponerLinea(String linea){
		this.codigo=Integer.parseInt(linea.substring(0, 4).trim());
		this.titulo=linea.substring(4,24).trim();
		this.autor=linea.substring(24, 44).trim();
		this.paginas=Integer.parseInt(linea.substring(44,48).trim());	
	}	
}
