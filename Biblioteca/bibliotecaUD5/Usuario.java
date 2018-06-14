package bibliotecaUD5;

public class Usuario {

	 private String codigo;
	 private String nombre;
	 private String apellidos1;
	 private String apellidos2;

	public Usuario() {
		// TODO Apéndice de constructor generado automáticamente
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
	public void pedirUsuario(){
		this.codigo=PedirDatos.leerCadena("introduzca el código de usuario");
		this.nombre=PedirDatos.leerCadena("introduzca el nombre del usuario");
		this.apellidos1=PedirDatos.leerCadena("introdusca el primer apellido del usuario");
		this.apellidos2=PedirDatos.leerCadena("introduzca el segundo apellido del usuario");
	}
	public void pedirUsuario(String codigo){
		this.nombre=PedirDatos.leerCadena("introduzca el nombre del usuario");
		this.apellidos1=PedirDatos.leerCadena("introdusca el primer apellido del usuario");
		this.apellidos2=PedirDatos.leerCadena("introduzca el segundo apellido del usuario");
		this.codigo=codigo;
	}
}
