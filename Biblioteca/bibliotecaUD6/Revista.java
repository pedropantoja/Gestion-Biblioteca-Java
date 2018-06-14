package bibliotecaUD6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Revista {
	//Atributos
	String codigo;
	String signatura;
	String nombre;
	String materia;
	
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public Revista(String codigo, String signatura, String nombre, String materia) {
		super();
		this.codigo = codigo;
		this.signatura = signatura;
		this.nombre = nombre;
		this.materia = materia;
	}
	
	public Revista() {
		// TODO Apéndice de constructor generado automáticamente
	}

	//getters y setters
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	//toString
	@Override
	public String toString() {
		return "Revistas [codigo=" + codigo + ", signatura=" + signatura + ", nombre=" + nombre + ", materia=" + materia
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		if (codigo != other.codigo)
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (signatura == null) {
			if (other.signatura != null)
				return false;
		} else if (!signatura.equals(other.signatura))
			return false;
		return true;
	}
	
	public void pedirRevista(String codigo) throws IOException{
		this.codigo=codigo;
		System.out.println("Introduce la signatura de la revista");
		this.signatura=teclado.readLine();
		System.out.println("Introduce el nombre de la revista");
		this.nombre=teclado.readLine();		
		System.out.println("Introduce la materia de la revista");
		this.materia=teclado.readLine();
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
		linea+=addEspacios(this.nombre,20);
		linea+=addEspacios(this.materia, 20);
		return linea;	
	}
	
	public void descomponerLinea(String linea){
		this.codigo=linea.substring(0, 4).trim();
		this.signatura=linea.substring(4,24).trim();
		this.nombre=linea.substring(24, 44).trim();
		this.materia=linea.substring(44, 64).trim();
	}
	
	
	
}
