package bibliotecaUD7;

import java.io.*;

public class Prestamo {
	private String codusuario;
	private String tipomaterial;
	private String codmaterial;
	private String fechaprestamo;
	private String fechadevolucion;
	
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public Prestamo() {
	
	}
	
	public Prestamo(String codusuario, String tipomaterial, String codmaterial, String fechaprestamo) {
		super();
		this.codusuario = codusuario;
		this.tipomaterial = tipomaterial;
		this.codmaterial = codmaterial;
		this.fechaprestamo = fechaprestamo;
	}


	public String getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}

	public String getTipomaterial() {
		return tipomaterial;
	}

	public void setTipomaterial(String tipomaterial) {
		this.tipomaterial = tipomaterial;
	}

	public String getCodmaterial() {
		return codmaterial;
	}

	public void setCodmaterial(String codmaterial) {
		this.codmaterial = codmaterial;
	}

	public String getFechaprestamo() {
		return fechaprestamo;
	}

	public void setFechaprestamo(String fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}

	public String getFechadevolucion() {
		return fechadevolucion;
	}

	public void setFechadevolucion(String fechadevolucion) {
		this.fechadevolucion = fechadevolucion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codmaterial == null) ? 0 : codmaterial.hashCode());
		result = prime * result + ((codusuario == null) ? 0 : codusuario.hashCode());
		result = prime * result + ((fechadevolucion == null) ? 0 : fechadevolucion.hashCode());
		result = prime * result + ((fechaprestamo == null) ? 0 : fechaprestamo.hashCode());
		result = prime * result + ((tipomaterial == null) ? 0 : tipomaterial.hashCode());
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
		Prestamo other = (Prestamo) obj;
		if (codmaterial == null) {
			if (other.codmaterial != null)
				return false;
		} else if (!codmaterial.equals(other.codmaterial))
			return false;
		if (codusuario == null) {
			if (other.codusuario != null)
				return false;
		} else if (!codusuario.equals(other.codusuario))
			return false;
		if (fechadevolucion == null) {
			if (other.fechadevolucion != null)
				return false;
		} else if (!fechadevolucion.equals(other.fechadevolucion))
			return false;
		if (fechaprestamo == null) {
			if (other.fechaprestamo != null)
				return false;
		} else if (!fechaprestamo.equals(other.fechaprestamo))
			return false;
		if (tipomaterial == null) {
			if (other.tipomaterial != null)
				return false;
		} else if (!tipomaterial.equals(other.tipomaterial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prestamo [codusuario=" + codusuario + ", tipomaterial=" + tipomaterial + ", codmaterial=" + codmaterial
				+ ", fechaprestamo=" + fechaprestamo + ", fechadevolucion=" + fechadevolucion + "]";
	}
	
	public void pedirPrestamo(String codusuario) throws IOException{
		this.codusuario=codusuario;
		System.out.println("Introduce el tipo de material");
		this.tipomaterial=teclado.readLine();
		System.out.println("Introduce el codigo de material");
		this.codmaterial=teclado.readLine();
		System.out.println("Introduce la fecha de prestamo");
		this.fechaprestamo=teclado.readLine();
		System.out.println("Introduce la fecha de devolucion");
		this.fechadevolucion=teclado.readLine();
	}
}
