package bibliotecaUD7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Usuario {
	
	 private String codigo;
	 private String nombre;
	 private String apellidos1;
	 private String apellidos2;
	
	 BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	 
	public Usuario() {
		
	}
	 
	public Usuario(String codigo, String nombre, String apellidos1, String apellidos2) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos1 = apellidos1;
		this.apellidos2 = apellidos2;
	}	
	
		
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos1() {
		return apellidos1;
	}

	public void setApellidos1(String apellidos1) {
		this.apellidos1 = apellidos1;
	}

	public String getApellidos2() {
		return apellidos2;
	}

	public void setApellidos2(String apellidos2) {
		this.apellidos2 = apellidos2;
	}
	//toString
	@Override
	public String toString() {
		return "Usuarios [codigo=" + codigo + ", nombre=" + nombre + ", apellidos1=" + apellidos1 + ", apellidos2="
				+ apellidos2 + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidos1 == null) {
			if (other.apellidos1 != null)
				return false;
		} else if (!apellidos1.equals(other.apellidos1))
			return false;
		if (apellidos2 == null) {
			if (other.apellidos2 != null)
				return false;
		} else if (!apellidos2.equals(other.apellidos2))
			return false;
		if (codigo != other.codigo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public void pedirUsuario(String codigo) throws IOException{
		this.codigo=codigo;
		System.out.println("Introduce el nombre del usuario");
		this.nombre=teclado.readLine();
		System.out.println("Introduce el apellido1 del usuario");
		this.apellidos1=teclado.readLine();
		System.out.println("Introduce el apellido2 del usuario");
		this.apellidos2=teclado.readLine();
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
		linea+=addEspacios(this.nombre,20);
		linea+=addEspacios(this.apellidos1,20);
		linea+=addEspacios(this.apellidos2, 20);
		return linea;	
	}
	
	public void descomponerLinea(String linea){
		this.codigo=linea.substring(0, 4).trim();
		this.nombre=linea.substring(4,24).trim();
		this.apellidos1=linea.substring(24, 44).trim();
		this.apellidos2=linea.substring(44, 64).trim();
	}	
}
