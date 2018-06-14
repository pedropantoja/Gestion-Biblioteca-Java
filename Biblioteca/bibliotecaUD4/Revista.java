package bibliotecaUD4;

public class Revista {
	
	private long codrevista;
	private String asignatura;
	private String nombre;
	private String materia;
	
	public Revista(){
		
	}
	
	public Revista(long codrevista, String asignatura, String nombre, String materia) {
		this.codrevista = codrevista;
		this.asignatura = asignatura;
		this.nombre = nombre;
		this.materia = materia;
	}

	public long getCodrevista() {
		return codrevista;
	}

	public void setCodrevista(long codrevista) {
		this.codrevista = codrevista;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
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

	@Override
	public String toString() {
		return "codrevista=" + codrevista + ", asignatura=" + asignatura + ", nombre=" + nombre + ", materia="
				+ materia;
	}
}
