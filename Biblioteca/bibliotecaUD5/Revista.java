package bibliotecaUD5;

public class Revista {

	String codigo;
	String signatura;
	String nombre;
	String materia;

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
	
	public void pedirRevista(){
		this.codigo=PedirDatos.leerCadena("intoduzca elcodigo de la ravista");
		this.materia=PedirDatos.leerCadena("intoduzca la materia de la ravista");
		this.nombre=PedirDatos.leerCadena("introduzca el nombre de la revista");
		this.signatura=PedirDatos.leerCadena("introduzca la signatura de la revista");
	}
	
	public void pedirRevista(String codigo){
		this.codigo=codigo;
		this.materia=PedirDatos.leerCadena("intoduzca la materia de la ravista");
		this.nombre=PedirDatos.leerCadena("introduzca el nombre de la revista");
		this.signatura=PedirDatos.leerCadena("introduzca la signatura de la revista");
	}
}
